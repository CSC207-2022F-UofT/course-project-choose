package entities;

/**
 * This class represents a user on our online dating app.
 */
public class User {

    /** this user's name */
    private String name;

    /** this user's gender */
    private Gender gender;

    /** This user's age. Its value are from 18 to 99. */
    private int age;

    /** This user's height in cm */
    private float height;

    /** This user's program of study. */
    private String programOfStudy;

    /** This user's hobby. */
    private Hobbies hobby;

    /** This user's self-introduction. */
    private String selfIntro;

    /** this user's gender orientation. */
    private Gender interestedIn;

    public User(String name, Gender gender, int age,
                int height, String programOfStudy,
                Hobbies hobby, String selfIntro, Gender interestedIn) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.programOfStudy = programOfStudy;
        this.hobby = hobby;
        this.selfIntro = selfIntro;
        this.interestedIn = interestedIn;
    }

    /**
     * Get this user's name.
     * @return Return the user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get this user's gender.
     * @return Return the user's gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Get this user's age.
     * @return Return the user's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Get this user's height.
     * @return Return the user's height.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Get this user's program of study.
     * @return Return the user's program of study.
     */
    public String getProgramOfStudy() {
        return programOfStudy;
    }

    /**
     * Get this user's hobby.
     * @return Return the user's hobby.
     */
    public Hobbies getHobby() {
        return hobby;
    }

    /**
     * Get this user's self introduction.
     * @return Return the user's self introduction.
     */
    public String getSelfIntro() {
        return selfIntro;
    }

    /**
     * Get this user's gender orientation.
     * @return Return the user's gender orientation.
     */
    public Gender getInterestedIn() {
        return interestedIn;
    }
}
