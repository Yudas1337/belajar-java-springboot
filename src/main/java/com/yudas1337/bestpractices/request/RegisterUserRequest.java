package com.yudas1337.bestpractices.request;

import com.yudas1337.bestpractices.Annotate.UniqueValue;
import com.yudas1337.bestpractices.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserRequest {

    @NotBlank(message = "{messages.username.required}")
    @Size(min = 6, max = 20, message = "{messages.username.size}")
    @UniqueValue(
            fieldName = "username",
            repository = UserRepository.class,
            message = "Username must be unique"
    )
    private String username;

    @NotBlank(message = "{messages.password.required}")
    @Size(min = 6, max = 100, message = "{messages.password.size}")
    private String password;

    @NotBlank(message = "{messages.name.required}")
    @Size(min = 3, max = 100, message = "{messages.name.size}")
    private String name;

}
