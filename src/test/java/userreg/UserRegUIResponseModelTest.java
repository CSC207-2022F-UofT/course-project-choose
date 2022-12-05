package userreg;

import org.junit.jupiter.api.Assertions;
import user_register_system.UserRegUIResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class UserRegUIResponseModelTest {

    private UserRegUIResponseModel userRegUIResponseModel;

    @BeforeEach
    void setUp(){
        this.userRegUIResponseModel = new UserRegUIResponseModel("ERR001");
    }

    @Test
    void getRegMessage() {
        Assertions.assertEquals("ERR001", this.userRegUIResponseModel.getRegMessage());
    }
}