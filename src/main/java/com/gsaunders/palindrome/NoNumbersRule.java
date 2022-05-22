package com.gsaunders.palindrome;

public class NoNumbersRule implements ValidationRule{
    public boolean rule(String input) {
        for(int i=0;i<input.length();i++){
            if(Character.isDigit(input.charAt(i))) return true;
        }
        return false;
    }

    public String get_fail_message() {
        return "Please remove numbers from input";
    }
}