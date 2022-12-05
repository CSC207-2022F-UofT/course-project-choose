package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in EmailConnResponseModel.
 */
class EmailConnResponseModelTest {

    private EmailConnResponseModel emailConnResponseModel;

    /**
     * Set up emailConnResponseModel for each test.
     */
    @BeforeEach
    void setUp(){
        emailConnResponseModel = new EmailConnResponseModel("david.david@hotmail.com");
    }

    /** Test to make sure getRequestedEmailAddress returns the requested email address */
    @Test
    void getRequestedEmailAddress() {
        assertEquals("david.david@hotmail.com",
                emailConnResponseModel.getRequestedEmailAddress());
    }
}