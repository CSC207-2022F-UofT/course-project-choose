package email_request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UITemplate extends JPanel implements ActionListener {

    ProfileViewUIController profileViewUIController;
    private String requesterEmail;
    private String targetUserEmail;

    public UITemplate(ProfileViewUIController profileViewUIController,
                      String requesterEmail, String targetUserEmail){

        this.profileViewUIController = profileViewUIController;
        this.requesterEmail = requesterEmail;
        this.targetUserEmail = targetUserEmail;

        JLabel title = new JLabel("Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton requestEmail = new JButton("Request Email");

        JPanel buttons = new JPanel();
        buttons.add(requestEmail);

        requestEmail.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        ConnViaEmailResponseModel rm =  profileViewUIController.create(requesterEmail, targetUserEmail);
        ConnViaEmailPresenter rp = new ConnViaEmailPresenter();
        ConnViaEmailResponseModel prepareView = rp.prepareView(rm);

        if(prepareView.getRequestedEmailAddress() != ""){
            JOptionPane.showMessageDialog(this,
                    "The requested email address is " + prepareView.getRequestedEmailAddress());
        }else{
            // upgrade page
        }









    }
}
