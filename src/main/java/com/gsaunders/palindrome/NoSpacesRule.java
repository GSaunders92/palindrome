package com.gsaunders.palindrome;

public class NoSpacesRule implements ValidationRule{
    public boolean rule(String input) {
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == ' ') return true;
        }
        return false;
    }

    public String get_fail_message() {
        return "Please remove spaces from input";
    }
}
