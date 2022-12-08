import Controller.UserRegisterController;
import DataBase.DataBaseController;
import Entities.ListOfProductLists;
import Entities.ListOfWishlists;
import Entities.User;
import Entities.Wishlist;
import GUI.WelcomePage;
import UseCases.UserRegister.*;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class main {
    /**
     * main
     */

    public main(String[] args) throws ParseException, IOException, org.json.simple.parser.ParseException {
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
