package login_management_system;


import javax.swing.*;
import java.awt.*;

// Need Further Implementation

public class HomePageUI {
    String email;
    public HomePageUI(String email){
        JLabel title = new JLabel("HomePage");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
    }

}
