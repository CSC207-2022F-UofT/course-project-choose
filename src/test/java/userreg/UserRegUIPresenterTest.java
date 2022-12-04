package userreg;

import User_Register_System.UserRegUIPresenter;
import User_Register_System.UserRegUIResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userreg.*;

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
        assertTrue(result == rm);
    }
}