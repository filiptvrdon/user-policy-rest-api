package com.example.demo.dto.user;

import com.example.demo.model.organizationunit.OrganizationUnit;
import com.example.demo.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
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
    private List<String> organizationUnits;


    public static UserDto fromEntity(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmailAddress(user.getEmailAddress());
        dto.setOrganizationUnits(user.getOrganizationUnits().stream().map(OrganizationUnit::getName).toList());
        dto.setBirthDate(user.getBirthDate());
        dto.setRegisteredOn(user.getRegisteredOn());
        return dto;
    }

}