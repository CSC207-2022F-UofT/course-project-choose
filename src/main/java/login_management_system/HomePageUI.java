package login_management_system;

import controller_presenter.BigController;
import controller_presenter.BigPresenter;
import matching_system.MatchResponseModel;
import matching_system.MatchResultsUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Layer: User interface layer
 */
public class HomePageUI extends JPanel implements ActionListener {
    LoginResponseModel profile_info;
    private BigController controllers;
    private BigPresenter presenters;

    /**
     * A window that shows the homepage UI panel
     * @param profile_info a data model that contains the user who logins successfully.
     * @param controllers the controller for all UI pages.
     * @param presenters the presenter for all UI pages.
     */
    public HomePageUI(LoginResponseModel profile_info, BigController controllers,
                      BigPresenter presenters){
        this.profile_info = profile_info;
        this.controllers = controllers;
        this.presenters = presenters;

        // Frame
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        // Profile Image
        JLabel image = new JLabel(new ImageIcon("src/main/resources/profile_image.jpg"));
        image.setBounds(40, 50, 200, 200);
        panel.add(image);

        // HomePage Label
        JLabel homePageLabel = new JLabel("Profile");
        homePageLabel.setBounds(280, 50, 100, 25);
        homePageLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        panel.add(homePageLabel);

        // User Information
        JLabel name = new JLabel("Name: " + profile_info.getUser().getName());
        JLabel gender = new JLabel("Gender: " + profile_info.getUser().getGender().getGender());
        JLabel age = new JLabel("Age: " + profile_info.getUser().getAge());
        JLabel height = new JLabel("Height: " + profile_info.getUser().getHeight());
        JLabel program = new JLabel("Program: " + profile_info.getUser().getProgramOfStudy());
        JLabel hobbies = new JLabel("Hobby: " + profile_info.getUser().getHobby().getHobby());
        JLabel intro_title = new JLabel("Introduction:");
        JTextArea self_intro = new JTextArea(profile_info.getUser().getSelfIntro());
        JLabel oriented_gender = new JLabel("Gender Orientation: " + profile_info.getUser().
                getInterestedIn().getGender());
        name.setBounds(280, 70, 200, 25);
        gender.setBounds(280, 90, 200, 25);
        age.setBounds(280, 110, 200, 25);
        height.setBounds(280, 130, 200, 25);
        program.setBounds(280, 150, 200, 25);
        hobbies.setBounds(280, 170, 200, 25);
        oriented_gender.setBounds(280, 190, 200, 25);
        intro_title.setBounds(280, 210, 200, 25);
        self_intro.setBounds(280, 235, 200, 25);
        panel.add(name);
        panel.add(gender);
        panel.add(age);
        panel.add(height);
        panel.add(program);
        panel.add(hobbies);
        panel.add(intro_title);
        panel.add(self_intro);
        panel.add(oriented_gender);

        // Match Button
        JButton matchingButton = new JButton("Match");
        matchingButton.setBounds(250, 300, 100, 25);
        matchingButton.setActionCommand("match");
        matchingButton.addActionListener(this);
        panel.add(matchingButton);

        // This part of code is commented out because the team member Aria Hu
//        // Search Box
//        JTextField searchInput = new JTextField(20);
//        searchInput.setBounds(130, 350, 120, 25);
//        panel.add(searchInput);
//
//
//        // Search Button
//        JButton searchingButton = new JButton("Search");
//        searchingButton.setActionCommand("search");
//        searchingButton.addActionListener(this);
//        searchingButton.setBounds(250, 350, 100, 25);
//        panel.add(searchingButton);
//
//        // Search Choice Box
//        String[] s = { "Default", "Program of Study" };
//        JComboBox<String> searchBox = new JComboBox<>(s);
//        searchBox.setBounds(350, 350, 100, 25);
//        panel.add(searchBox);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if the match button is clicked, let MatchController take care of the request.
        if(e.getActionCommand().startsWith("m")){
            JFrame application = new JFrame("Matching results");
            MatchResponseModel matchResponseModel =  this.controllers.getMatchController().create(profile_info.getEmail());
            this.presenters.getMatchUIPresenter().setMatchResponseModel(matchResponseModel);
            MatchResultsUI matcherResultsUI = new MatchResultsUI(this.controllers.getEmailConnController(),
                    this.controllers.getUpgradeController(), this.presenters.getUpgradePresenter(),
                    profile_info.getEmail(), this.presenters.getMatchUIPresenter());
            // Display match results to users.
            application.add(matcherResultsUI);
            application.pack();
            application.setVisible(true);
        }
    }
}
