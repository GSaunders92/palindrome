package com.gsaunders.palindrome;

public interface ValidationRule {
    boolean rule(String input);

    String get_fail_message();
}
