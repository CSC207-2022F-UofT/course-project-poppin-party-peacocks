import Controller.UserRegisterController;
import GUI.WelcomePage;
import UseCases.UserRegister.*;

import javax.swing.*;
public class mainApp {
    /**
     * main
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(mainApp::createAndShowGUI);
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
        WelcomePage initialJFrame = new WelcomePage(userRegisterController);
        initialJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initialJFrame.setContentPane(initialJFrame.getMainPanel());
        initialJFrame.setVisible(true);

        initialJFrame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("src/main/java/Assets/logo.png");
        initialJFrame.setIconImage(icon.getImage());
    }
}