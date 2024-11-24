package com.example.demo.model.policy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="policies")
public class Policy {

    @Id
    private String id;

    private String name;
    private String ruleName;
    private String ruleValue;

}
