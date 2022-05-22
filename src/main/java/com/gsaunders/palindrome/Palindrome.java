package com.gsaunders.palindrome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    private Cache palindrome_cache;
    private Cache non_palindrome_cache;
    private List<ValidationRule> rules = new ArrayList<ValidationRule>();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Palindrome(Cache palindrome_cache, Cache non_palindrome_cache){
        this.palindrome_cache = palindrome_cache;
        this.non_palindrome_cache = non_palindrome_cache;
    }
    public boolean is_palindrome(String input){
        if(palindrome_cache.contains(input)) {
            logger.info("Retrieved " + input + " from palindrome cache");
            return true;
        }
        else if(non_palindrome_cache.contains(input)) {
            logger.info("Retrieved " + input + " from nonpalindrome cache");
            return false;
        }
        else if (palindrome_check(input)){
            logger.info("Checked "+ input + " is a palindrome");
            palindrome_cache.put(input);
            return true;
        }
        else {
            logger.info("Checked "+ input + " is not a palindrome");
            non_palindrome_cache.put(input);
            return false;
        }
    }

    private boolean palindrome_check(String input){
        int length = input.length();
        for (int i = 0; i < length / 2 ; i++){
            if(input.charAt(i) != input.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public void add_rule(ValidationRule rule) {
        rules.add(rule);
    }

    public ValidationRule check_rules(String input){
        for(ValidationRule rule : rules){
            if(rule.rule(input)){
                return rule;
            }
        }
        return null;
    }
}
