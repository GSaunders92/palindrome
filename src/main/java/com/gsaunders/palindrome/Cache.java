package com.gsaunders.palindrome;

interface Cache {
    public boolean contains(String input); // Get Value from cache
    public void put(String input); // add value to Cache
};
