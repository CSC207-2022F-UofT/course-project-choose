package usecases;

import entities.Matcher;
import entities.User;

import java.util.ArrayList;

public class MatchManager{
    private User user;
    private Matcher match;

    public MatchManager(User user){
        this.user = user;
        this.match = new Matcher(user,UserRepoManager.getAllUser());
    }

    public MatchResponseModel getMatch(){
        ArrayList<User> matchedUsers = match.getMatches();
        ArrayList<String> matchedNames = new ArrayList<String>();
        for(User user: matchedUsers){
            matchedNames.add(user.getName());
        }
        return new MatchResponseModel(matchedNames);
    }
}
