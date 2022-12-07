package userreg;

import user_register_system.UserRegUIPresenter;
import user_register_system.UserRegUIResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegUIPresenterTest {

    private UserRegUIPresenter mp;

    @BeforeEach
    void setUp(){
       mp = new UserRegUIPresenter();
    }

    @Test
    void prepareView() {
        UserRegUIResponseModel rm  = new UserRegUIResponseModel("SUCCESS");
        UserRegUIResponseModel result =  mp.prepareView(rm);
        assertSame(result, rm);
    }
}