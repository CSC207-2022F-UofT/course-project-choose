package login_management_system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;

public class LoginFailedExceptionTest {
    @Test
    void testGetMessage(){
        LoginFailedException e = assertThrows(LoginFailedException.class, () ->
        {throw new LoginFailedException("message");});
        Assertions.assertEquals("message", e.getMessage());
    }
}
