import DataBase.DataBase;
import Entities.*;
import javax.swing.*;

public class main {

    public static void main(String[] args) {

//        Item keyboard = new Item("Keyboard", 300.1, 250.0, "www.amazon.com/keyboard",
//                "Description from amazon (or you write your own)", new String[] {"computer accesssories", "Tech", "Mechanical"},
//                40, 4.0,"image.com");
//        Item monitor = new Item("Monitor", 120.99, 85.00, "www.amazon.com/monitor",
//                "second monitor dab", new String[] {"computer accesssories", "Tech", "IPS"},
//                40, 4.0,"image.com");
//        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
//                "Description from amazon (or you write your own)", new String[] {"toys"},
//                40, 4.0,"image.com");
//
//        Wishlist christmasWishlist = new Wishlist("Christmas Entities.Wishlist");
//
//
//        System.out.println(christmasWishlist.addItem(keyboard));
//        System.out.println(christmasWishlist.addItem(monitor));
//        System.out.println(christmasWishlist.addItem(plushie));
//        christmasWishlist.displayList();
//        christmasWishlist.filterWishlists(new String[] {"Tech"});
//        christmasWishlist.displayList();

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        User temp = new User("Hello", "test");
        DataBase.deleteUser("Hello");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Create and set up the window.
        MainAppLoginSignupPage initialJFrame = new MainAppLoginSignupPage();
        initialJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        initialJFrame.setContentPane(initialJFrame.getMainPanel());
        initialJFrame.setVisible(true);

        // Display in the centre of the screen.
        initialJFrame.setLocationRelativeTo(null);
    }
}
