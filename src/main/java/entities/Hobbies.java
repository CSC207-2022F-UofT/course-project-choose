package entities;

public enum Hobbies {
    READING("Reading"), TRAVELLING("Travelling"),
    MUSIC("Music"), GAMES("Games"), SPORTS("Sports"),
    FOOD("Food"), MOVIES_AND_TV("Movies and TV"), OTHERS("Others");

    private final String value;
    Hobbies(String value) {
        this.value = value;
    }

    public String getHobby(){return this.value; }

}