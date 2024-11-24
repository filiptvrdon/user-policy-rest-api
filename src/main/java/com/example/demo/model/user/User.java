package com.example.demo.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;
    private String firstName;
    private String lastName;
    private String emailAddress; 

    private LocalDate birthDate;
    private LocalDate registeredOn;

    private List<String> organizationUnit;
}
