package com.example.demo.model.user;

import com.example.demo.model.organizationunit.OrganizationUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String firstName;
    private String lastName;
    private String emailAddress; 

    private LocalDate birthDate;
    private LocalDate registeredOn;

    @ManyToMany
    @JoinTable(name = "users_2_organization_units",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_unit_id"))
    private List<OrganizationUnit> organizationUnits;
}
