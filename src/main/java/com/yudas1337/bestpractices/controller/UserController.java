package com.yudas1337.bestpractices.controller;

import com.yudas1337.bestpractices.Router;
import com.yudas1337.bestpractices.entity.User;
import com.yudas1337.bestpractices.request.RegisterUserRequest;
import com.yudas1337.bestpractices.response.ApiResponse;
import com.yudas1337.bestpractices.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Router.API_PREFIX)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = Router.USERS,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<User> store(@Valid @RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(ApiResponse.success(userService.register(request), "OK", HttpStatus.CREATED.value())).getBody();
    }

    @GetMapping(
            path = Router.USERS,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<List<User>> getAllUsers() {
        return ResponseEntity.ok(ApiResponse.success(userService.findAll(), "OK", 200)).getBody();
    }

}
