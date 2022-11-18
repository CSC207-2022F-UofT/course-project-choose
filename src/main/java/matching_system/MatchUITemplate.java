package matching_system;

import email_request.MatcherUIController;
import entities.*;

import javax.swing.*;
import java.awt.*;

public class MatchUITemplate extends JPanel {
    MatcherUIController matcherUIController;

    public MatchUITemplate(UserData user){

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

    public static void main(String[] args) {
        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB);
        JFrame application = new JFrame("View a user's profile page");

        JPanel screens = new JPanel();

        MatchUITemplate matchUITemplate = new MatchUITemplate(new UserData(userAccountB));
//        MatchUITemplate matchUITemplate2 = new MatchUITemplate();
        screens.add(matchUITemplate);
//        screens.add(matchUITemplate2);
        screens.setLayout(new BoxLayout(screens, BoxLayout.Y_AXIS));
        application.add(screens);
        application.pack();
        application.setVisible(true);
    }
}
