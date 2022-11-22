package reporting_system;

import org.junit.Test;

public class BlockedUserTest {

    @Test
    public void BlockedUser(){
        boolean res = new BlockedUser().blockedUser("emma.emma@mail.utoronto.ca", "david.david@hotmail.com");
        System.out.println(res);
    }
}
