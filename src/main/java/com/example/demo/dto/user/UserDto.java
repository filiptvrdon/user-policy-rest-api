package com.example.demo.dto.user;

import com.example.demo.model.user.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {

    private String name;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private List<String> organizationUnit;
    private LocalDate birthDate;
    private LocalDate registeredOn;


    public static UserDto fromUser(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmailAddress(user.getEmailAddress());
        dto.setOrganizationUnit(user.getOrganizationUnit());
        dto.setBirthDate(user.getBirthDate());
        dto.setRegisteredOn(user.getRegisteredOn());
        return dto;
    }
}