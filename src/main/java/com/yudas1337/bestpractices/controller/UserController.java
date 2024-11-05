package com.yudas1337.bestpractices.controller;

import com.yudas1337.bestpractices.Router;
import com.yudas1337.bestpractices.Util.MessageSourceUtil;
import com.yudas1337.bestpractices.entity.User;
import com.yudas1337.bestpractices.request.RegisterUserRequest;
import com.yudas1337.bestpractices.response.ApiResponse;
import com.yudas1337.bestpractices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Router.API_PREFIX)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(
            path = Router.USERS,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<List<User>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(userService.findAll(), "OK", 200)).getBody();
    }

    @PostMapping(
            path = Router.USERS,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Object> save(@Validated @RequestBody RegisterUserRequest request) {
        userService.save(request);
        return ResponseEntity.ok(ApiResponse.success(
                null,
                MessageSourceUtil.getMessage("add.success"),
                HttpStatus.CREATED.value())).getBody();
    }

    @PatchMapping(
            path = Router.USERS + "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<String> update(@PathVariable Long id, @Validated @RequestBody RegisterUserRequest request) {
        userService.update(id, request);

        return ResponseEntity.ok(ApiResponse.success(
                MessageSourceUtil.getMessage("update.success")
        )).getBody();
    }

    @DeleteMapping(
            path = Router.USERS + "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(
                MessageSourceUtil.getMessage("delete.success")
        )).getBody();
    }
}
