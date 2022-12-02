package matching_system;

import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;
import entities.Matcher;
import entities.UserAccount;
import java.util.ArrayList;

public class MatchManager implements MatcherInputBoundary{
    /** This is the User that requested the match*/
    private UserAccount user;
    /** The instance of Matcher which will perform the match action*/
    private Matcher match;
    /** This is an instance of userRepoManager so that we can access UserRepo, our database*/
    final UserRepoManager userRepoManager;
    /** This is an instance of MatchOutputBoundary so that we can pass out result, MatchResponseModel, out*/
    final MatchOutputBoundary matchOutputBoundary;

    public MatchManager(MatchOutputBoundary matchOutputBoundary, MatchRequestModel matchRequestModel, UserRepoManager userRepoManager){
        this.user = userRepoManager.getUserAccount(matchRequestModel.getUserEmail()).getUserAccount();
        this.userRepoManager = userRepoManager;
        this.matchOutputBoundary = matchOutputBoundary;
        ArrayList<UserAccount> userAccountArrayList = new ArrayList<>();
        for(RequestModel rm: this.userRepoManager.getAllUserAccount().values()){
            userAccountArrayList.add(rm.getUserAccount());
        }
        this.match = new Matcher(user,userAccountArrayList);
        create(matchRequestModel);
    }
    /** Create MatchResponseModel and return it, also saving it into the MatchOutputBoundary we have
     * @param requestModel request model that includes all needed information of the requester
     * @return matchResponseModel that included all matched information
     * */
    @Override
    public MatchResponseModel create(MatchRequestModel requestModel){
        UserAccount[] matchedUsers = match.getMatches();

        ArrayList<UserData> matchedData = new ArrayList<>();
        for(UserAccount user: matchedUsers){
            matchedData.add(new UserData(user));
        }
        final UserData[] matchedDataArr = matchedData.toArray(UserData[]::new);
        MatchResponseModel result = new MatchResponseModel(matchedDataArr, requestModel.getUserEmail());
        this.matchOutputBoundary.setMatchResponseModel(result);
        return result;
    }
}
