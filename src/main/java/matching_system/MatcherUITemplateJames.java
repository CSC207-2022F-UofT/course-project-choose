package matching_system;


import email_request.MatcherUIController;
import email_request.MatcherUIPresenter;
import email_request.MatcherUIResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MatcherUITemplateJames extends JPanel implements ActionListener {
    MatcherUIController matcherUIController;
    private String requesterEmail;
    private Map<Integer, String> targetUserEmails = new HashMap<>();

    /** A preset of UI panel that display 5 user info which are included in the matchResponseModel
     */
    public MatcherUITemplateJames(MatcherUIController matcherUIController,
                             String requesterEmail,
                             MatchOutputBoundary matchUIPresenter){

        this.matcherUIController = matcherUIController;
        this.requesterEmail = requesterEmail;
        Integer count = 0;
        for(UserData user: matchUIPresenter.prepareView().getMatchedData()){
            // profile information to display
            String userIntro = "<html>Name: " + user.name + "<br>Gender: " +
                    user.gender.getGender() + " age: " + user.age + " height: "
                    + user.height + "<br> Hobby: " + user.hobby + " Program: " + user.programOfStudy +
                    "<br>SelfIntro: " + user.selfIntro;
            this.targetUserEmails.put(count, user.email);
            JLabel text = new JLabel(userIntro);

            // add a list of buttons
            JButton requestEmail = new JButton("Request Email");
            requestEmail.setActionCommand("request" + count);
            JButton report = new JButton("Report this person");
            report.setActionCommand("report" + count);
            JButton block = new JButton("Block this person");
            block.setActionCommand("block" + count);

            // create a JPanel
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(500, 500));
            panel.setLayout(null);
            // add text and buttons to JPanel
            // those are FlowLayout
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
     * React to a button click that results in evt.
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        // targetUserEmail is the email that requester wants to see
        // we update targetUserEmail based on which button the requester clicks.
        String targetUserEmail = "";
        if(evt.getActionCommand().equals("request0")){
            targetUserEmail = targetUserEmails.get(0);
        }else if(evt.getActionCommand().equals("request1")){
            targetUserEmail = targetUserEmails.get(1);
        }else if(evt.getActionCommand().equals("request2")){
            targetUserEmail = targetUserEmails.get(2);
        }else if(evt.getActionCommand().equals("request3")){
            targetUserEmail = targetUserEmails.get(3);
        }else if(evt.getActionCommand().equals("request4")){
            targetUserEmail = targetUserEmails.get(4);
        }
        // Process email request
        MatcherUIResponseModel rm =  matcherUIController.create(requesterEmail, targetUserEmail);
        MatcherUIPresenter rp = new MatcherUIPresenter();
        MatcherUIResponseModel prepareView = rp.prepareView(rm);
        // display the result for email request
        if(!prepareView.getRequestedEmailAddress().equals("")){
            JOptionPane.showMessageDialog(this,
                    "The requested email address is " + prepareView.getRequestedEmailAddress());
        }else{
            // upgrade page
        }

    }
}

