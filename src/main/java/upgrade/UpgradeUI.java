package upgrade;

import javax.swing.*;
import java.awt.*;

public class UpgradeUI extends JFrame {
    private JButton upgradeButton;
    private JButton backButton;
    private JLabel titleLabel;
    private JLabel hintLabel;
    private UpgradePresenter upgradePresenter;
    private UpgradeController upgradeController;
    private String currentEmail;


    public UpgradeUI(String email,
                    UpgradeController upgradeController,
                    UpgradePresenter upgradePresenter) {
        this.currentEmail = email;
        this.setSize(500, 420);
        this.setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setBounds(50,40,380, 40);
        titleLabel.setFont(new Font("Dialog", 1, 15));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel);

        hintLabel = new JLabel();
        hintLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hintLabel.setBounds(50,80,380, 120);
        this.add(hintLabel);

        upgradeButton = new JButton("Upgrade");
        upgradeButton.setBounds(50,240,380, 40);
        upgradeButton.addActionListener(e -> onUpgradeButtonClick());
        this.add(upgradeButton);


        backButton = new JButton("Back");
        backButton.setBounds(50,300,380, 40);
        backButton.addActionListener(e -> onBackButtonClick());
        this.add(backButton);

        this.upgradeController = upgradeController;
        this.upgradePresenter = upgradePresenter;
        refreshUI();
    }

    private void refreshUI() {
        UpgradePresenterViewModel viewModel = upgradePresenter.prepareView();
        titleLabel.setText(viewModel.getTitle());
        hintLabel.setText(viewModel.getHint());
        this.upgradeButton.setEnabled(viewModel.getNeedUpgrade());
    }

    private void onUpgradeButtonClick() {
        upgradeController.upgrade(currentEmail);
        refreshUI();
    }

    private void onBackButtonClick() {
        this.setVisible(false);
    }
}
