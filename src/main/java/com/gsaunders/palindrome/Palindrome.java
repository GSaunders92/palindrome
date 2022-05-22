package com.gsaunders.palindrome;

public class Palindrome {
    public static boolean is_palindrome(String input){
        int length = input.length();
        for (int i = 0; i < length / 2 ; i++){
            if(input.charAt(i) != input.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
