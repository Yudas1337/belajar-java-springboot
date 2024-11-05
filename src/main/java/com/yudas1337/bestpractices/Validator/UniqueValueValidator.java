package com.yudas1337.bestpractices.Validator;

import com.yudas1337.bestpractices.Annotate.UniqueValue;
import com.yudas1337.bestpractices.context.ContextHolder;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    private String fieldName;
    private Class<? extends JpaRepository<?, ?>> repositoryClass;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.repositoryClass = constraintAnnotation.repository();
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Skip validation if value is null
        }

        Long ignoreId = ContextHolder.getId();
        JpaRepository<?, ?> repository = ContextHolder.getBean(repositoryClass);

        System.out.println("Ignore ID " + ignoreId);

        try {
            if (ignoreId != null) {
                Method existsMethod = repositoryClass.getMethod("existsByUsernameAndIdNot", String.class, Long.class);
                return !(Boolean) existsMethod.invoke(repository, value, ignoreId);
            }

            Method existsByFieldMethod = repositoryClass.getMethod("existsBy" + capitalize(fieldName), String.class);
            return !(Boolean) existsByFieldMethod.invoke(repository, value);
        } catch (Exception e) {
            throw new RuntimeException("Validation error", e);
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
