package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatcherUIRequestModelTest {

    private MatcherUIRequestModel matcherUIRequestModel;

    @BeforeEach
    void setUp(){
        matcherUIRequestModel = new MatcherUIRequestModel("david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
    }

    @Test
    void getRequester() {
        assertEquals(matcherUIRequestModel.getRequester(), "david.david@hotmail.com");
    }

    @Test
    void getTargetUser() {
        assertEquals(matcherUIRequestModel.getTargetUser(), "emma.emma@mail.utoronto.ca");
    }

}