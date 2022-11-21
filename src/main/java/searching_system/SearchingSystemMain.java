package searching_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.*;
import matching_system.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SearchingSystemMain {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Search results");

        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/searchingSystemTest.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        SearchRequestModel searchRequestModel = new SearchRequestModel("Hello");
        SearcherOutputBoundary presenter = new SearchUIPresenter();
        SearcherManager searcherManager = new SearcherManager(presenter,searchRequestModel, users);

        // create Controller
        MatcherUIOutputBoundary presenter1 = new MatcherUIPresenter();
        MatcherUIInputBoundary interactor = new MatcherUIInteractor(presenter1, users);
        MatcherUIController matcherUIController = new MatcherUIController(interactor);

        SeacherUITemplate seacherUITemplate = new SeacherUITemplate(matcherUIController,
                "j@mail.utoronto.ca",
                searcherManager.create(searchRequestModel));
        application.add(seacherUITemplate);
        application.pack();
//        application.setSize(640, 1000);
        application.setVisible(true);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
