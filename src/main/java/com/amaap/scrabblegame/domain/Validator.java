package com.amaap.scrabblegame.domain;

public class Validator {

    public static boolean isStringEmpty(String input) {
        return input.isEmpty();

    }

    public static boolean isStringValid(String input) {
        return input != null && input.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)*$");
    }

    public boolean isStringNull(String input) {

        return input == null;
    }
}
