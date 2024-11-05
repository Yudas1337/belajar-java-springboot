package com.yudas1337.bestpractices.service;

import com.yudas1337.bestpractices.entity.User;
import com.yudas1337.bestpractices.repository.UserRepository;
import com.yudas1337.bestpractices.request.RegisterUserRequest;
import com.yudas1337.bestpractices.security.BCrypt;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void save(RegisterUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    @Transactional
    public void update(Long id, RegisterUserRequest request) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());
        userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id))
            throw new EntityNotFoundException("User not found or data already deleted.");

        userRepository.deleteById(id);
    }


}
