package email_request;

import matching_system.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatcherUITemplate extends JPanel implements ActionListener {

    MatcherUIController matcherUIController;
    private String requesterEmail;
    private String targetUserEmail;

    public MatcherUITemplate(MatcherUIController matcherUIController,
                             String requesterEmail, String targetUserEmail,
                             MatchOutputBoundary matchUIPresenter){

        this.matcherUIController = matcherUIController;
        this.requesterEmail = requesterEmail;
        this.targetUserEmail = targetUserEmail;

        for(UserData matchResults: matchUIPresenter.prepareView().getMatchedData()){
            MatchUserPanel matchUserPanel = new MatchUserPanel(matchResults);
            this.add(matchUserPanel);
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        MatcherUIResponseModel rm =  matcherUIController.create(requesterEmail, targetUserEmail);
        MatcherUIPresenter rp = new MatcherUIPresenter();
        MatcherUIResponseModel prepareView = rp.prepareView(rm);

        if(prepareView.getRequestedEmailAddress() != ""){
            JOptionPane.showMessageDialog(this,
                    "The requested email address is " + prepareView.getRequestedEmailAddress());
        }else{
            // upgrade page
        }









    }
}
