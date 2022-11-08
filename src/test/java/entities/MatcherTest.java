package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MatcherTest {
    @Test
    void match1() {
        User userA = new User("Emma", Gender.FEMALE, 18,
                164, "Computer Science", Hobbies.FOOD,
                "Hello, This is Emma", Gender.MALE);
        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "Hello, This is David", Gender.FEMALE);
        User userC = new User("John", Gender.MALE, 18,
                174, "Statistics", Hobbies.FOOD,
                "Hello, This is Emma", Gender.MALE);
        User userD = new User("Eric", Gender.MALE, 18,
                174, "Statistics", Hobbies.FOOD,
                "Hello, This is Emma", Gender.FEMALE);
        ArrayList<User> targets = new ArrayList<User>();
        targets.add(userB);
        targets.add(userC);
        targets.add(userD);
        Matcher emmaMatches = new Matcher(userA,targets);
        ArrayList<User> expected = new ArrayList<User>();
        expected.add(userB);
        expected.add(userD);
        expected.add(userC);
        assertEquals(expected, emmaMatches.getMatches());
    }

    @Test
    void match2() {
        User userA = new User("Emma", Gender.FEMALE, 18,
                164, "Computer Science", Hobbies.FOOD,
                "Hello, This is Emma", Gender.MALE);
        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "Hello, This is David", Gender.FEMALE);
        User userC = new User("John", Gender.MALE, 18,
                174, "Statistics", Hobbies.FOOD,
                "Hello, This is Emma", Gender.MALE);
        User userD = new User("Eric", Gender.MALE, 18,
                174, "Statistics", Hobbies.FOOD,
                "Hello, This is Emma", Gender.FEMALE);
        ArrayList<User> targets = new ArrayList<User>();
        targets.add(userD);
        targets.add(userC);
        targets.add(userB);
        Matcher emmaMatches = new Matcher(userA,targets);
        ArrayList<User> expected = new ArrayList<User>();
        expected.add(userB);
        expected.add(userD);
        expected.add(userC);
        assertEquals(expected, emmaMatches.getMatches());
    }
}
