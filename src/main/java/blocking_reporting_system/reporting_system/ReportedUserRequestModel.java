package blocking_reporting_system.reporting_system;

/**
 * This class contains raw data that MatcherUIInterator needs to do its job.
 * It's created, passed in, unpacked by the interactor and discarded.
 * Layer: Use Case Layer
 */
public class ReportedUserRequestModel {
    /** The email address of the user who requests others' email. */
    private String reportedEmail;



    public ReportedUserRequestModel(String reportedEmail){

        this.reportedEmail = reportedEmail;
    }


    /**
     * Return the email address that is requested by the user
     * whose email address is requester.
     * @return Return the email address that is requested by the user
     * whose email address is requester.
     */
    public String getReportedEmail(){return this.reportedEmail;}
}
