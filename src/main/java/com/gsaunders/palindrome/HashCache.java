package com.gsaunders.palindrome;

import java.util.HashSet;

public class HashCache implements Cache {
    HashSet<String> stringCache;

    HashCache(){
        stringCache = new HashSet<>();
    }

    public boolean contains(String input) {
        boolean res = stringCache.contains(input);
        return res;
    }

    public void put(String input) {
        stringCache.add(input);
    }
}
