package Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePageActionListenerNavigation {
    private JFrame currJFrame;
    private ActionListener navToHomePage;
    UserRegisterController controller;

    public WelcomePageActionListenerNavigation(JFrame currJFrame) {
        this.currJFrame = currJFrame;

        navToHomePage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.HomePage homePage = new GUI.HomePage(controller);
                homePage.setContentPane(homePage.getMainPanel());
                homePage.setVisible(true);
                homePage.setLocationRelativeTo(null);
                homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                currJFrame.dispose();
            }
        };
    }

    public ActionListener getLoginActionListener(){
        return navToHomePage;
    }

}
