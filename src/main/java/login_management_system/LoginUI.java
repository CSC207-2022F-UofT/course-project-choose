package login_management_system;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginUI extends JPanel {

    private final JTextField userInput;
    private final JPasswordField passwordInput;
    LoginController loginController;

    public LoginUI(LoginController loginController) {
        this.loginController = loginController;

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
                loginController.checkValidLogin(userInput.getText(), String.valueOf(passwordInput.getPassword()));
                // If with no Exception, should direct to HomePageUI (have username as input)
                // HomePageUI
                LoginResponseModel profile_info = loginController.checkValidLogin(userInput.getText(),
                            String.valueOf(passwordInput.getPassword()));
                frame.dispose();
                new HomePageUI(profile_info).setVisible(true);
            } catch (LoginFailedException ex){
                JOptionPane.showMessageDialog(null, ex.getmessage());
            }
        });
        panel.add(loginButton);



        JButton registerButton = new JButton("Register");
        registerButton.setBounds(180, 80, 100, 25);
        registerButton.addActionListener((ActionEvent e) -> {
            // Turn to RegisterUI
        });
        panel.add(registerButton);

        frame.setVisible(true);
    }

}
