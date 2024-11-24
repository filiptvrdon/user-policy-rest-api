package com.example.demo.controller;

import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public interface UserController {

    @PostMapping
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable UUID id);

    @PutMapping("/{id}")
    ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody User user);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers();

    @PutMapping("/{userId}/assignPolicy/{policyId}")
    ResponseEntity<UserDto> assignPolicyToUser(@PathVariable UUID userId, @PathVariable String policyId);
}