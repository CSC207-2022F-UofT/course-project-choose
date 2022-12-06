package controller_presenter;

import blocking_reporting_system.blocking_system.BlockedUserOutputBoundary;
import blocking_reporting_system.blocking_system.BlockedUserPresenter;
import blocking_reporting_system.reporting_system.ReportedUserOutputBoundary;
import blocking_reporting_system.reporting_system.ReportedUserPresenter;
import email_request.*;
import login_management_system.*;
import matching_system.MatchOutputBoundary;
import matching_system.MatchUIPresenter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import upgrade.UpgradeOutputBoundary;
import upgrade.UpgradePresenter;
import user_register_system.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class tests the methods in BigPresenter.
 */
class BigPresenterTest {

    /** The big presenter for this test class. */
    private static BigPresenter presenters;

    /** Set up the big presenter of holding presenter in this program before running any tests. */
    @BeforeAll
    static void setUp() {
        // Create presenters
        MatchOutputBoundary matchUIPresenter = new MatchUIPresenter();
        EmailConnOutputBoundary emailConnPresenter = new EmailConnPresenter();
        UpgradeOutputBoundary upgradePresenter = new UpgradePresenter();
        LoginOutputBoundary loginPresenter = new LoginPresenter();
        UserRegUIOutputBoundary userRegUIPresenter = new UserRegUIPresenter();
        BlockedUserOutputBoundary blockedUserPresenter = new BlockedUserPresenter();
        ReportedUserOutputBoundary reportedUserPresenter= new ReportedUserPresenter();
        presenters = new BigPresenter(userRegUIPresenter,
                loginPresenter, matchUIPresenter,
                emailConnPresenter,
                upgradePresenter,
                blockedUserPresenter,
                reportedUserPresenter);

    }
    /**
     * Test to make sure an object of type MatchUIPresenter is returned.
     */
    @Test
    void getMatchUIPresenter() {
        assertNotNull(presenters.getMatchUIPresenter());
    }

    /**
     * Test to make sure an object of type EmailConnPresenter is returned.
     */
    @Test
    void getEmailConnPresenter() {
        assertNotNull(presenters.getEmailConnPresenter());
    }

    /**
     * Test to make sure an object of type UpgradePresenter is returned.
     */
    @Test
    void getUpgradePresenter() {
        assertNotNull(presenters.getUpgradePresenter());
    }

    /**
     * Test to make sure an object of type UserRegUIPresenter is returned.
     */
    @Test
    void getUserRegUIPresenter() {
        assertNotNull(presenters.getUserRegUIPresenter());
    }

    /**
     * Test to make sure an object of type BlockedUserPresenter is returned.
     */
    @Test
    void getBlockedUserPresenter() {
        assertNotNull(presenters.getBlockedUserPresenter());
    }

    /**
     * Test to make sure an object of type ReportedUsePresenter is returned.
     */
    @Test
    void getReportedUsePresenter() {
        assertNotNull(presenters.getReportedUsePresenter());
    }
}