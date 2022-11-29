package reporting_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportedUserResponseModelTest {

    private ReportedUserResponseModel ReportedUserResponseModel;

    @BeforeEach
    void setUp(){
        ReportedUserResponseModel  = new ReportedUserResponseModel(true);
    }

    @Test
    void getBlockStatus() {
        assert(ReportedUserResponseModel.getReportedStatus());
    }
}