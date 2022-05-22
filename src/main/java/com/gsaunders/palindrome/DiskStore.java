package com.gsaunders.palindrome;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiskStore implements DataStore {
    String path;
    DiskStore(String path){
        this.path = path;
    }

    public void put(String input) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            out.println(input);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public String[] get_all() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.err.println(e);
            return new String[0];
        }
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        String[] arr = lines.toArray(new String[0]);
        return arr;
    }
}


