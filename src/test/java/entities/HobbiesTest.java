package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HobbiesTest {

    /**
     * Make sure the string value of Hobbies.FOOD is "Food".
     */
    @Test
    void getFood() {
        assertEquals("Food", Hobbies.FOOD.getHobby());
    }

    /**
     * Make sure the string value of Hobbies.READING is "Reading".
     */
    @Test
    void getReading() {
        assertEquals("Reading", Hobbies.READING.getHobby());
    }

    /**
     * Make sure the string value of Hobbies.TRAVELLING is "Travelling".
     */
    @Test
    void getTravelling() {
        assertEquals("Travelling", Hobbies.TRAVELLING.getHobby());
    }

    /**
     * Make sure the string value of Hobbies.MUSIC is "Music".
     */
    @Test
    void getMusic() {
        assertEquals("Music", Hobbies.MUSIC.getHobby());
    }

    /**
     * Make sure the string value of Hobbies.GAMES is "Games".
     */
    @Test
    void getGames() {
        assertEquals("Games", Hobbies.GAMES.getHobby());
    }

    /**
     * Make sure the string value of Hobbies.SPORTS is "Sports".
     */
    @Test
    void getSports() {
        assertEquals("Sports", Hobbies.SPORTS.getHobby());
    }

    /**
     * Make sure the string value of Hobbies.MOVIES_AND_TV is "Movies and TV".
     */
    @Test
    void getMovieTV() {
        assertEquals("Movies and TV", Hobbies.MOVIES_AND_TV.getHobby());
    }

    /**
     * Make sure the string value of Hobbies.OTHERS is "Others".
     */
    @Test
    void getOthers() {
        assertEquals("Others", Hobbies.OTHERS.getHobby());
    }
}