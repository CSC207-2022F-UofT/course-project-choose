package email_request;


import data_access_storage.UserRepoManager;
import entities.UserAccount;

public class ConnViaEmailInteractor implements ProfileViewUIInputBoundary{

    final ConnViaEmailOutputBoundary connViaEmailOutputBoundary;
    final UserRepoManager userRepoManager;

    public ConnViaEmailInteractor(ConnViaEmailOutputBoundary connViaEmailOutputBoundary,
                                  UserRepoManager userRepoManager) {
        this.connViaEmailOutputBoundary = connViaEmailOutputBoundary;
        this.userRepoManager = userRepoManager;
    }


    @Override
    public ConnViaEmailResponseModel create(ConnViaEmailRequestModel requestModel) {

        // get user account information from data base.
        RequestModel userAccount = this.userRepoManager.getUserAccount(requestModel.getRequester());
        boolean isAPaidUser = userAccount.getUserAccount().getSubStatus();
        boolean underMaxRequest = userAccount.getUserAccount().getNumOfEmailRequest() <= UserAccount.MAX_REQUEST;

        String requestedEmail = "";
        if(isAPaidUser | underMaxRequest){
            requestedEmail = requestModel.getTargetUser();
        }

        // If the requester is a paid user
        ConnViaEmailResponseModel connViaEmailResponseModel = new ConnViaEmailResponseModel(requestedEmail);
        return connViaEmailOutputBoundary.prepareView(connViaEmailResponseModel);
    }
}
