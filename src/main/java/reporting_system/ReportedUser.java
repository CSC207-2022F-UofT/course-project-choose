package reporting_system;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.UserAccount;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReportedUser {

    public boolean reportedUser(String reportedEmail) {
        boolean flag=false;
        UserRepoManager users;
        RequestModel requestModel;
        try {
            File csvFile = new File("src/main/resources/reporteduserTest.csv");
            users = new UserRepo(csvFile);//
            ReportedUserOutputBoundary presenter = new ReportedUserPresenter();
            ReportedUserInputBoundary interactor = new ReportedUserInteractor(presenter, users);
            ReportedUserController matcherUIController = new ReportedUserController(interactor);
            ReportedUserResponseModel rurm=matcherUIController.updateReported(reportedEmail);
            flag=rurm.getReportedStatus();
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        if(flag){
            JOptionPane.showMessageDialog(null, "report success!");
        }else{
            JOptionPane.showMessageDialog(null, "report fail!");

        }
        return flag;
    }
    public static void main(String[] args) {
        ReportedUser ru=new ReportedUser();
        ru.reportedUser("emma.emma@mail.utoronto.ca");
    }
}
