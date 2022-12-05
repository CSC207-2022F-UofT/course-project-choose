package reporting_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportedUserRequestModelTest {

    private ReportedUserRequestModel ReportedUserRequestModel;

    @BeforeEach
    void setUp(){
        ReportedUserRequestModel = new ReportedUserRequestModel("e@hotmail.com");
    }

    @Test
    void getReportedEmail() {
        assertEquals(ReportedUserRequestModel.getReportedEmail(), "e@hotmail.com");
    }



}