package login_management_system;

import controller_presenter.BigController;
import controller_presenter.BigPresenter;
import user_register_system.UserRegUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Layer: User interface layer
 */

public class LoginUI extends JPanel {

    private final JTextField userInput;
    private final JPasswordField passwordInput;
    private final BigPresenter bigPresenter;
    private final BigController bigController;

    /**
     * A window that shows the Login UI panel
     * @param bigController the controller for all UI pages.
     * @param bigPresenter the presenter for all UI pages.
     */

    public LoginUI(BigController bigController, BigPresenter bigPresenter) {
        this.bigController = bigController;
        this.bigPresenter = bigPresenter;

       JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        // username field
        JLabel userLabel = new JLabel("Email");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        userInput = new JTextField(20);
        userInput.setBounds(100, 20, 165, 25);
        panel.add(userInput);

        // password field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        passwordInput = new JPasswordField();
        passwordInput.setBounds(100, 50, 165, 25);
        panel.add(passwordInput);

        // button field
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 80, 100, 25);
        loginButton.addActionListener((ActionEvent e) -> {
            try{
                this.bigController.getLoginController().checkValidLogin(userInput.getText(), String.valueOf(passwordInput.getPassword()));
                // If with no Exception, should direct to HomePageUI
                LoginResponseModel profile_info = this.bigController.getLoginController().checkValidLogin(userInput.getText(),
                        String.valueOf(passwordInput.getPassword()));
                frame.dispose();
                new HomePageUI(profile_info, bigController, bigPresenter).setVisible(true);
            } catch (LoginFailedException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(180, 80, 100, 25);
        registerButton.addActionListener((ActionEvent e) -> {
            // Turn to RegisterUI
            UserRegUI userRegUi = new UserRegUI(this.bigController, this.bigPresenter);
            userRegUi.setPreferredSize(new Dimension(500, 600));
            userRegUi.pack();
            userRegUi.setVisible(true);
//            JFrame application = new JFrame("User Register");
//            application.setPreferredSize(new Dimension(500, 600));
//            application.add(userRegUi);
//            application.pack();
//            application.setVisible(true);
        });
        panel.add(registerButton);
        frame.setPreferredSize(new Dimension(500, 600));
        frame.setVisible(true);
    }

}
