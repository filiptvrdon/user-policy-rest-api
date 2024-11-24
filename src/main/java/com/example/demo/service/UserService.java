package com.example.demo.service;

import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    User createUser(UserDto user);

    User getUserById(UUID id);

    User updateUser(UUID id, User user);

    void deleteUser(UUID id);

    List<User> getAllUsers();
}