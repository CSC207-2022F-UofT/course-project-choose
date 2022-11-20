package matching_system;

public class MatchResponseModel {

    /** An array of UserData that we want to send to UI inorder to showcase the data included to users*/
    private UserData[] matchedData;
    /** A record of who started the request, with the requester's email in String*/
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
