package matching_system;

import email_request.MatcherUIController;
import entities.*;

import javax.swing.*;
import java.awt.*;

public class MatchUserPanel extends JPanel {
    MatcherUIController matcherUIController;

    public MatchUserPanel(UserData user){

//        this.matcherUIController = matcherUIController;
        String userIntro = "<html>Name: "+user.name+"<br>Gender: "+user.gender.getGender()+" age: "+user.age+" height: "
                +user.height+"<br> Hobby: "+ user.hobby+" Program: "+user.programOfStudy+
                "<br>SelfIntro: "+ user.selfIntro;
        JLabel text = new JLabel(userIntro);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton requestEmail = new JButton("Request Email");

        JPanel buttons = new JPanel();
        buttons.add(requestEmail);
        this.add(text);
        this.add(buttons);
//        requestEmail.addActionListener(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(300, 125));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
