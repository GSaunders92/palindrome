package com.gsaunders.palindrome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    String palindrome_path;
    String non_palindrome_path;
    Cache palindrome_cache;
    Cache non_palindrome_cache;
    Palindrome palindrome;

    public PalindromeController(){
        String base_path = System.getenv("DiskCachePath");
        palindrome_path = base_path + "\\palindrome.txt";
        non_palindrome_path = base_path + "\\nonpalindrome.txt";
        palindrome_cache = new HashCache(new DiskStore(palindrome_path));
        non_palindrome_cache = new HashCache(new DiskStore(non_palindrome_path));
        palindrome = new Palindrome(palindrome_cache, non_palindrome_cache);
        palindrome.add_rule(new NoNumbersRule());
        palindrome.add_rule(new NoSpacesRule());
    }

    @GetMapping("/")
    public String index(@RequestParam(name="username") String username) {
        logger.info("Checking user input - " + username);
        ValidationRule rule = palindrome.check_rules(username);
        if(rule != null) return rule.get_fail_message();
        if (palindrome.is_palindrome(username)){
            return username + " is a Palindrome";
        }
        else {
            return username + " is not a Palindrome";
        }
    }
}