package reporting_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlockedUserResponseModelTest {

    private BlockedUserResponseModel BlockedUserResponseModel;

    @BeforeEach
    void setUp(){
        BlockedUserResponseModel  = new BlockedUserResponseModel(true);
    }

    @Test
    void getBlockStatus() {
        assert(BlockedUserResponseModel.getBlockedStatus());
    }
}