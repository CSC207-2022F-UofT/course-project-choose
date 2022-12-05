package matching_system;


import email_request.EmailConnPresenter;
import email_request.EmailConnController;
import email_request.EmailConnResponseModel;
import upgrade.UpgradeController;
import upgrade.UpgradeOutputBoundary;
import upgrade.UpgradeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MatchResultsUI extends JPanel implements ActionListener {

    /** A controller responsible for email requesting */
    EmailConnController emailConnController;

    /** A controller responsible for upgrading requesting */
    UpgradeController upgradeController;
    /** A presenter that is responsible for preparing the view for upgrading requesting */
    UpgradeOutputBoundary upgradePresenter;

    /** The email address of the user who requests to see the match results. */
    private String requesterEmail;

    /** A list of email addresses of the matched users */
    private Map<Integer, String> targetUserEmails = new HashMap<>();

    /** The upgrade UI */
    private JFrame upgradeFrame;


    /** A preset of UI panel that display 5 user info which are included in the matchResponseModel
     * @param emailConnController Controller that is responsible to process email request.
     * @param upgradeController  Controller that is responsible to process upgrading request.
     * @param upgradePresenter Presenter that is responsible to preparing the view for upgrading request
     * @param requesterEmail email of the requester
     * @param matchUIPresenter the presenter that stores matchedRespondModel
     * */
    public MatchResultsUI(EmailConnController emailConnController,
                          UpgradeController upgradeController, UpgradeOutputBoundary upgradePresenter,
                          String requesterEmail,
                          MatchOutputBoundary matchUIPresenter){

        this.emailConnController = emailConnController;
        this.upgradeController = upgradeController;
        this.upgradePresenter = upgradePresenter;
        this.requesterEmail = requesterEmail;
        int count = 0;
        for(UserData user: matchUIPresenter.prepareView().getMatchedData()){
            // profile information to display
            String userIntro = "<html>Name: " + user.name + "<br>Gender: " +
                    user.gender.getGender() + " age: " + user.age + " height: "
                    + user.height + "<br> Hobby: " + user.hobby + " Program: " + user.programOfStudy +
                    "<br>SelfIntro: " + user.selfIntro;
            this.targetUserEmails.put(count, user.email);
            JLabel text = new JLabel(userIntro);

            // add a list of buttons including request email, block and report users.
            JButton requestEmail = new JButton("Request Email");
            requestEmail.setActionCommand("request" + count);
            JButton report = new JButton("Report this person");
            report.setActionCommand("report" + count);
            JButton block = new JButton("Block this person");
            block.setActionCommand("block" + count);

            // create a JPanel
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(500, 500));
            panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
            // add text and buttons to JPanel
            panel.add(text);
            text.setLocation(20, 20);
            text.setSize(text.getPreferredSize());

            requestEmail.setSize(requestEmail.getPreferredSize());
            requestEmail.setLocation(400, 20);
            panel.add(requestEmail);

            report.setSize(report.getPreferredSize());
            report.setLocation(400, 50);
            panel.add(report);


            block.setSize(block.getPreferredSize());
            block.setLocation(400, 80);
            panel.add(block);
            setSize(600, 500);
            requestEmail.addActionListener(this);
            report.addActionListener(this);
            block.addActionListener(this);
            panel.setBorder(BorderFactory.createLineBorder(Color.black));

            this.add(panel);
            count += 1;
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Add the upgrade window to this UI.
     * @param upgradeFrame the upgrade window shown to the user-at-keyboard when the number of email
     *                     requests is over the maximum limit.
     */
    public void addUpgradeFrame(JFrame upgradeFrame) {
        this.upgradeFrame = upgradeFrame;
    }

    /**
     * React to a button click that results in evt.
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        // If a request email button is clicked, then process the email request.
        if(evt.getActionCommand().startsWith("r")) {
            // targetUserEmail is the email that requester wants to see
            // we update targetUserEmail based on which button the requester clicks.
            String targetUserEmail = "";
            if (evt.getActionCommand().equals("request0")) {
                targetUserEmail = targetUserEmails.get(0);
            } else if (evt.getActionCommand().equals("request1")) {
                targetUserEmail = targetUserEmails.get(1);
            } else if (evt.getActionCommand().equals("request2")) {
                targetUserEmail = targetUserEmails.get(2);
            } else if (evt.getActionCommand().equals("request3")) {
                targetUserEmail = targetUserEmails.get(3);
            } else if (evt.getActionCommand().equals("request4")) {
                targetUserEmail = targetUserEmails.get(4);
            }
            // Process email request
            EmailConnResponseModel rm = emailConnController.create(requesterEmail, targetUserEmail);
            EmailConnPresenter rp = new EmailConnPresenter();
            EmailConnResponseModel prepareView = rp.prepareView(rm);
            // display the result for email request
            if (!prepareView.getRequestedEmailAddress().equals("")) {
                JOptionPane.showMessageDialog(this,
                        "The requested email address is " + prepareView.getRequestedEmailAddress());
            } else {
                // If requested email is not available, pop up the upgrade UI and asks whether the
                // user-at-keyboard would like to upgrade his account for unlimited email requests.
                upgradePresenter.setCurrentEmail(requesterEmail);
                UpgradeUI upgradeUI = new UpgradeUI(requesterEmail, upgradeController, upgradePresenter);
                this.addUpgradeFrame(upgradeUI);
                upgradeFrame.setVisible(true);
            }
        }

        // if a report button is clicked,

        // if a block button is clicked,

    } // end of the actionPerformed method
}

