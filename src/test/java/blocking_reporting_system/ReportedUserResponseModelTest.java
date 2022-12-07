package blocking_reporting_system;

import blocking_reporting_system.reporting_system.ReportedUserResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportedUserResponseModelTest {

    private blocking_reporting_system.reporting_system.ReportedUserResponseModel ReportedUserResponseModel;

    @BeforeEach
    void setUp(){
        ReportedUserResponseModel  = new ReportedUserResponseModel(true);
    }

    @Test
    void getBlockStatus() {
        assert(ReportedUserResponseModel.getReportedStatus());
    }
}