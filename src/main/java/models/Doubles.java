package models;

public class Doubles extends Operations {
    public static int calculateForLetter(String originalWord, char letterToDouble) {
        int normalSum = help(originalWord);
        int doubledSum = normalSum;

        if (originalWord.indexOf(letterToDouble) != -1) {
            doubledSum = help("" + letterToDouble);
        }

        return (doubledSum * 2) + normalSum;
    }

    public static int calculateForWord(String originalWord, String wordToDouble) {
        int normalSum = help(originalWord);
        int doubledSum = normalSum;

        if (originalWord.contains(wordToDouble)) {
            doubledSum = help(wordToDouble);
        }

        return (doubledSum * 2) + normalSum;
    }
}
