package com.yudas1337.bestpractices.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class FormValidationException extends RuntimeException {
    private final Map<String, String> errors;

    public FormValidationException(Map<String, String> errors) {
        this.errors = errors;
    }

}
