package com.gsaunders.palindrome;

import java.util.HashSet;

public class HashCache implements Cache {
    HashSet<String> stringCache;
    DataStore store;

    HashCache(DataStore store) {
        stringCache = new HashSet<>();
        this.store = store;
        String[] initial_state = store.get_all();
        for (String str : initial_state) {
            stringCache.add(str);
        }
    }

    public boolean contains(String input) {
        boolean res = stringCache.contains(input);
        return res;
    }

    public void put(String input) {
        stringCache.add(input);
        store.put(input);
    }
}
