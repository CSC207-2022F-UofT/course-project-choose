package email_request;


import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;

/**
 * This class is responsible to take the inputs/request from users, interact with
 * entities to fulfil the request and prepare output for users.
 * Layer: Use Case
 */
public class EmailConnInteractor implements EmailConnInputBoundary {

    final EmailConnOutputBoundary emailConnOutputBoundary;
    final UserRepoManager userRepoManager;

    /**
     * Construct a EmailConnInteractor object.
     * @param emailConnOutputBoundary a interface that allows EmailConnInteractor to call
     *                                MatcherUIPrenseter without knowing its existence.
     * @param userRepoManager a data access interface
     */

    public EmailConnInteractor(EmailConnOutputBoundary emailConnOutputBoundary,
                               UserRepoManager userRepoManager) {
        this.emailConnOutputBoundary = emailConnOutputBoundary;
        this.userRepoManager = userRepoManager;
    }

    /**
     * Take the email request from users and decide whether
     * the requesters can see the requested email address.
     * If so, return the requested email address, and empty string otherwise.
     * @param requestModel a data model for the email request
     * @return a data model for showing the requested email or empty string.
     */

    @Override
    public EmailConnResponseModel create(EmailConnRequestModel requestModel) {

        // get information from database in order to determine whether the requested email can be shown.
        RequestModel userAccount = this.userRepoManager.getUserAccount(requestModel.getRequester());

        String requestedEmail = "";
        // If the user can see the requested email address, update requestedEmail to be the
        // requested email address.
        if(userAccount.getUserAccount().seeRequestedEmail()){
            requestedEmail = requestModel.getTargetUser();
            // increase the number of email request by 1.
            userAccount.getUserAccount().incNumOfEmailRequest();
            // update data in storage to reflect the change in the number of email request
            this.userRepoManager.update(userAccount.getUserAccount().getEmail(), userAccount);
        }

        // prepare the resulted email address to show to users.
        EmailConnResponseModel emailConnResponseModel = new EmailConnResponseModel(requestedEmail);
        return emailConnOutputBoundary.prepareView(emailConnResponseModel);
    }
}

