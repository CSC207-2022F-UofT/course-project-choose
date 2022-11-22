package reporting_system;

import org.junit.Test;

public class ReportedUserTest {


    @Test
    public void testReported(){
        boolean res = new ReportedUser().reportedUser("emma.emma@mail.utoronto.ca");
        System.out.println(res);
    }
}
