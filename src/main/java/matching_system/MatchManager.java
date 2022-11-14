package matching_system;

import entities.Matcher;
import entities.User;
import entities.UserAccount;
import entities.UserData;

import java.util.ArrayList;

public class MatchManager{
    private UserAccount user;
    private Matcher match;

    final UserRepoManager userRepoManager;

    public MatchManager(UserAccount user){
        this.user = user;
        ArrayList<UserAccount> userAccountArrayList = new ArrayList<UserAccount>(this.userRepoManager.getAllUser().values());
        this.match = new Matcher(user,userAccountArrayList);
    }

    public MatchResponseModel getMatch(){
        ArrayList<UserAccount> matchedUsers = match.getMatches();
        ArrayList<UserData> matchedData = new ArrayList<UserData>();
        for(UserAccount user: matchedUsers){
            matchedData.add(new UserData(user));
        }
        final UserData[] matchedDataArr = matchedData.toArray(UserData[]::new);
        return new MatchResponseModel(matchedDataArr);
    }
}
