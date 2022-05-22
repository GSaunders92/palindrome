package com.gsaunders.palindrome;

public class Palindrome {
    private Cache palindrome_cache;
    private Cache non_palindrome_cache;

    Palindrome(Cache palindrome_cache, Cache non_palindrome_cache){
        this.palindrome_cache = palindrome_cache;
        this.non_palindrome_cache = non_palindrome_cache;
    }
    public boolean is_palindrome(String input){
        if(palindrome_cache.contains(input)) return true;
        if(non_palindrome_cache.contains(input)) return false;
        boolean res = palindrome_check(input);
        if(res) {
            palindrome_cache.put(input);
        }
        else {
            non_palindrome_cache.put(input);
        }
        return res;
    }

    private static boolean palindrome_check(String input){
        int length = input.length();
        for (int i = 0; i < length / 2 ; i++){
            if(input.charAt(i) != input.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
