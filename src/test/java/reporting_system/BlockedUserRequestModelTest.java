package reporting_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockedUserRequestModelTest {

    private BlockedUserRequestModel BlockedUserRequestModel;

    @BeforeEach
    void setUp(){
        BlockedUserRequestModel = new BlockedUserRequestModel("e@hotmail.com",
                "f@mail.utoronto.ca");
    }

    @Test
    void getRequester() {
        assertEquals(BlockedUserRequestModel.getEmail(), "e@hotmail.com");
    }

    @Test
    void getTargetUser() {
        assertEquals(BlockedUserRequestModel.getBlockedEmail(), "f@mail.utoronto.ca");
    }

}