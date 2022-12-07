package blocking_reporting_system;

import blocking_reporting_system.reporting_system.ReportedUserRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportedUserRequestModelTest {

    private blocking_reporting_system.reporting_system.ReportedUserRequestModel ReportedUserRequestModel;

    @BeforeEach
    void setUp(){
        ReportedUserRequestModel = new ReportedUserRequestModel("e@hotmail.com");
    }

    @Test
    void getReportedEmail() {
        assertEquals(ReportedUserRequestModel.getReportedEmail(), "e@hotmail.com");
    }



}