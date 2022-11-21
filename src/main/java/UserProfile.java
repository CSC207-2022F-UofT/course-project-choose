package userReg;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserProfile extends User implements  ProfileManager{

    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    public  UserProfile(String email,String password,String name, Gender gender, int age,
                        float height, String programOfStudy,
                        Hobbies hobby, String selfIntro, Gender interestedIn){
        super(name,gender,age,height,programOfStudy,hobby,selfIntro,interestedIn);
        this.email=email;
        this.password=password;

    }


    @Override
    public boolean checkEmail() {
        String email=this.email;
        UofTStudentEmailVerifier usev=new UofTStudentEmailVerifier();
        return usev.verify(email);
    }

    @Override
    public boolean existEmail() {
        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/testFile.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
       return  users.existsByEmail(this.email);

    }

    @Override
    public void save(){
        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/testFile.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        UserAccount ua =new UserAccount(email,password,this);
        RequestModel rm=new RequestModel(ua);
        users.save(rm);


    }
}
