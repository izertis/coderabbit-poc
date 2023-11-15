package com.izertis.codacypoc.utils;

public class EmailUtils {
    // Check if an email address is valid using a regular expression
    public static boolean isValid(String email) {
        String regex = "^(.+)@(.+)$";
        return email.matches(regex);
    }
}
