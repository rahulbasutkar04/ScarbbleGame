package com.amaap.scrabblegame.service;

import com.amaap.scrabblegame.repository.impl.InMemoryPlayerRepository;
import com.amaap.scrabblegame.service.exception.DuplicateIdException;
import com.amaap.scrabblegame.service.exception.InvalidIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerServiceTest {
    InMemoryPlayerRepository inMemoryPlayerRepository;
    PlayerService playerService;

    @BeforeEach
    void setUp() {
        inMemoryPlayerRepository = new InMemoryPlayerRepository();
        playerService = new PlayerService(inMemoryPlayerRepository);
    }

    @Test
    void shouldCreatePlayerSuccessfully() throws InvalidIdException, DuplicateIdException {
        // arrange
        int validId = 1;

        // act
        boolean created = playerService.createPlayer(validId);

        // assert
        assertTrue(created);
        List<Integer> playerIds = inMemoryPlayerRepository.getPlayerId();
        assertTrue(playerIds.contains(validId));
    }

    @Test
    void shouldThrowExceptionIfInvalidIdIsPassed() {
        // arrange
        int invalidId = -1;

        // act & assert
        assertThrows(InvalidIdException.class, () -> {
            playerService.createPlayer(invalidId);
        });
    }

    @Test
    void shouldNotBeAbleToCreatePlayerIfDuplicateIdFound() throws DuplicateIdException, InvalidIdException {
        // arrange
        int id1 = 1;
        int id2 = 1;

        // act & assert
        playerService.createPlayer(id1);
        assertThrows(DuplicateIdException.class, () -> {
            playerService.createPlayer(id2);
        });
    }

}
