package com.amaap.scrabblegame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    @Test
    public void shouldBeAbleToDetectEmptyString() {
        assertTrue(Validator.isStringEmpty(""));
    }

    @Test
    public void shouldBeAbleToDetectNonEmptyString() {
        assertFalse(Validator.isStringEmpty("Test"));
    }

    @Test
    public void shouldBeAbleToDetectValidStringWithSingleWord() {
        assertTrue(Validator.isStringValid("Singleword"));
    }

    @Test
    public void shouldBeAbleToDetectValidStringWithMultipleWords() {
        assertTrue(Validator.isStringValid("Multiple Words Here"));
    }

    @Test
    public void shouldBeAbleToDetectValidStringWithMixedCase() {
        assertTrue(Validator.isStringValid("VaLiD StRiNg"));
    }

    @Test
    public void shouldBeAbleToDetectInValidStringWithLeadingAndTrailingSpaces() {
        assertFalse(Validator.isStringValid(" In Valid String With Spaces  "));
    }

    @Test
    public void shouldBeAbleToDetectValidStringWithSpecialCharacters() {
        assertFalse(Validator.isStringValid("Invalid$String"));
    }

    @Test
    public void shouldBeAbleToDetectValidStringWithNumbers() {
        assertFalse(Validator.isStringValid("Invalid123String"));
    }

    @Test
    public void shouldBeAbleToDetectValidStringWithHyphen() {
        assertFalse(Validator.isStringValid("Invalid-String"));
    }

    @Test
    public void shouldBeAbleToDetectValidStringWithUnderscore() {
        assertFalse(Validator.isStringValid("Invalid_ String"));
    }

    @Test
    public void shouldBeAbleToDetectNullString() {
        assertTrue(new Validator().isStringNull(null));
    }

    @Test
    public void shouldBeAbleToDetectNonNullString() {
        assertFalse(new Validator().isStringNull("Test"));
    }
}
