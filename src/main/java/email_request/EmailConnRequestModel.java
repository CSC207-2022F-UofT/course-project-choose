package email_request;

/**
 * This class contains raw data that MatcherUIInterator needs to do its job.
 * It's created, passed in, unpacked by the interactor and discarded.
 * Layer: Use Case Layer
 */
public class EmailConnRequestModel {
    /** The email address of the user who requests others' email. */
    private final String requester;

    /** The email address that is requested by the user whose email address is requester */
    private final String targetUser;

    public EmailConnRequestModel(String requester, String targetUser){
        this.requester = requester;
        this.targetUser = targetUser;
    }

    /**
     * Return the email address of the user who requests others' email.
     * @return Return the email address of the user who requests others' email.
     */
    public String getRequester(){return this.requester;}

    /**
     * Return the email address that is requested by the user
     * whose email address is requester.
     * @return Return the email address that is requested by the user
     * whose email address is requester.
     */
    public String getTargetUser(){return this.targetUser;}
}
