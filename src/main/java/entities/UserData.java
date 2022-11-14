package entities;

public class UserData {
    /** this user's name */
    public String name;

    /** this user's gender */
    public Gender gender;

    /** This user's age. Its value are from 18 to 99. */
    public int age;

    /** This user's height in cm */
    public float height;

    /** This user's program of study. */
    public String programOfStudy;

    /** This user's hobby. */
    public Hobbies hobby;

    /** This user's self-introduction. */
    public String selfIntro;
    /** This user's email. */
    public String email;

    public UserData(UserAccount userAccount){
        User user = userAccount.getUser();
        this.age = user.getAge();
        this.hobby = user.getHobby();
        this.gender = user.getGender();
        this.height = user.getHeight();
        this.programOfStudy = user.getProgramOfStudy();
        this.selfIntro = user.getSelfIntro();
        this.email = userAccount.getEmail();
    }
}
