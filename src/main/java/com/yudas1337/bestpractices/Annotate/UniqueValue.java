package com.yudas1337.bestpractices.Annotate;

import com.yudas1337.bestpractices.Validator.UniqueValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default "Value must be unique";

    Class<? extends JpaRepository<?, ?>> repository(); // Use the repository type

    String fieldName();

    Class<?>[] groups() default {}; // Add groups parameter

    Class<? extends Payload>[] payload() default {};
}
