package com.amaap.scrabblegame.domain;

public class Validator {

    public  boolean isStringEmpty(String input) {
        return input.isEmpty();

    }

    public  boolean isStringValid(String input) {
        return !input.matches("^[a-zA-Z]+( [a-zA-Z]+)?$");
    }

    public boolean isStringNull(String input) {

        return input == null;
    }
}
