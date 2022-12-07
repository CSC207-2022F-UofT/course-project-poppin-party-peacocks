package GUI;



import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import Entities.Wishlist;
import Entities.ListOfWishlists;
import DataBase.DataBaseController;
/**
 * A graphic user interface for the AddWishlistPage with the purpose of giving an opportunity to the user to customize
 * the name of their wishlist.
 */
public class AddWishlistPage extends JFrame {
    private final JPanel mainPanel;
    private final ListOfWishlists lwl;
    private final DataBaseController dbc;
    /**
     * getter method for mainPanel
     * @return mainPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public AddWishlistPage() throws FileNotFoundException, ParseException, org.json.simple.parser.ParseException {
        super("Add Wishlist");
        setLayout(null);
        setSize(360, 640);
        setResizable(false);

        dbc = new DataBaseController();
        lwl = dbc.getListOfWishlists(dbc.getCurrentUser().getName());

        Color color1 = new Color(194, 234, 186);
        Color color2 = new Color(106, 189, 154);
        Font headerFont = new Font("Arial", Font.PLAIN, 20);
        Font textFont = new Font("Arial", Font.PLAIN, 12);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBounds(0, 0, 400, 200);
        mainPanel.setBackground(color2);

        JPanel headerPanel = new JPanel(null);
        headerPanel.setBackground(color2);
        headerPanel.setPreferredSize(new Dimension(360, 56));

        CustomJLabel label = new CustomJLabel("Add Wishlist", Color.WHITE, headerFont);
        label.setBounds(125,-5, 391, 64);

        headerPanel.add(label);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JLabel nameLabel = new CustomJLabel("Name your wishlist:", Color.BLACK, headerFont);
        nameLabel.setBounds(95, 114, 185, 24);

        JLabel errorEmptyName = new CustomJLabel("The wishlist name cannot be empty", Color.BLACK, textFont);
        errorEmptyName.setBounds(32,190,200,40);

        JLabel errorWishlistExists = new CustomJLabel("A wishlist with this name already exists.",
                                                        Color.BLACK, textFont);
        errorWishlistExists.setBounds(32,190,300,40);

        JTextField nameField = new JTextField("", 20);
        nameField.setBounds(32, 160, 296, 40);
        nameField.setBorder(new RoundedBorder(5));

        GradientJPanel middlePanel = new GradientJPanel(null, color1, color2);
        middlePanel.add(nameLabel);
        middlePanel.add(nameField);

        CustomJButton cancelButton = new CustomJButton("Cancel", 0 , 0,
                Color.WHITE, Color.WHITE, headerFont);
        cancelButton.setBounds(187, 221, 119, 51);

        CustomJButton createButton = new CustomJButton("Add", 0 , 0,
                Color.WHITE, Color.WHITE, headerFont);
        createButton.setBounds(53, 221, 119, 51);

        middlePanel.add(cancelButton);
        middlePanel.add(createButton);

        mainPanel.add(middlePanel, BorderLayout.CENTER);

        createButton.addActionListener(e -> {
            String wishlistName;
            try{
                wishlistName = nameField.getText();
            }
            catch(NullPointerException n){
                wishlistName = "";
            }
            if (Objects.equals(wishlistName, "")){
                middlePanel.add(errorEmptyName);
                mainPanel.repaint();
            }
            else {
                ArrayList<String> nameOfWishlists = lwl.getWishlistNames();
                if (nameOfWishlists.contains(wishlistName)){
                    middlePanel.add(errorWishlistExists);
                    mainPanel.repaint();
                }else{
                    Wishlist wl = new Wishlist(wishlistName);
                    lwl.addWishlist(wl);
                    try {
                        dbc.saveListOfWishlists(lwl, dbc.getCurrentUser());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Wishlist newWl = new Wishlist(wishlistName);
                    WishlistPage wlPage;
                    try {
                        wlPage = new WishlistPage(newWl);
                    } catch (IOException | ParseException | org.json.simple.parser.ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    wlPage.setContentPane(wlPage.getMainPanel());
                    wlPage.setVisible(true);
                    wlPage.setLocationRelativeTo(null);
                    wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }
            }
        });
        cancelButton.addActionListener(e -> {
            HomePage listOfWL;
            try {
                listOfWL = new HomePage();
            } catch (FileNotFoundException | ParseException | org.json.simple.parser.ParseException ex) {
                throw new RuntimeException(ex);
            }
            listOfWL.setContentPane(listOfWL.getMainPanel());
            listOfWL.setVisible(true);
            listOfWL.setLocationRelativeTo(null);
            listOfWL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
    }
}
