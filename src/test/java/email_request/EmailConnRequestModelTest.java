package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in EmailConnRequestModel.
 */
class EmailConnRequestModelTest {

    private EmailConnRequestModel emailConnRequestModel;

    /** Set up emailConnRequestModel for each test */
    @BeforeEach
    void setUp(){
        emailConnRequestModel = new EmailConnRequestModel("david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
    }

    /**
     * Test to make sure that getRequester returns the requester's email address
     */
    @Test
    void getRequester() {
        assertEquals(emailConnRequestModel.getRequester(), "david.david@hotmail.com");
    }

    /**
     * Test to make sure getTargerUser returns the email address of the user whose email address is requested.
     */
    @Test
    void getTargetUser() {
        assertEquals(emailConnRequestModel.getTargetUser(), "emma.emma@mail.utoronto.ca");
    }

}