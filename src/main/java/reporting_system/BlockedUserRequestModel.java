package reporting_system;

/**
 * This class contains raw data that MatcherUIInterator needs to do its job.
 * It's created, passed in, unpacked by the interactor and discarded.
 * Layer: Use Case Layer
 */
public class BlockedUserRequestModel {
    /** The email address of the user who requests others' email. */
    private String email;

    /** The email address that is requested by the user whose email address is requester */
    private String blockedEmail;

    public BlockedUserRequestModel(String email, String blockedEmail){
        this.email = email;
        this.blockedEmail = blockedEmail;
    }

    /**
     * Return the email address of the user who requests others' email.
     * @return Return the email address of the user who requests others' email.
     */
    public String getEmail(){return this.email;}

    /**
     * Return the email address that is requested by the user
     * whose email address is requester.
     * @return Return the email address that is requested by the user
     * whose email address is requester.
     */
    public String getBlockedEmail(){return this.blockedEmail;}
}
