package email_request;


import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;

/**
 * This class is responsible to take the inputs/request from users, interact with
 * entities to fulfil the request and prepare output for users.
 * Layer: Use Case
 */
public class MatcherUIInteractor implements MatcherUIInputBoundary {

    final MatcherUIOutputBoundary matcherUIOutputBoundary;
    final UserRepoManager userRepoManager;

    /**
     * Construct a MatcherUIInteractor object.
     * @param matcherUIOutputBoundary a interface that allows MatcherUIInteractor to call
     *                                MatcherUIPrenseter without knowing its existence.
     * @param userRepoManager a data access interface
     */

    public MatcherUIInteractor(MatcherUIOutputBoundary matcherUIOutputBoundary,
                               UserRepoManager userRepoManager) {
        this.matcherUIOutputBoundary = matcherUIOutputBoundary;
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
    public MatcherUIResponseModel create(MatcherUIRequestModel requestModel) {

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
        MatcherUIResponseModel matcherUIResponseModel = new MatcherUIResponseModel(requestedEmail);
        return matcherUIOutputBoundary.prepareView(matcherUIResponseModel);
    }
}

