package matching_system;

import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;
import email_request.MatcherUIOutputBoundary;
import entities.Matcher;
import entities.User;
import entities.UserAccount;

import java.util.ArrayList;

public class MatchManager implements MatcherInputBoundary{
    private UserAccount user;
    private Matcher match;

    final UserRepoManager userRepoManager;

    final MatchOutputBoundary matchOutputBoundary;

    public MatchManager(MatchOutputBoundary matchOutputBoundary, MatchRequestModel matchRequestModel, UserRepoManager userRepoManager){
        this.user = userRepoManager.getUserAccount(matchRequestModel.getUserEmail()).getUserAccount();
        this.userRepoManager = userRepoManager;
        this.matchOutputBoundary = matchOutputBoundary;
        ArrayList<UserAccount> userAccountArrayList = new ArrayList<UserAccount>();
        for(RequestModel rm: this.userRepoManager.getAllUserAccount().values()){
            userAccountArrayList.add(rm.getUserAccount());
        }
        this.match = new Matcher(user,userAccountArrayList);
    }
    public UserData add(UserData userData) {
        return userData;
    }
    @Override
    public MatchResponseModel create(MatchRequestModel requestModel){
        UserAccount[] matchedUsers = match.getMatches();

        ArrayList<UserData> matchedData = new ArrayList<UserData>();
        for(UserAccount user: matchedUsers){
            matchedData.add(new UserData(user));
        }
        final UserData[] matchedDataArr = matchedData.toArray(UserData[]::new);
        return new MatchResponseModel(matchedDataArr);
    }
}
