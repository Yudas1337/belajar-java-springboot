package com.yudas1337.bestpractices.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Map<String, String> errors;
    private String path;

    public ErrorResponse(LocalDateTime timestamp, int status, String message, Map<String, String> errors, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.path = path;
    }
}
