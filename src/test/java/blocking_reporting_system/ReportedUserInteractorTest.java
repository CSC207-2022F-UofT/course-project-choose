package blocking_reporting_system;

import blocking_reporting_system.reporting_system.*;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class ReportedUserInteractorTest {

    private ReportedUserInteractor interactor;



    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/reporteduserTest.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        ReportedUserOutputBoundary output = new ReportedUserPresenter();
        interactor = new ReportedUserInteractor(output, repo);
    }

//    @Test
//    void testCreateSuccess(){
//        ReportedUserRequestModel rm = new ReportedUserRequestModel("emma.emma@mail.utoronto.ca");
//        ReportedUserResponseModel rq = interactor.updateReported(rm);
//        assertTrue(rq.getReportedStatus());
//
//    }

    @Test
    void testCreateFailure() {
        ReportedUserRequestModel rm = new ReportedUserRequestModel("jimmy.jimmy@hotmail.com");
        ReportedUserResponseModel rq = interactor.updateReported(rm);
        assertFalse(rq.getReportedStatus());

    }




}