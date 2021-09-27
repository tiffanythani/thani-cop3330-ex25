/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tiffany Thani
 */

package org.example;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.io.*;

public class Exercise25 {

    public static void passwordValidator(String input)
    {
        // Checks lowercase letters in string
        int count = input.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));

        for (char l : input.toCharArray())
        {
            if (Character.isUpperCase(l))
                hasUpper = true;
            if (Character.isLowerCase(l))
                hasLower = true;
            if (set.contains(l))
                specialChar = true;
            if (Character.isDigit(l))
                hasDigit = true;

        }

        //Checks the strength of password
        System.out.print("The password '"+input);
        if (hasDigit && hasLower || hasUpper && specialChar
                && (count >= 8))
            System.out.println("' is a very strong password.");
        else if ((hasLower || hasUpper || specialChar)
                && (count >= 8))
            System.out.println("' is a strong password.");
        else if(hasLower || hasUpper && (count < 8))
            System.out.print("' is a weak password.");
        else
            System.out.print("' is a very weak password.");

    }

    // Driver Function
    public static void main(String[] args)
    {
        String input;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Password: ");
        input=sc.nextLine();
        passwordValidator(input);
    }
}
