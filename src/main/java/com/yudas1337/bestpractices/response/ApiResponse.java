package com.yudas1337.bestpractices.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponse<T> {

    private Meta meta;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return success(data, "Operation successful", HttpStatus.OK.value());
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return success(data, message, HttpStatus.OK.value());
    }

    public static <T> ApiResponse<T> success(T data, String message, int code) {
        Meta meta = new Meta();
        meta.setStatus("success");
        meta.setMessage(message);
        meta.setCode(code);
        return new ApiResponse<>(meta, data);
    }

    public static <T> ApiResponse<T> errors(T data, String message, int code) {
        Meta meta = new Meta();
        meta.setStatus("error");
        meta.setMessage(message);
        meta.setCode(code);
        return new ApiResponse<>(meta, data);
    }

    @Data
    public static class Meta {
        private int code;
        private String status;
        private String message;
        private Map<String, Object> pagination = new HashMap<>();
    }
}
