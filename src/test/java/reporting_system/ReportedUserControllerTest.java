package reporting_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportedUserControllerTest {

    private ReportedUserController controller;

    private UserRepoManager userRepoManager;

    @BeforeEach
    void setUp() throws IOException {

        File csvFile = new File("src/main/resources/reporteduserTest.csv");
        userRepoManager = new UserRepo(csvFile);
        ReportedUserOutputBoundary output = new ReportedUserPresenter();
        ReportedUserInputBoundary ReportedUserInputBoundary = new ReportedUserInteractor(output, userRepoManager);
        controller = new ReportedUserController(ReportedUserInputBoundary);
    }

    @Test
    void testReportedSuccess() {
        ReportedUserResponseModel rm = controller.updateReported("emma.emma@mail.utoronto.ca");
        assertTrue(rm.getReportedStatus());

    }

    @Test
    void testCreateFailure(){
        ReportedUserResponseModel rm = controller.updateReported("jimmy.jimmy@hotmail.com");
        assertFalse(rm.getReportedStatus());
    }
}