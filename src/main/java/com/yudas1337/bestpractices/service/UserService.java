package com.yudas1337.bestpractices.service;

import com.yudas1337.bestpractices.entity.User;
import com.yudas1337.bestpractices.repository.UserRepository;
import com.yudas1337.bestpractices.request.RegisterUserRequest;
import com.yudas1337.bestpractices.security.BCrypt;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final Validator validator;

    public UserService(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Transactional
    public User register(RegisterUserRequest request) {
        Set<ConstraintViolation<RegisterUserRequest>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
