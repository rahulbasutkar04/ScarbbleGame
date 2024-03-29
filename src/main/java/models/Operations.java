package models;

public class Operations {
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

