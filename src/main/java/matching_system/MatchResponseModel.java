package matching_system;

import entities.UserData;

public class MatchResponseModel {
    UserData[] matchedData;

    public MatchResponseModel(UserData[] matchedData){
        this.matchedData = matchedData;
    }
}
