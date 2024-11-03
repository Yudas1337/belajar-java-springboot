package com.yudas1337.bestpractices.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserRequest extends ApiRequest {

    @NotBlank(message = "{validation.name.required}")
    @Size(min = 3, max = 100)
    private String username;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
}
