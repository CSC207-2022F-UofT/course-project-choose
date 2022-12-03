package login_management_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginRequestModelTest {
    private LoginRequestModel loginRequestModel;

    @BeforeEach
    void setUp(){
        loginRequestModel = new LoginRequestModel("b@hotmail.com", "david.david");
    }

    @Test
    void getName() {assertEquals(loginRequestModel.getName(), "b@hotmail.com");}

    @Test
    void getPassword() {assertEquals(loginRequestModel.getPassword(), "david.david");}
}
