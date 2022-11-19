package matching_system;

public class MatchResponseModel {
    private UserData[] matchedData;

    private String requesterEmail;

    public MatchResponseModel(UserData[] matchedData, String requesterEmail){
        this.matchedData = matchedData;
        this.requesterEmail = requesterEmail;
    }

    public UserData[] getMatchedData() {
        return matchedData;
    }

    public String getRequesterEmail(){
        return requesterEmail;
    }
}
