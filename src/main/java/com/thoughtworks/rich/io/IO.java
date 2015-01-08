package com.thoughtworks.rich.io;

import java.util.Scanner;

public class IO {
    private static IO instance = null;
    private final Scanner scanner = new Scanner(System.in);

    private IO() {
    }

    public static void reset() {
        instance = null;
    }

    public static IO getInstance() {
        if(instance == null)  {
            instance = new IO();
        }
        return instance;
    }

    public String nextLine() {
        if(scanner.hasNext()) {
            return scanner.next();
        }
        return "";
    }

    public void println(String s) {
        System.out.println(s);
    }
}
