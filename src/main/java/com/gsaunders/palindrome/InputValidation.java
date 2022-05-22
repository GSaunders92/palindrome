package com.gsaunders.palindrome;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {
    private List<ValidationRule> rules = new ArrayList<ValidationRule>();
    public void add_rule(ValidationRule rule) {
        rules.add(rule);
    }

    public ValidationRule check_rules(String input) {
        for (ValidationRule rule : rules) {
            if (rule.rule(input)) {
                return rule;
            }
        }
        return null;
    }

}
