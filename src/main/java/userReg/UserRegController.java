package userReg;

import data_access_storage.UserRepo;
import entities.UofTStudentEmailVerifier;
import entities.User;
import entities.UserAccount;

import java.io.File;
import java.io.IOException;

public class UserRegController {


    /**
     *
     */
    public String  userProfileCreate(UserProfile up){

        String eMail=up.getEmail();

        if (!up.checkEmail()){
            return "Err01";
        }

        if (up.existEmail()){
            return "Err02";
        }

        up.save();
        return "OK";


    }
}
