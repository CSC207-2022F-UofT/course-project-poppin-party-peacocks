package GUI.Listeners;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Logic to switch the content of the WelcomePage.
 */
public class WelcomePageActionListenerSwitchPanels {
    // listener for show login button click
    private final ActionListener showLoginPanelActionListener;
    // listener for show signup button click
    private final ActionListener showSignupPanelActionListener;

    /**
     * @param mainPanel main panel of WelcomePage.
     * @param loginPanel login panel of WelcomePage. User can log in to existing account. Default panel.
     * @param signupPanel signup panel of WelcomePage. User can signup.
     */
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

    /**
     * @return ActionListener for login
     */
    public ActionListener getLoginActionListener(){
        return showLoginPanelActionListener;
    }

    /**
     * @return ActionListener for signup
     */
    public ActionListener getSignupActionListener(){
        return showSignupPanelActionListener;
    }




}