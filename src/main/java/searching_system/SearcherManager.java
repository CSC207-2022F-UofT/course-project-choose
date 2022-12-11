package searching_system;

import data_access_storage.*;
import entities.*;
import matching_system.*;

import java.util.ArrayList;

public class SearcherManager implements SearcherInputBoundary{
    private final Searcher searcher;

    final UserRepoManager userRepoManager;

    final SearcherOutputBoundary searcherOutputBoundary;

    public SearcherManager(SearcherOutputBoundary searcherOutputBoundary, SearchRequestModel searchRequestModel, UserRepoManager userRepoManager){
        this.userRepoManager = userRepoManager;
        this.searcherOutputBoundary = searcherOutputBoundary;
        ArrayList<UserAccount> userAccountArrayList = new ArrayList<UserAccount>();
        for(RequestModel rm: this.userRepoManager.getAllUserAccount().values()){
            userAccountArrayList.add(rm.getUserAccount());
        }
        this.searcher = new Searcher(searchRequestModel.getKeyword(), userAccountArrayList);

    }
    @Override
    public SearchResponseModel create(SearchRequestModel requestModel){

        ArrayList<UserAccount> searchedUsers = searcher.getSearches();

        return new SearchResponseModel(searchedUsers);
    }


}
