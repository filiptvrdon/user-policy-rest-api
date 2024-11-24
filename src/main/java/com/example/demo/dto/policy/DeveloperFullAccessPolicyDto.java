package com.example.demo.dto.policy;

import com.example.demo.dto.rule.StringRule;
import lombok.Data;

@Data
public class DeveloperFullAccessPolicyDto extends BasePolicyDto {
    StringRule  isMemberOf;
}
