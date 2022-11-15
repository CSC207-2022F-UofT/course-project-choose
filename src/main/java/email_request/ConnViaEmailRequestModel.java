package email_request;
import entities.UserAccount;

// use case layer
public class ConnViaEmailRequestModel {

    private String requester;

    private String targetUser;

    public ConnViaEmailRequestModel(String requester, String targetUser){

        this.requester = requester;
        this.targetUser = targetUser;
    }

    public String getRequester(){return this.requester;}

    public String getTargetUser(){return this.targetUser;}



}
