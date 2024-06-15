package com.amaap.scrabblegame.repository;

import com.amaap.scrabblegame.ScrabbleGameModule;
import com.amaap.scrabblegame.repository.impl.InMemoryPlayerRepository;
import com.amaap.scrabblegame.repository.impl.db.Database;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InMemoryPlayerRepositoryTest {

    private InMemoryPlayerRepository repository;
    private Database database;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ScrabbleGameModule());
        database = injector.getInstance(Database.class);
        repository = new InMemoryPlayerRepository(database);
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
