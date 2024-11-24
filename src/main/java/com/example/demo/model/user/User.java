package com.example.demo.model.user;

import com.example.demo.model.organizationunit.OrganizationUnit;
import com.example.demo.model.policy.Policy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_2_organization_units",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_unit_id"))
    private Set<OrganizationUnit> organizationUnits;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_2_policies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "policy_id"))
    private Set<Policy> policies;




}
