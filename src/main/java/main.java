import GUI.WelcomePage;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("E MMM dd HH:mm:ss yyyy").format(new Date()));
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
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
    }
}
