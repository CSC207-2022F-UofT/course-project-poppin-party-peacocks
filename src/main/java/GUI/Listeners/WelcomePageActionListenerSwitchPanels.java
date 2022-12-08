package GUI.Listeners;
import javax.swing.*;
import java.awt.event.ActionListener;

public class WelcomePageActionListenerSwitchPanels {

    private final ActionListener showLoginPanelActionListener;
    private final ActionListener showSignupPanelActionListener;

    public WelcomePageActionListenerSwitchPanels(JPanel mainPanel, JPanel loginPanel, JPanel signupPanel) {

        showLoginPanelActionListener = e -> {
            mainPanel.remove(signupPanel);
            mainPanel.add(loginPanel);
            mainPanel.repaint();
            mainPanel.revalidate();
        };

        showSignupPanelActionListener = e -> {
            mainPanel.remove(loginPanel);
            mainPanel.add(signupPanel);
            mainPanel.repaint();
            mainPanel.revalidate();
        };
    }

    public ActionListener getLoginActionListener(){
        return showLoginPanelActionListener;
    }

    public ActionListener getSignupActionListener(){
        return showSignupPanelActionListener;
    }




}