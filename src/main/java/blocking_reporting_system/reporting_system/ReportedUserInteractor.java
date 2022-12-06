package blocking_reporting_system.reporting_system;


import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;
import entities.UserAccount;

import java.util.Map;

/**
 * This class is responsible to take the inputs/request from users, interact with
 * entities to fulfil the request and prepare output for users.
 * Layer: Use Case
 */
public class ReportedUserInteractor implements ReportedUserInputBoundary {

    final ReportedUserOutputBoundary ReportedUserOutputBoundary;
    final UserRepoManager userRepoManager;

    /**
     * Construct a ReportedUserInteractor object.
     * @param ReportedUserOutputBoundary a interface that allows ReportedUserInteractor to call
     *                                ReportedUserPrenseter without knowing its existence.
     * @param userRepoManager a data access interface
     */

    public ReportedUserInteractor(ReportedUserOutputBoundary ReportedUserOutputBoundary,
                                  UserRepoManager userRepoManager) {
        this.ReportedUserOutputBoundary = ReportedUserOutputBoundary;
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
    public ReportedUserResponseModel updateReported(ReportedUserRequestModel requestModel) {

        boolean reportedStatus=false;

        String repotedEmail= requestModel.getReportedEmail();
        RequestModel requestModel2;
        Map<String, RequestModel> allUserAccount = this.userRepoManager.getAllUserAccount();
        for (String s : allUserAccount.keySet()) {
            requestModel2 = allUserAccount.get(s);
            if(requestModel2!=null && requestModel2.getUserAccount()!=null){
                UserAccount userAccount = requestModel2.getUserAccount();
                String email1 = userAccount.getEmail();
                if(email1.equals(repotedEmail)){
                    userAccount.isReported();
                    this.userRepoManager.save(requestModel2);
                    reportedStatus = true;
                }
            }

        }
        // prepare the resulted email address to show to users.
        ReportedUserResponseModel ReportedUserResponseModel = new ReportedUserResponseModel(reportedStatus);
        return ReportedUserOutputBoundary.prepareView(ReportedUserResponseModel);
    }
}
