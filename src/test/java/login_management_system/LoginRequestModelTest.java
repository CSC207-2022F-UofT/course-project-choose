package login_management_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class test methods in LoginRequestModel.
 */

public class LoginRequestModelTest {
    private LoginRequestModel loginRequestModel;

    /**
     * Set up data access and controller for each test.
     */

    @BeforeEach
    void setUp(){
        loginRequestModel = new LoginRequestModel("b@hotmail.com", "david.david");
    }

    /**
     * Test the getter method in the request model.
     */
    @Test
    void getName() {assertEquals(loginRequestModel.getName(), "b@hotmail.com");}

    /**
     * Test the getter method in the request model.
     */
    @Test
    void getPassword() {assertEquals(loginRequestModel.getPassword(), "david.david");}
}
