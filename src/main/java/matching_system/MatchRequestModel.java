package matching_system;

public class MatchRequestModel {
    private String userEmail;
    public MatchRequestModel(String userEmail){
        this.userEmail = userEmail;
    }
    public String getUserEmail(){
        return this.userEmail;
    }
}
