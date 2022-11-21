package userReg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginUI extends JFrame {

    public UserLoginUI(){

        JFrame frame = new JFrame("User Registe");
        frame.setBounds(500,200,400,300);
        frame.setLayout(null);

        JLabel eMailStr = new JLabel("Email:");
        eMailStr.setBounds(20, 50, 100, 25);
        frame.add(eMailStr);

        JLabel passwordStr = new JLabel("Password:");
        passwordStr.setBounds(20, 100, 100, 25);
        frame.add(passwordStr);

        JLabel confrimStr = new JLabel("conPassword:");
        confrimStr.setBounds(20, 150, 100, 30);
        frame.add(confrimStr);

        JTextField eMail = new JTextField();
        eMail.setBounds(120, 50, 150, 25);
        frame.add(eMail);

        JButton buttonvertify = new JButton("vertify");
        buttonvertify.setBounds(280, 50, 80, 25);
        frame.add(buttonvertify);

        // buttonvertify addActionListener
        buttonvertify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JTextField password = new JPasswordField();
        password.setBounds(120, 100, 150, 25);
        frame.add(password);



        JPasswordField confirmpassword = new JPasswordField();
        confirmpassword.setBounds(120, 150, 150, 25);
        frame.add(confirmpassword);


        JButton buttonregister = new JButton("submit");
        buttonregister.setBounds(80, 200, 100, 25);
        frame.add(buttonregister);

        JButton buttonLogin = new JButton("login");
        buttonLogin.setBounds(220, 200, 100, 25);
        frame.add(buttonLogin);

        // buttonLogin addActionListener
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // buttonregister  addActionListener
        buttonregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                String eMail_v = new String(eMail.getText());
                String password_v = new String(password.getText());
                String confrimpasswd = new String (confirmpassword.getPassword());

                if (password_v.equals(confirmpassword)){

                }else {
                    JOptionPane.showMessageDialog(frame, "Entered passwords differ!", "passwords differ", JOptionPane.ERROR_MESSAGE);



                }
            }

        });

        frame.setVisible(true);
    }

}

