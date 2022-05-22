package com.gsaunders.palindrome;

public interface DataStore {
    public void put(String input);

    public String[] get_all();
}
