package com.amaap.scrabblegame.domain;

public class Validations {

    public static boolean isStringEmpty(String input) {
        return input.isEmpty();

    }

    public static boolean isStringValid(String input) {
        return !input.matches("^[a-zA-Z]+( [a-zA-Z]+)?$");
    }
}
