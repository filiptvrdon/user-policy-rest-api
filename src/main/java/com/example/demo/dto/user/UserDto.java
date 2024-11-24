package com.example.demo.dto.user;

import com.example.demo.model.organizationunit.OrganizationUnit;
import com.example.demo.model.policy.Policy;
import com.example.demo.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private String name;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private LocalDate birthDate;
    private LocalDate registeredOn;

    @JsonProperty("organizationUnit")
    private List<String> organizationUnits = new ArrayList<>();

    @JsonProperty("policy")
    private List<String> policies = new ArrayList<>();


    public static UserDto fromEntity(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmailAddress(user.getEmailAddress());
        dto.setBirthDate(user.getBirthDate());
        dto.setRegisteredOn(user.getRegisteredOn());

        if (user.getOrganizationUnits() != null) {
            dto.setOrganizationUnits(user.getOrganizationUnits().stream().map(OrganizationUnit::getName).toList());
        }

        if (user.getPolicies() != null) {
            dto.setPolicies(user.getPolicies().stream().map(Policy::getId).toList());
        }
        return dto;
    }

}