package reporting_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockedUserPresenterTest {

    private BlockedUserPresenter mp;

    @BeforeEach
    void setUp(){
       mp = new BlockedUserPresenter();
    }

    @Test
    void prepareView() {
        BlockedUserResponseModel rm  = new BlockedUserResponseModel(true);
        BlockedUserResponseModel result =  mp.prepareView(rm);
        assertTrue(result == rm);
    }
}