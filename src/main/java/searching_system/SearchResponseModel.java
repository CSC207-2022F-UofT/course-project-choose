package searching_system;

import entities.UserAccount;

import java.util.ArrayList;

public class SearchResponseModel {
    private ArrayList<UserAccount> searchedUsers;

    public SearchResponseModel(ArrayList<UserAccount> searchedUsers) {
        this.searchedUsers = searchedUsers;
    }

    public ArrayList<UserAccount> getSearchedUsers() {
        return searchedUsers;
    }
}
