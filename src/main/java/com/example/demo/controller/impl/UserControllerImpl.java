package com.example.demo.controller.impl;

import com.example.demo.controller.UserController;
import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Override
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User createdUser = userService.createUser(userDto);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(UserDto.fromEntity(createdUser));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(UserDto.fromEntity(user));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(UserDto.fromEntity(updatedUser));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users.stream().map(UserDto::fromEntity).toList());
    }

    @PutMapping("/{userId}/assignPolicy/{policyId}")
    @Override
    public ResponseEntity<UserDto> assignPolicyToUser(@PathVariable UUID userId, @PathVariable String policyId){
        User user = userService.assignPolicyToUser(userId, policyId);
        UserDto userDto = UserDto.fromEntity(user);
        return ResponseEntity.ok(userDto);

    }

}