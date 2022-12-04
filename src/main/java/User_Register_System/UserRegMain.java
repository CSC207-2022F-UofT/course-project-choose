package User_Register_System;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class UserRegMain {
    /** Here is an example of how userRegisterSystem work
     */
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("User Register");

        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/userRegingSystemTest.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        // create Controller
        UserRegUIOutputBoundary presenter1 = new UserRegUIPresenter();
        UserRegUIInputBoundary interactor = new UserRegUIInteractor(presenter1, users);
        UserRegUIController userRegUIController = new UserRegUIController(interactor);

        UserRegUITemplate userRegUiTemplate = new UserRegUITemplate(users,userRegUIController);

        application.setBounds(500,100,400,550);
        application.setLayout(null);
        userRegUiTemplate.setBounds(0,0,400,550);
        application.add(userRegUiTemplate);
        // application.pack();
        application.setVisible(true);
    }
}