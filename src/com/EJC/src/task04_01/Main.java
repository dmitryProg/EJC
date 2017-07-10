package com.EJC.src.task04_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String str1 = null;
        StringBuilder str2 = new StringBuilder();
        System.out.println("Enter your word:");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)))
        {
            str1 = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < str1.length(); i++) {
            if (i % 2 != 1) str2.append(str1.charAt(i));
        }
        System.out.println(str2);
    }
}
