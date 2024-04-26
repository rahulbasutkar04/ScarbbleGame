package com.amaap.scrabblegame.repository;

import com.amaap.scrabblegame.repository.impl.InMemoryPlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryPlayerRepositoryTest {

    private InMemoryPlayerRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryPlayerRepository();
    }

    @Test
    void shouldBeAbleToInsertPlayerSuccessfully() {
        // arrange
        int playerId = 1;

        // act
        repository.insertPlayer(playerId);
        List<Integer> playerIds = repository.getPlayerId();

        // assert
        assertTrue(playerIds.contains(playerId));
    }

    @Test
    void shouldBeAbleToRetrievePlayerIds() {
        // arrange
        int playerId1 = 1;
        int playerId2 = 2;

        // act
        repository.insertPlayer(playerId1);
        repository.insertPlayer(playerId2);
        List<Integer> playerIds = repository.getPlayerId();

        // assert
        assertTrue(playerIds.contains(playerId1));
        assertTrue(playerIds.contains(playerId2));
        assertEquals(2, playerIds.size());
    }

    @Test
    void shouldBeAbleToReturnEmptyListIfNoPlayersInserted() {
        // act
        List<Integer> playerIds = repository.getPlayerId();

        // assert
        assertTrue(playerIds.isEmpty());
    }
}
