package entities;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MatcherTest {
//    @Test
//    void match1() {
//
//        UserAccount userA = new UserAccount("A", "12345", new User("Emma", Gender.FEMALE, 18,
//                164, "Computer Science", Hobbies.FOOD,
//                "Hello, This is Emma", Gender.MALE));
//        UserAccount userB = new UserAccount("B", "12345", new User("Jason", Gender.MALE, 18,
//                164, "Computer Science", Hobbies.FOOD,
//                "Hello, This is Jason", Gender.FEMALE));
//        UserAccount userC = new UserAccount("C", "12345", new User("John", Gender.MALE, 18,
//                164, "Computer Science", Hobbies.GAMES,
//                "Hello, This is John", Gender.FEMALE));
//        UserAccount userD = new UserAccount("D", "12345", new User("Joe", Gender.MALE, 70,
//                164, "Computer Science", Hobbies.FOOD,
//                "Hello, This is John", Gender.FEMALE));
//        UserAccount userE = new UserAccount("E", "12345", new User("Java", Gender.MALE, 70,
//                164, "Statistics", Hobbies.GAMES,
//                "Hello, This is John", Gender.FEMALE));
//        UserAccount userF = new UserAccount("F", "12345", new User("Python", Gender.MALE, 70,
//                164, "Statistics", Hobbies.FOOD,
//                "Hello, This is John", Gender.MALE));
//        UserAccount userG = new UserAccount("G", "12345", new User("C#", Gender.FEMALE, 70,
//                164, "Statistics", Hobbies.FOOD,
//                "Hello, This is John", Gender.MALE));
//        ArrayList<UserAccount> targets = new ArrayList<UserAccount>();
//        targets.add(userB);
//        targets.add(userC);
//        targets.add(userD);
//        Matcher emmaMatches = new Matcher(userA, targets);
//        ArrayList<UserAccount> expected = new ArrayList<UserAccount>();
//        expected.add(userB);
//        expected.add(userD);
//        expected.add(userC);
//        assertEquals(expected, emmaMatches.getMatches());
//    }
//}
//    @Test
//    void match2() {
//        User userA = new User("Emma", Gender.FEMALE, 18,
//                164, "Computer Science", Hobbies.FOOD,
//                "Hello, This is Emma", Gender.MALE);
//        User userB = new User("David", Gender.MALE, 18,
//                174, "Computer Science", Hobbies.FOOD,
//                "Hello, This is David", Gender.FEMALE);
//        User userC = new User("John", Gender.MALE, 18,
//                174, "Statistics", Hobbies.FOOD,
//                "Hello, This is Emma", Gender.MALE);
//        User userD = new User("Eric", Gender.MALE, 18,
//                174, "Statistics", Hobbies.FOOD,
//                "Hello, This is Emma", Gender.FEMALE);
//        ArrayList<User> targets = new ArrayList<User>();
//        targets.add(userD);
//        targets.add(userC);
//        targets.add(userB);
//        Matcher emmaMatches = new Matcher(userA,targets);
//        ArrayList<User> expected = new ArrayList<User>();
//        expected.add(userB);
//        expected.add(userD);
//        expected.add(userC);
//        assertEquals(expected, emmaMatches.getMatches());
//    }
//}
