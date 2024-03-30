package com.amaap.scrabblegame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {
    @Test
    void shouldBeAbleToDetectEmptyString() {
        assertTrue(Validator.isStringEmpty(""));
    }

    @Test
    void shouldBeAbleToDetectNonEmptyString() {
        assertFalse(Validator.isStringEmpty("Test"));
    }

    @Test
    void shouldBeAbleToDetectValidString() {
        assertFalse(Validator.isStringValid("ValidString"));
    }

    @Test
    void shouldBeAbleToDetectValidStringWithSingleWord() {
        assertFalse(Validator.isStringValid("SingleWord"));
    }

    @Test
    void shouldBeAbleToDetectValidStringWithMultipleWords() {
        assertTrue(Validator.isStringValid("Multiple Words Here"));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithSpecialCharacters() {
        assertTrue(Validator.isStringValid("Invalid$String"));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithNumbers() {
        assertTrue(Validator.isStringValid("Invalid123String"));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithLeadingSpace() {
        assertTrue(Validator.isStringValid(" LeadingSpace"));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithTrailingSpace() {
        assertTrue(Validator.isStringValid("TrailingSpace "));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithSpaceOnly() {
        assertTrue(Validator.isStringValid(" "));
    }

    @Test
    void shouldBeAbleToDetectNullString() {
        assertTrue(new Validator().isStringNull(null));
    }

    @Test
    void shouldBeAbleToDetectNonNullString() {
        assertFalse(new Validator().isStringNull("Test"));
    }
}
