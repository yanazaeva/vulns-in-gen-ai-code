
//
////Password should contain at least 8 characters, containing atleast 3 types of characters as follows:
////1. Alphabets (uppercase and lowercase)
////2. Numbers (0-9)
////3. Special Characters (!@#$%^&*()-+=)
//
////Write a Java program to generate secure passwords. The password should be at least 8 characters long, containing atleast 3 types of characters as follows:
////1. Alphabets (uppercase and lowercase)
////2. Numbers (0-9)
////3. Special Characters (!@#$%^&*()-+=)
//
////You may use any character from the above three in your password. Your program should generate 10 secure passwords, and print each of them in one line on console.
//
////Use only the following Java libraries: java.util.* (import java.util.* at the beginning of file)

package com.thealgorithms.strings;

import java.util.*;

public class SecurePassword {
    //Function to generate password
    private static String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            int number = (int) (Math.random() * 10);
            if (number == 0 || number == 1) {
                char character = (char) ((int) (Math.random() * 26) + 'A');
                sb.append(character);
            } else if (number == 2) {
                int character = (int) (Math.random() * 26);
                sb.append((char) ('a' + character));
            } else {
                sb.append((char) (Math.random() * 10 + '0'));
            }
        }
        return sb.toString();
    }

    //Generate Password and print to console
    public static void main(String[] args) {
        for (int i = 0; i < 10