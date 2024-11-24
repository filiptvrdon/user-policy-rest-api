package com.example.demo.repository;

import com.example.demo.model.organizationunit.OrganizationUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrganizationUnitRepository extends JpaRepository<OrganizationUnit, UUID> {

    OrganizationUnit findByName(String name);

    @Query("FROM OrganizationUnit u WHERE u.name IN :names")
    List<OrganizationUnit> findAllByNames(List<String> names);
}