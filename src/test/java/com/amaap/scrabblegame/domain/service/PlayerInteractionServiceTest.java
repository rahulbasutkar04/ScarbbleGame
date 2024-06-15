package com.amaap.scrabblegame.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerInteractionServiceTest {

    private PlayerInteractionService playerInteractionService;

    @BeforeEach
    void setUp() {
        String testInput = "test";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        playerInteractionService = new PlayerInteractionService(scanner);
    }

    @Test
    void takeUserInputAsString() {
        // act
        String userInput = playerInteractionService.takeUserInputAsString();

        // assert
        assertEquals("TEST", userInput);
    }

    @Test
    void takeUserInputAsChar() {
        // act
        char userInput = playerInteractionService.takeUserInputAsChar();

        // assert
        assertEquals('T', userInput);
    }
}
