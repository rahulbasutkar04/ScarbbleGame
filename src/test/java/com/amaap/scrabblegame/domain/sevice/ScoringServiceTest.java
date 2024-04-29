package com.amaap.scrabblegame.domain.sevice;


import com.amaap.scrabblegame.domain.sevice.impl.ScrabbleScoreCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoringServiceTest {

    private ScoringService scoringService;

    @BeforeEach
    void setUp() {
        ScrabbleCalculator scrabbleCalculator=new ScrabbleScoreCalculator();
        scoringService = new ScoringService(scrabbleCalculator);
    }

    @Test
    void shouldBeAbleToCalculateTheScrabbleWithDoubleAndTriplesANdGiveTotalScore(){
        // arrange
        String word = "SCRABBLE";

        // act
        int score = scoringService.calculateScrabble(word);

        // assert
        assertEquals(61, score);
    }



}
