package com.gsaunders.palindrome;

public interface ValidationRule {
    public boolean rule(String input);
    public String get_fail_message();
}
