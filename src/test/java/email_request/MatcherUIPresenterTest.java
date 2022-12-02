package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in MatcherUIPresenter.
 */
class MatcherUIPresenterTest {

    private MatcherUIPresenter mp;

    /**
     * Set up the presenter for each test.
     */
    @BeforeEach
    void setUp(){
       mp = new MatcherUIPresenter();
    }

    /**
     * In our case, prepareView does not manipulate the given method parameter and simply
     * returns the same object that is given as its parameter.
     * Thus, we test to make sure that the same object is returned.
     */
    @Test
    void prepareView() {
        MatcherUIResponseModel rm  = new MatcherUIResponseModel("david.david@hotmail.com");
        MatcherUIResponseModel result =  mp.prepareView(rm);
        assertSame(result, rm);
    }
}