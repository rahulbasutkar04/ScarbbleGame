package com.amaap.scrabblegame.domain.sevice;

import java.util.Scanner;

public class PlayerInteractionService {
    private final Scanner scanner;

    public PlayerInteractionService(Scanner scanner) {
        this.scanner = scanner;
    }

    public String takeUserInputAsString() {
        String str = scanner.next();
        return str.toUpperCase();
    }
    public char takeUserInputAsChar() {
        String input = scanner.next();
        char c = input.charAt(0);
        return Character.toUpperCase(c);
    }
}
