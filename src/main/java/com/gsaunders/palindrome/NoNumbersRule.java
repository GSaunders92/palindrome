package com.gsaunders.palindrome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoNumbersRule implements ValidationRule {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean rule(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                logger.warn("User input " + input + " failed numbers check");
                return true;
            }
        }
        return false;
    }

    public String get_fail_message() {
        return "Please remove numbers from input";
    }
}