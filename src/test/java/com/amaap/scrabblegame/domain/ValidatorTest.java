package com.amaap.scrabblegame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {
    Validator validator=new Validator();
    @Test
    void shouldBeAbleToDetectEmptyString() {
        assertTrue(validator.isStringEmpty(""));
    }

    @Test
    void shouldBeAbleToDetectNonEmptyString() {
        assertFalse(validator.isStringEmpty("Test"));
    }

    @Test
    void shouldBeAbleToDetectValidString() {
        assertFalse(validator.isStringValid("ValidString"));
    }

    @Test
    void shouldBeAbleToDetectValidStringWithSingleWord() {
        assertFalse(validator.isStringValid("SingleWord"));
    }

    @Test
    void shouldBeAbleToDetectValidStringWithMultipleWords() {
        assertTrue(validator.isStringValid("Multiple Words Here"));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithSpecialCharacters() {
        assertTrue(validator.isStringValid("Invalid$String"));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithNumbers() {
        assertTrue(validator.isStringValid("Invalid123String"));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithLeadingSpace() {
        assertTrue(validator.isStringValid(" LeadingSpace"));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithTrailingSpace() {
        assertTrue(validator.isStringValid("TrailingSpace "));
    }

    @Test
    void shouldBeAbleToDetectInvalidStringWithSpaceOnly() {
        assertTrue(validator.isStringValid(" "));
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
