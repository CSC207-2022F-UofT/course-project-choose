package matching_system;

public class MatchResponseModel {
    private UserData[] matchedData;

    public MatchResponseModel(UserData[] matchedData){
        this.matchedData = matchedData;
    }

    public UserData[] getMatchedData() {
        return matchedData;
    }
}
