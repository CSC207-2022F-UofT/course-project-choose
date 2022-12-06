package matching_system;


import blocking_reporting_system.blocking_system.BlockedUserResponseModel;
import blocking_reporting_system.reporting_system.ReportedUserResponseModel;
import controller_presenter.BigController;
import controller_presenter.BigPresenter;
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
    BigController controllers;

    BigPresenter presenters;

    /** The email address of the user who requests to see the match results. */
    private final String requesterEmail;

    /** A list of email addresses of the matched users */
    private Map<Integer, String> targetUserEmails = new HashMap<>();

    /** The upgrade UI */
    private JFrame upgradeFrame;


    /** A preset of UI panel that display 5 user info which are included in the matchResponseModel
     * @param requesterEmail email of the requester
     * */
    public MatchResultsUI(BigController controllers,
                          BigPresenter presenters,
                          String requesterEmail){

        this.controllers = controllers;
        this.presenters = presenters;
        this.requesterEmail = requesterEmail;
        int count = 0;
        for(UserData user: this.presenters.getMatchUIPresenter().prepareView().getMatchedData()){
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
        String targetUserEmail = "";
        if (evt.getActionCommand().endsWith("0")) {
            targetUserEmail = targetUserEmails.get(0);
        } else if (evt.getActionCommand().endsWith("1")) {
            targetUserEmail = targetUserEmails.get(1);
        } else if (evt.getActionCommand().endsWith("2")) {
            targetUserEmail = targetUserEmails.get(2);
        } else if (evt.getActionCommand().endsWith("3")) {
            targetUserEmail = targetUserEmails.get(3);
        } else if (evt.getActionCommand().endsWith("4")) {
            targetUserEmail = targetUserEmails.get(4);
        }

        // If a request email button is clicked, then process the email request.
        if(evt.getActionCommand().startsWith("request")) {
            // Process email request
            EmailConnResponseModel rm = this.controllers.getEmailConnController().request(requesterEmail, targetUserEmail);
            EmailConnResponseModel prepareView = this.presenters.getEmailConnPresenter().prepareView(rm);
            // display the result for email request
            if (!prepareView.getRequestedEmailAddress().equals("")) {
                JOptionPane.showMessageDialog(this,
                        "The requested email address is " + prepareView.getRequestedEmailAddress());
            } else {
                // If requested email is not available, pop up the upgrade UI and asks whether the
                // user-at-keyboard would like to upgrade his account for unlimited email requests.
                this.presenters.getUpgradePresenter().setCurrentEmail(requesterEmail);
                UpgradeUI upgradeUI = new UpgradeUI(requesterEmail, this.controllers.getUpgradeController(),
                        this.presenters.getUpgradePresenter());
                this.addUpgradeFrame(upgradeUI);
                upgradeFrame.setVisible(true);
            }
        } // end of email request

        // if a block user button is clicked, process the block request.
        if(evt.getActionCommand().startsWith("block")) {
            BlockedUserResponseModel burm = this.controllers.getBlockedUserController().updateBlocked(requesterEmail,targetUserEmail);
            BlockedUserResponseModel prepareView = this.presenters.getBlockedUserPresenter().prepareView(burm);
            boolean blockFlag=prepareView.getBlockedStatus();
            if(blockFlag){
                JOptionPane.showMessageDialog(null, "block success!");
            }else{
                JOptionPane.showMessageDialog(null, "block fail!");
            }
        } // end of block request

        // if a report user button is clicked, process the report request.
        if(evt.getActionCommand().startsWith("report")) {
            ReportedUserResponseModel rurm = this.controllers.getReportedUserController().updateReported(targetUserEmail);
            ReportedUserResponseModel prepareView = this.presenters.getReportedUsePresenter().prepareView(rurm);
            boolean reportFlag=prepareView.getReportedStatus();
            if(reportFlag){
                JOptionPane.showMessageDialog(null, "report success!");
            }else{
                JOptionPane.showMessageDialog(null, "report fail!");
            }
        } // end of report request

    } // end of the actionPerformed method



}

