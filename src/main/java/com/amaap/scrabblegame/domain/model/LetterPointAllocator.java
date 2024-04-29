package com.amaap.scrabblegame.domain.model;

public class LetterPointAllocator {

    public int getPoint(char c) {

        switch (c) {
            case 'A': case 'E': case 'I': case 'O': case 'N':
            case 'R': case 'T': case 'L': case 'S': case 'U':
                return 1;
            case 'D': case 'G':
                return 2;
            case 'B': case 'C': case 'M': case 'P':
                return 3;
            case 'F': case 'H': case 'V': case 'W': case 'Y':
                return 4;
            case 'K':
                return 5;
            case 'J': case 'X':
                return 8;
            case 'Q': case 'Z':
                return 10;
            default:
                return 0;
        }
    }
}
