package com.amaap.scrabblegame.domain;

import Exception.EmptyStringException;
import Exception.OtherThanStringException;

public class ScrabbleSimulator {
    Validations validations = new Validations();
    Operations operations=new Operations();
    public int perform(String input) throws EmptyStringException, OtherThanStringException {


        if (validations.isStringEmpty(input)) throw new EmptyStringException("Input can not be empty");

        if (validations.isStringValid(input)) throw new OtherThanStringException("Other than String found");


        return operations.help(input.toUpperCase());


    }


}
