package GUI;

import Controller.UserRegisterController;
import GUI.Listeners.WelcomePageActionListenerSwitchPanels;
import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame{
    UserRegisterController userRegisterController;
    private final JPanel mainPanel;
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public WelcomePage(UserRegisterController controller) {
        super("Login Page");
        this.userRegisterController = controller;
        setLayout(null);
        setSize(360, 640);
        setResizable(false);

        JLabel titleLabel = new JLabel("Starlight Wishes");
        Font titleFont = new Font("Sans Serif", Font.PLAIN, 20);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(103, 13, 154, 24);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 360, 640);
        Color color2 = new Color(106, 189, 154);
        mainPanel.setBackground(color2);
        mainPanel.add(titleLabel);

        JPanel loginPanel = new LoginPanel(this);
        mainPanel.add(loginPanel);

        JPanel signupPanel = new SignupPanel(userRegisterController);

        Font buttonFont = new Font("Sans Serif", Font.PLAIN, 12);
        CustomJButton switchToLoginButton = new CustomJButton("Login Page", 0, 0,
                Color.WHITE, Color.BLACK,
                buttonFont);
        switchToLoginButton.setBounds(30, 550, 130, 15);
        CustomJButton switchToSignupButton = new CustomJButton("Sign Up Page", 0, 0,
                Color.WHITE, Color.BLACK,
                buttonFont);
        switchToSignupButton.setBounds(190, 550, 130, 15);
        mainPanel.add(switchToLoginButton);
        mainPanel.add(switchToSignupButton);

        WelcomePageActionListenerSwitchPanels wpal = new WelcomePageActionListenerSwitchPanels(mainPanel, loginPanel, signupPanel);
        switchToLoginButton.addActionListener(wpal.getLoginActionListener());
        switchToSignupButton.addActionListener(wpal.getSignupActionListener());

        // footer panel
        JPanel footerPanel = new JPanel(new FlowLayout());
        JButton gotoLoginPanelButton = new JButton("Login");
        JButton gotoSignupPanelButton = new JButton("Sign Up");
        footerPanel.add(gotoLoginPanelButton);
        footerPanel.add(gotoSignupPanelButton);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
    }
}
