package User_Register_System;

import entities.Gender;
import entities.Hobbies;

public class UserRegUIRequestModel {
    // Analysis Data
    String email;
    String password;
    String name;
    int age;
    float height;
    Gender gender;
    Hobbies hobbies;
    String programOfStudy;
    String selfIntro;
    Gender interestedIn;


    public UserRegUIRequestModel(String email,
    String password,
    String name,
    int age,
    float height,
    Gender gender,
    Hobbies hobbies,
    String programOfStudy,
    String selfIntro,
    Gender interestedIn){
        this.email=email;
        this.password=password;
        this.name=name;
        this.age=age;
        this.height=height;
        this.gender=gender;
        this.hobbies=hobbies;
        this.programOfStudy=programOfStudy;
        this.interestedIn=interestedIn;
        this.selfIntro=selfIntro;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public Gender getGender() {
        return gender;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public String getProgramOfStudy() {
        return programOfStudy;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public Gender getInterestedIn() {
        return interestedIn;
    }
}
