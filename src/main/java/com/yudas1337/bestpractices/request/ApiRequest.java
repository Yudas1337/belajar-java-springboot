package com.yudas1337.bestpractices.request;

import com.yudas1337.bestpractices.exception.FormValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public abstract class ApiRequest {

    // Method to validate the request
    public void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ApiRequest>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            Map<String, String> errors = new HashMap<>();
            for (ConstraintViolation<ApiRequest> violation : violations) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            throw new FormValidationException(errors);
        }
    }
}
