package userreg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userreg.*;

import static org.junit.Assert.assertEquals;

class UserRegUIResponseModelTest {

    private UserRegUIResponseModel userRegUIResponseModel;

    @BeforeEach
    void setUp(){
        this.userRegUIResponseModel = new UserRegUIResponseModel("ERR001");
    }

    @Test
    void getRegMessage() {
        assertEquals("ERR001",
                this.userRegUIResponseModel.getRegMessage());
    }
}