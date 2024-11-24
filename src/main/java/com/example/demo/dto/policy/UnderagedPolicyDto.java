package com.example.demo.dto.policy;

import com.example.demo.dto.rule.IntegerRule;
import lombok.Data;

@Data
public class UnderagedPolicyDto extends BasePolicyDto {
    IntegerRule youngerThan;
}
