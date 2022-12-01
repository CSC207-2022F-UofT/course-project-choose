package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in MatcherUIResponseModel.
 */
class MatcherUIResponseModelTest {

    private MatcherUIResponseModel matcherUIResponseModel;

    /**
     * Set up matcherUIResponseModel for each test.
     */
    @BeforeEach
    void setUp(){
        matcherUIResponseModel  = new MatcherUIResponseModel("david.david@hotmail.com");
    }

    /** Test to make sure getRequestedEmailAddress returns the requested email address */
    @Test
    void getRequestedEmailAddress() {
        assertEquals("david.david@hotmail.com",
                matcherUIResponseModel.getRequestedEmailAddress());
    }
}