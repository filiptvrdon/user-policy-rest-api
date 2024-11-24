package com.example.demo.model.organizationunit;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="organization_units")
public class OrganizationUnit {

    @Id
    private UUID id;
    private String name;
}
