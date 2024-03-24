package models;

import Exception.EmptyStringException;
import Exception.OtherThanStringException;

public class Scrabble {
    Validations validations = new Validations();

    public int perform(String input) throws EmptyStringException, OtherThanStringException {


        if (validations.isStringEmpty(input)) throw new EmptyStringException("Input can not be empty");

        if (validations.isStringValid(input)) throw new OtherThanStringException("Other than String found");


        return Operations.help(input.toUpperCase());


    }


}
