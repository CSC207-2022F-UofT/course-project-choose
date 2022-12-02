package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatcherUIResponseModelTest {

    private MatcherUIResponseModel matcherUIResponseModel;

    @BeforeEach
    void setUp(){
        matcherUIResponseModel  = new MatcherUIResponseModel("david.david@hotmail.com");
    }

    @Test
    void getRequestedEmailAddress() {
        assertEquals("david.david@hotmail.com",
                matcherUIResponseModel.getRequestedEmailAddress());
    }
}