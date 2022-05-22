package com.gsaunders.palindrome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSpacesRule implements ValidationRule{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public boolean rule(String input) {
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == ' ') {
                logger.warn("User input " + input + " failed spaces check");
                return true;
            }
        }
        return false;
    }

    public String get_fail_message() {
        return "Please remove spaces from input";
    }
}
