package Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePageActionListenerSwitchPanels {

    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel signupPanel;
    private JFrame currJFrame;
    private ActionListener showLoginPanelActionListener;
    private ActionListener showSignupPanelActionListener;
    private ActionListener navToHomePage;
    UserRegisterController controller;

    public WelcomePageActionListenerSwitchPanels(JFrame currJFrame, JPanel mainPanel, JPanel loginPanel, JPanel signupPanel) {
        this.mainPanel = mainPanel;
        this.loginPanel = loginPanel;
        this.signupPanel = signupPanel;
        this.currJFrame = currJFrame;

        showLoginPanelActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(signupPanel);
                mainPanel.add(loginPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        };

        showSignupPanelActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(loginPanel);
                mainPanel.add(signupPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        };

        navToHomePage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.HomePage homePage = new GUI.HomePage(controller);
                homePage.setContentPane(homePage.getMainPanel());
                homePage.setVisible(true);
                homePage.setLocationRelativeTo(null);
                homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        };
    }

    public ActionListener getLoginActionListener(){
        return showLoginPanelActionListener;
    }

    public ActionListener getSignupActionListener(){
        return showSignupPanelActionListener;
    }




}