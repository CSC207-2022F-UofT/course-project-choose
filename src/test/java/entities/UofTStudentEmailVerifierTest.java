package entities;

import email_verifier_strategy_pattern.UofTStudentEmailVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This class tests methods in UofTStudentEmailVerifier.
 */
public class UofTStudentEmailVerifierTest {

    private UofTStudentEmailVerifier emailVerifier;

    @BeforeEach
    public void setUp(){
        emailVerifier = new UofTStudentEmailVerifier();
    }

    /**
     * Test the verify method returns true when a valid email address is provided.
     */
    @Test
    public void TestValidFormat(){
        String email = "hello.hello@mail.utoronto.ca";
        Assertions.assertTrue(emailVerifier.verify(email));
    }

    /**
     * Test the verify method returns false when an invalid email address with wrong domain is provided.
     */
    @Test
    public void TestWrongDomain() {
        String email = "hello@hotmail.com";
        assertFalse(emailVerifier.verify(email));
    }

    /**
     * Test the verify method returns false when an invalid email address without @ is provided.
     */
    @Test
    public void TestWithoutAtSign(){
        String email = "hellomail.utoronto.ca";
        assertFalse(emailVerifier.verify(email));
    }

    /**
     * Test the verify method returns false when an invalid email address with a special character # is provided.
     */
    @Test
    public void TestSpecialCharacters(){
        String email = "hello#@mail.utoronto.ca";
        assertFalse(emailVerifier.verify(email));
    }
    /**
     * Test the verify method returns true when a valid email address with a number before @ is provided.
     */
    @Test
    public void TestNumbers(){
        String email = "hello.hello9@mail.utoronto.ca";
        Assertions.assertTrue(emailVerifier.verify(email));
    }

    /**
     * Test the verify method returns true when a valid email address with upper case letters before @ is provided.
     */
    @Test
    public void TestUpperLetters(){
        String email = "hello.HELLO9@mail.utoronto.ca";
        Assertions.assertTrue(emailVerifier.verify(email));
    }

}