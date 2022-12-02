package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatcherUIPresenterTest {

    private MatcherUIPresenter mp;

    @BeforeEach
    void setUp(){
       mp = new MatcherUIPresenter();
    }

    @Test
    void prepareView() {
        MatcherUIResponseModel rm  = new MatcherUIResponseModel("david.david@hotmail.com");
        MatcherUIResponseModel result =  mp.prepareView(rm);
        assertTrue(result == rm);
    }
}