package com.example.demo.service.impl;

import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.User;
import com.example.demo.repository.OrganizationUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrganizationUnitRepository organizationUnitRepository;

    public UserServiceImpl(UserRepository userRepository, OrganizationUnitRepository organizationUnitRepository) {
        this.userRepository = userRepository;
        this.organizationUnitRepository = organizationUnitRepository;
    }

    @Override
    public User createUser(UserDto userDto) {
        User newUser = buildUserFromDto(userDto);
        return userRepository.save(newUser);
    }

    private User buildUserFromDto(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setBirthDate(userDto.getBirthDate());
        user.setRegisteredOn(userDto.getRegisteredOn());

        user.setOrganizationUnits(organizationUnitRepository.findAllByNames(userDto.getOrganizationUnits()));

        return user;
    }


    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(UUID id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {


            // TODO update existing user
            return userRepository.save(existingUser);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}