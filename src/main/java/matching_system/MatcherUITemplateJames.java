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

    public MatcherUITemplateJames(MatcherUIController matcherUIController,
                             String requesterEmail,
                             MatchResponseModel matchResponseModel){

        this.matcherUIController = matcherUIController;
        this.requesterEmail = requesterEmail;
        Integer count = 0;
        for(UserData user: matchResponseModel.getMatchedData()){

            String userIntro = "<html>Name: " + user.name + "<br>Gender: " +
                    user.gender.getGender() + " age: " + user.age + " height: "
                    + user.height + "<br> Hobby: " + user.hobby + " Program: " + user.programOfStudy +
                    "<br>SelfIntro: " + user.selfIntro;
            JLabel text = new JLabel(userIntro);
            text.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.targetUserEmails.put(count, user.email);
            JButton requestEmail = new JButton("Request Email");
            requestEmail.setActionCommand("action" + count);
            JPanel buttons = new JPanel();
            buttons.add(requestEmail);
            requestEmail.addActionListener(this);
            this.add(text);
            this.add(buttons);
            this.setBorder(BorderFactory.createLineBorder(Color.black));
            this.setPreferredSize(new Dimension(300, 125));
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
        if(evt.getActionCommand().equals("action0")){
            targetUserEmail = targetUserEmails.get(0);
        }else if(evt.getActionCommand().equals("action1")){
            targetUserEmail = targetUserEmails.get(1);
        }else if(evt.getActionCommand().equals("action2")){
            targetUserEmail = targetUserEmails.get(2);
        }else if(evt.getActionCommand().equals("action3")){
            targetUserEmail = targetUserEmails.get(3);
        }else if(evt.getActionCommand().equals("action4")){
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

