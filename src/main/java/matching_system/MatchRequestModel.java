package matching_system;

public class MatchRequestModel {
    /** A String that store requester's email*/
    private String userEmail;
    public MatchRequestModel(String userEmail){
        this.userEmail = userEmail;
    }
    public String getUserEmail(){
        return this.userEmail;
    }
}
