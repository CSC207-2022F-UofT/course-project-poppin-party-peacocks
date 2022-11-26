package Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePageActionListener {

    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel signupPanel;
    private ActionListener showLoginPanelActionListener;
    private ActionListener showSignupPanelActionListener;

    public WelcomePageActionListener(JPanel mainPanel, JPanel loginPanel, JPanel signupPanel) {
        this.mainPanel = mainPanel;
        this.loginPanel = loginPanel;
        this.signupPanel = signupPanel;

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
    }

    public ActionListener getLoginActionListener(){
        return showLoginPanelActionListener;
    }

    public ActionListener getSignupActionListener(){
        return showSignupPanelActionListener;
    }




}