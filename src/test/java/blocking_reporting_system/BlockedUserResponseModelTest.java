package blocking_reporting_system;

import blocking_reporting_system.blocking_system.BlockedUserResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlockedUserResponseModelTest {

    private blocking_reporting_system.blocking_system.BlockedUserResponseModel BlockedUserResponseModel;

    @BeforeEach
    void setUp(){
        BlockedUserResponseModel  = new BlockedUserResponseModel(true);
    }

    @Test
    void getBlockStatus() {
        assert(BlockedUserResponseModel.getBlockedStatus());
    }
}