import GUI.WelcomePage;

import javax.swing.*;

public class main {

    public main() {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create and set up the window.
        WelcomePage initialJFrame = new WelcomePage();
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
