package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    /**
     * Make sure the String value of Gender.Male is "Male".
     */
    @Test
    void getMaleGender() {
        assertEquals("Male", Gender.MALE.getGender());
    }

    /**
     * Make sure the String value of Gender.Female is "Female".
     */
    @Test
    void getFemaleGender() {
        assertEquals("Female", Gender.FEMALE.getGender());
    }
}