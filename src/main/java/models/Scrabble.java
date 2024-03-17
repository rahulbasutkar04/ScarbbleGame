package models;

import Exception.*;

public class Scrabble {
    Validations validations=new Validations();
    public int perform(String input) throws EmptyStringException, OtherThanStringException {


        if (validations.isStringEmpty(input)) throw new EmptyStringException("Input can not be empty");

        if (validations.isStringValid(input)) throw new OtherThanStringException("Other than String found");


        return help(input.toUpperCase());


    }

    public static int help(String input) {
        String[] letters = {"EAIONRTLSU", "DG", "BCMP", "FHVWY", "K", "JX", "QZ"};
        int[] points = {1, 2, 3, 4, 5, 8, 10};

        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j < letters.length; j++) {
                if (letters[j].contains(String.valueOf(c))) {
                    sum += points[j];
                    break;
                }
            }
        }
        return sum;
    }




}
