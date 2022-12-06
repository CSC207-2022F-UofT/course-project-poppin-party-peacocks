package GUI.Listeners;
import GUI.HomePage;
import UseCases.LoginAction;

import javax.swing.*;
import java.awt.event.ActionListener;

public class WelcomePageActionListenerNavigation {
    private JFrame currJFrame;
    private ActionListener navToHomePage;

    public WelcomePageActionListenerNavigation(JFrame currJFrame) {
        this.currJFrame = currJFrame;

        navToHomePage = e -> {
            HomePage homePage = new HomePage();
            homePage.setContentPane(homePage.getMainPanel());
            homePage.setVisible(true);
            homePage.setLocationRelativeTo(null);
            homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            currJFrame.dispose();
        };
    }

    public ActionListener getLoginActionListener(){
        return navToHomePage;
    }

}
