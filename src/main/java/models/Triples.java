package models;

public class Triples extends Operations {
    public static int calculateForLetter(String originalWord, char letterToTriple) {
        int normalSum = help(originalWord);
        int doubledSum = normalSum;

        if (originalWord.indexOf(letterToTriple) != -1) {
            doubledSum = help("" + letterToTriple);
        }

        return (doubledSum * 3) + normalSum;
    }

    public static int calculateForWord(String originalWord, String wordToTriple) {
        int normalSum = help(originalWord);
        int tripledSum = normalSum;

        if (originalWord.contains(wordToTriple)) {
            tripledSum = help(wordToTriple);
        }

        return (tripledSum * 3) + normalSum;
    }
}
