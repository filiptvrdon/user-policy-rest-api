package com.example.demo.service.impl;

import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.User;
import com.example.demo.repository.OrganizationUnitRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrganizationUnitRepository organizationUnitRepository;
    private final PolicyRepository policyRepository;


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

        if (!userDto.getOrganizationUnits().isEmpty()) {
            user.setOrganizationUnits(new HashSet<>(organizationUnitRepository.findAllByNames(userDto.getOrganizationUnits())));
        }
        return user;
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(UUID id, User user) {
        return null; // TODO - implement update
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User assignPolicyToUser(UUID userId, String policyId) {
        User user = userRepository.getReferenceById(userId);
        user.getPolicies().add(policyRepository.getReferenceById(policyId));
        return userRepository.save(user);
    }
}