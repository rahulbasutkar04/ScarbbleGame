package com.amaap.scrabblegame.repository.impl.db.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FakeDatabaseTest {

    private FakeDatabase fakeDatabase;

    @BeforeEach
    public void setUp() {
        fakeDatabase = new FakeDatabase();
    }

    @Test
    public void shouldBeAbleToInsertIntoPlayerTable() {
        // arrange
        fakeDatabase.inertIntoPlayerTable(1);

        // act
        List<Integer> players = fakeDatabase.getPlayers();

        // assert
        assertTrue(players.contains(1), "Player table should contain player with ID 1");
    }

    @Test
    public void shouldBeAbleToGetPlayers() {
        // arrange
        fakeDatabase.inertIntoPlayerTable(1);
        fakeDatabase.inertIntoPlayerTable(2);

        // act
        List<Integer> players = fakeDatabase.getPlayers();

        // assert
        assertEquals(2, players.size(), "There should be 2 players in the player table");
        assertTrue(players.contains(1), "Player table should contain player with ID 1");
        assertTrue(players.contains(2), "Player table should contain player with ID 2");
    }

    @Test
    public void shouldBeAbleToInsertIntoScoreTable() {
        // arrange
        fakeDatabase.inertIntoPlayerTable(1);
        fakeDatabase.inertIntoScoreTable(1, 100);

        // act
        Map<Integer, Integer> playerGameData = fakeDatabase.getPlayersData();

        // assert
        assertEquals(100, playerGameData.get(1).intValue(), "Score table should contain score 100 for player with ID 1");
    }

    @Test
    public void shouldBeAbleToGetPlayersData() {
        // arrange
        fakeDatabase.inertIntoPlayerTable(1);
        fakeDatabase.inertIntoPlayerTable(2);
        fakeDatabase.inertIntoScoreTable(1, 100);
        fakeDatabase.inertIntoScoreTable(2, 150);

        // act
        Map<Integer, Integer> playerGameData = fakeDatabase.getPlayersData();

        // assert
        assertEquals(2, playerGameData.size(), "Score table should contain data for 2 players");
        assertEquals(100, playerGameData.get(1).intValue(), "Score table should contain score 100 for player with ID 1");
        assertEquals(150, playerGameData.get(2).intValue(), "Score table should contain score 150 for player with ID 2");
    }
}