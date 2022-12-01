package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in MatcherUIRequestModel.
 */
class MatcherUIRequestModelTest {

    private MatcherUIRequestModel matcherUIRequestModel;

    /** Set up matcherUIRequestModel for each test */
    @BeforeEach
    void setUp(){
        matcherUIRequestModel = new MatcherUIRequestModel("david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
    }

    /**
     * Test to make sure that getRequester returns the requester's email address
     */
    @Test
    void getRequester() {
        assertEquals(matcherUIRequestModel.getRequester(), "david.david@hotmail.com");
    }

    /**
     * Test to make sure getTargerUser returns the email address of the user whose email address is requested.
     */
    @Test
    void getTargetUser() {
        assertEquals(matcherUIRequestModel.getTargetUser(), "emma.emma@mail.utoronto.ca");
    }

}