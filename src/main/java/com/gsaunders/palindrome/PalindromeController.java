package com.gsaunders.palindrome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {
    String palindrome_path = "C:\\Users\\George Saunders\\Documents\\palindrome.txt";
    String non_palindrome_path = "C:\\Users\\George Saunders\\Documents\\nonpalindrome.txt";
    Cache palindrome_cache = new HashCache(new DiskStore(palindrome_path));
    Cache non_palindrome_cache = new HashCache(new DiskStore(non_palindrome_path));
    Palindrome palindrome = new Palindrome(palindrome_cache, non_palindrome_cache);
    @GetMapping("/")
    public String index(@RequestParam(name="username") String username) {
        if (palindrome.is_palindrome(username)){
            return username + " is a Palindrome";
        }
        else {
            return username + " is a not Palindrome";
        }
    }
}