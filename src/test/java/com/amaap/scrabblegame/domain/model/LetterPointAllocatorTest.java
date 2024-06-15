package com.amaap.scrabblegame.domain.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LetterPointAllocatorTest {

    LetterPointAllocator letterPointAllocator = new LetterPointAllocator();

    @Test
    void shouldBeAbleToGiveValidValuesForTheCharacters() {

        // act & assert
        assertEquals(1, letterPointAllocator.getPoint('A'));
        assertEquals(1, letterPointAllocator.getPoint('E'));
        assertEquals(1, letterPointAllocator.getPoint('I'));
        assertEquals(1, letterPointAllocator.getPoint('O'));
        assertEquals(1, letterPointAllocator.getPoint('N'));
        assertEquals(1, letterPointAllocator.getPoint('R'));
        assertEquals(1, letterPointAllocator.getPoint('T'));
        assertEquals(1, letterPointAllocator.getPoint('L'));
        assertEquals(1, letterPointAllocator.getPoint('S'));
        assertEquals(1, letterPointAllocator.getPoint('U'));

        assertEquals(2, letterPointAllocator.getPoint('D'));
        assertEquals(2, letterPointAllocator.getPoint('G'));

        assertEquals(3, letterPointAllocator.getPoint('B'));
        assertEquals(3, letterPointAllocator.getPoint('C'));
        assertEquals(3, letterPointAllocator.getPoint('M'));
        assertEquals(3, letterPointAllocator.getPoint('P'));

        assertEquals(4, letterPointAllocator.getPoint('F'));
        assertEquals(4, letterPointAllocator.getPoint('H'));
        assertEquals(4, letterPointAllocator.getPoint('V'));
        assertEquals(4, letterPointAllocator.getPoint('W'));
        assertEquals(4, letterPointAllocator.getPoint('Y'));

        assertEquals(5, letterPointAllocator.getPoint('K'));

        assertEquals(8, letterPointAllocator.getPoint('J'));
        assertEquals(8, letterPointAllocator.getPoint('X'));

        assertEquals(10, letterPointAllocator.getPoint('Q'));
        assertEquals(10, letterPointAllocator.getPoint('Z'));
    }

    @Test
    void ShouldNotBeAbleToGetTheValuesIfInValidCharactersAreGiven() {
        // act & assert
        assertEquals(0, letterPointAllocator.getPoint(' '));
        assertEquals(0, letterPointAllocator.getPoint('-'));
        assertEquals(0, letterPointAllocator.getPoint('?'));
        assertEquals(0, letterPointAllocator.getPoint('1'));
    }
}
