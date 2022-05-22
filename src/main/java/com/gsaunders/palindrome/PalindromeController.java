package com.gsaunders.palindrome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    @GetMapping("/")
    public String index(@RequestParam(name="username") String username) {
        if (Palindrome.is_palindrome(username)){
            return username + " is a Palindrome";
        }
        else {
            return username + " is a not Palindrome";
        }
    }
}