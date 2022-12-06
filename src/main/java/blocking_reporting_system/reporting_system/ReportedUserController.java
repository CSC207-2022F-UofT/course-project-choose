package blocking_reporting_system.reporting_system;

/**
 * This class is responsible to response to button clicks on
 * matching results and bundle the request data.
 * Layer: Interface Adapters
 */
public class ReportedUserController {

    final ReportedUserInputBoundary ReportedUserInput;

    /**
     * Create a controller that responses to button clicks on matching results and bundle the request data.
     * @param blockUserInputBoundary The abstraction layer between BlockUserController and BlockUserInteractor
     */
    public ReportedUserController(ReportedUserInputBoundary blockUserInputBoundary) {
        this.ReportedUserInput = blockUserInputBoundary;
    }

    /**
     * Check whether the user whose email address is requesterEmail can request the email address targetUserEmail.
     * If so, return the requested email address (targetUserEmail), and empty string otherwise.

     * @param reportedEmail the email address of the user whose email address is requested.
     * @return a data model for showing the requested email or empty string.
     */
    public ReportedUserResponseModel updateReported(String reportedEmail){
        ReportedUserRequestModel reportedUserRequestModel = new ReportedUserRequestModel(reportedEmail);
        return ReportedUserInput.updateReported(reportedUserRequestModel);
    }

}
