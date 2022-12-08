import Controller.UserRegisterController;
import DataBase.DataBaseFormatter;
import GUI.WelcomePage;
import UseCases.UserRegister.*;

import javax.swing.*;
public class main {
    /**
     * main
     */

    public static void main(String[] args) {

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(main::createAndShowGUI);
    }

    /**
     * Start GUI when program runs.
     */
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

        // Icon
        ImageIcon icon = new ImageIcon("src/main/java/Assets/logo.png");
        initialJFrame.setIconImage(icon.getImage());
    }
}
