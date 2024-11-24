package com.example.demo.repository;

import com.example.demo.model.policy.Policy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PolicyRepository extends JpaRepository<Policy,String> {
}
