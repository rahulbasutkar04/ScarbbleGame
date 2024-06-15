package com.amaap.scrabblegame.controller;

import com.amaap.scrabblegame.ScrabbleGameModule;
import com.amaap.scrabblegame.controller.dto.Http;
import com.amaap.scrabblegame.controller.dto.Response;
import com.amaap.scrabblegame.repository.impl.InMemoryPlayerRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {

    InMemoryPlayerRepository inMemoryPlayerRepository;
    PlayerController playerController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ScrabbleGameModule());
        inMemoryPlayerRepository = injector.getInstance(InMemoryPlayerRepository.class);
        playerController = injector.getInstance(PlayerController.class);
    }

    @Test
    void shouldBeAbleToCreateThePlayerWithTheId() {
        // arrange
        int id = 1;
        Response expectedHttpStatus = new Response(Http.OK);

        // act
        Response actualHttpStatus = playerController.createPlayer(id);

        // assert
        assertEquals(expectedHttpStatus, actualHttpStatus);
    }

    @Test
    void shouldThrowExceptionIfInvalidIdIsPassed() {
        // arrange
        int id = -1;
        Response expectedHttpStatus = new Response(Http.BAD_REQUEST);

        // act
        Response actualHttpStatus = playerController.createPlayer(id);

        // assert
        assertEquals(expectedHttpStatus, actualHttpStatus);
    }
}

