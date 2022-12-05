package entities;

public enum Gender {
    FEMALE("Female"), MALE("Male");

    private final String gender;
    Gender(String gender) {
        this.gender = gender;
    }
    public String getGender(){return this.gender; }
}
