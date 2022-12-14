package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a user account on our online dating app.
 */
public class UserAccount {
    /** this user account's log-in username, and is also the account holder's email address */
    private final String email;

    /** this user account's log-in password */
    private final String password;

    /** The user who owns this user account */
    private User user;

    /** true if this user account's email is in a valid format, and false otherwise. */
    private boolean validEmail = false;

    /**
     * The subscription status of this user account.
     * If true, this user is a paid user, and false otherwise.
     * The default value is false.
     */
    private boolean subStatus = false;

    /** the number of times that this user account is reported by other users. */
    private int numOfReport = 0;

    /**
     * A list of user accounts that this user account blocks.
     * The blocked users are identified by their email address.
     */
    private List<String> blockedAccounts = new ArrayList<>();

    /** number of email addresses that this user account already requests. */
    private int numOfEmailRequest = 0;

    /**
     * The maximum number of email requests a free user account can request.
     */
    public static final int MAX_REQUEST = 5;

    /**
     * Create a user account.
     * @param email login username, also is the account holder's email address.
     * @param password login password
     * @param user the user who owns this account.
     */
    public UserAccount(String email, String password, User user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    /**
     * Create a user account when from reading data.
     * @param email login username, also is the account holder's email address.
     * @param password login password
     * @param user the user who owns this account.
     * @param validEmail true if this user account's email is in a valid format, and false otherwise
     * @param subStatus The subscription status of this user account.
     *        If true, this user is a paid user, and false otherwise.
     *        The default value is false.
     * @param numOfReport  the number of times that this user account is reported by other users.
     * @param blockedAccounts A list of user accounts that this user account blocks.
     *        The blocked users are identified by their email address.
     * @param numOfEmailRequest number of email addresses that this user account already requests.
     */
    public UserAccount(String email, String password, User user, boolean validEmail,
                       boolean subStatus, int numOfReport, List<String> blockedAccounts,
                       int numOfEmailRequest){
        this.email = email;
        this.password = password;
        this.user = user;
        this.validEmail = validEmail;
        this.subStatus = subStatus;
        this.numOfReport = numOfReport;
        this.blockedAccounts = blockedAccounts;
        this.numOfEmailRequest = numOfEmailRequest;
    }

    /**
     * Get this user account's login username.
     * @return return this user account's login username, which is the email address.
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Get the number of user accounts that report this user account.
     * @return return the number of user accounts that report this user account.
     */
    public int getNumOfReport(){
        return this.numOfReport;
    }

    /**
     * This user account is reported by another user account. Increase
     * numOfReport by 1.
     */
    public void isReported(){
        this.numOfReport += 1;
    }

    /**
     * Blocks a user account.
     * @param otherAccount: a user account whom this user account wants to block
     */
    public void block(String otherAccount){
        blockedAccounts.add(otherAccount);
    }

    /**
     * Get a list of user accounts that are blocked by this user account.
     * @return return a list of user accounts that are blocked by this user account.
     */
    public List<String> getBlockedAccounts(){
        return this.blockedAccounts;
    }

    /**
     * This user pays to become a paid user, and set his/her subscription status to be true.
     */
    public void subscribe(){
        this.subStatus = true;
    }

    /**
     * Get this user's subscription status.
     * @return return this user's subscription status.
     */
    public boolean getSubStatus(){
        return this.subStatus;
    }

    /**
     * Set this user account's email to be valid.
     */
    public void setValidEmail(){
        this.validEmail = true;
    }

    /**
     * Return this user account's email status.
     * @return return this user account's email status.
     */
    public boolean getValidEmail(){ return this.validEmail;}

    /**
     * Return this user account's user information
     * @return return this user account's user information
     */
    public User getUser() {
        return user;
    }

    /**
     * Return this user account's password.
     * @return return this user account's password.
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Return this user account's number of email requests.
     * @return return this user account's number of email requests.
     */
    public int getNumOfEmailRequest(){
        return this.numOfEmailRequest;
    }

    /**
     * Increase this user's number of email request by 1
     */
    public void incNumOfEmailRequest(){
        this.numOfEmailRequest += 1;
    }

    /**
     * Check whether this user account can see the email address that is requested.
     * Female accounts and accounts on subscription can always the see requested email.
     * Male accounts that are not on subscription but whose number of email requests is
     * less than or equal to the maximum number of email request can
     * also see the requested email addresses.
     * @return true if this user account can see the requested email address, and false otherwise.
     */
    public boolean seeRequestedEmail(){
        boolean cond1 = this.user.getGender().equals(Gender.FEMALE);
        boolean cond2 = this.numOfEmailRequest < UserAccount.MAX_REQUEST;
        return cond1 | cond2 | this.subStatus;
    }

}

