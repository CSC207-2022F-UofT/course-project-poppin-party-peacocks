import Controller.UserRegisterController;
import DataBase.DataBase;
import Entities.*;
import GUI.WelcomePage;
import GUI.WelcomePage;
import UseCases.UserRegister.*;

import javax.swing.*;

public class main {

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        UserRegisterStatus presenter = new UserRegisterResponseFormatter();
        UserRegisterCreateUser interactor = new UserRegister(presenter);
        UserRegisterController userRegisterController = new UserRegisterController(
                interactor
        );

        // Create and set up the window.
        WelcomePage initialJFrame = new WelcomePage(userRegisterController);
        initialJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        initialJFrame.setContentPane(initialJFrame.getMainPanel());
        initialJFrame.setVisible(true);

        // Display in the centre of the screen.
        initialJFrame.setLocationRelativeTo(null);
    }
}
