package upgrade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpgradeResponseModelTest {

    @Test
    void testGetEmail() {
        String mockEmail = "terry.tan@mail.utoronto.ca";
        UpgradeRequestModel upgradeModel = new UpgradeRequestModel(mockEmail);
        assertEquals(mockEmail, upgradeModel.getEmail());
    }
}
