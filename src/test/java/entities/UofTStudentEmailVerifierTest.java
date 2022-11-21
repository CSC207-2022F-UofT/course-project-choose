package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UofTStudentEmailVerifierTest {

    private UofTStudentEmailVerifier emailVerifier;

    @BeforeEach
    public void setUp(){
        emailVerifier = new UofTStudentEmailVerifier();
    }

    @Test
    public void TestValidFormat(){
        String email = "hello.hello@mail.utoronto.ca";
        assertTrue(emailVerifier.verify(email));
    }

    @Test
    public void TestWrongDomain() {
        String email = "hello@hotmail.com";
        assertFalse(emailVerifier.verify(email));
    }

    @Test
    public void TestWithoutAtSign(){
        String email = "hellomail.utoronto.ca";
        assertFalse(emailVerifier.verify(email));
    }

    @Test
    public void TestSpecialCharacters(){
        String email = "hello#@mail.utoronto.ca";
        assertFalse(emailVerifier.verify(email));
    }

    @Test
    public void TestNumbers(){
        String email = "hello.hello9@mail.utoronto.ca";
        assertTrue(emailVerifier.verify(email));
    }

    @Test
    public void TestUpperLetters(){
        String email = "hello.HELLO9@mail.utoronto.ca";
        assertTrue(emailVerifier.verify(email));
    }

}