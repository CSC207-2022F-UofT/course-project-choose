package email_request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in EmailConnPresenter.
 */
class MatcherUIPresenterTest {

    private EmailConnPresenter mp;

    /**
     * Set up the presenter for each test.
     */
    @BeforeEach
    void setUp(){
       mp = new EmailConnPresenter();
    }

    /**
     * In our case, prepareView does not manipulate the given method parameter and simply
     * returns the same object that is given as its parameter.
     * Thus, we test to make sure that the same object is returned.
     */
    @Test
    void prepareView() {
        EmailConnResponseModel rm  = new EmailConnResponseModel("david.david@hotmail.com");
        EmailConnResponseModel result =  mp.prepareView(rm);
        assertSame(result, rm);
    }
}