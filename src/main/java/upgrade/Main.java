package upgrade;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String currentEmail = "terry.tan@mail.utoronto.ca";

        UpgradeInteractor upgradeInteractor = new UpgradeInteractor();

        UpgradePresenter upgradePresenter = new UpgradePresenter(currentEmail);
        upgradeInteractor.setOutputBoundary(upgradePresenter);
        UpgradeController upgradeController = new UpgradeController(upgradeInteractor);

        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/upgradeTestFile.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        UpgradeManager.instance().setUserRepoManager(users);
        UpgradeUI upgradeUI = new UpgradeUI(currentEmail, upgradeController, upgradePresenter);
        upgradeUI.setVisible(true);
    }



}
