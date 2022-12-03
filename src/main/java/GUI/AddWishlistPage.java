package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * A graphic user interface for the AddWishlistPage with the purpose of giving an opportunity to the user to customize
 * the name of their wishlist.
 */
public class AddWishlistPage extends JFrame {
    private final JPanel mainPanel;

    /**
     * getter method for mainPanel
     * @return mainPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public AddWishlistPage() {
        super("Add Wishlist");
        setLayout(null);
        setSize(360, 640);
        setResizable(false);

        // constants
        Color color1 = new Color(194, 234, 186);
        Color color2 = new Color(106, 189, 154);
        Font headerFont = new Font("Arial", Font.PLAIN, 20);

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBounds(0, 0, 400, 200);
        mainPanel.setBackground(color2);

        // header panel
        JPanel headerPanel = new JPanel(null);
        headerPanel.setBackground(color2);
        headerPanel.setPreferredSize(new Dimension(360, 56));

        // top label
        CustomJLabel label = new CustomJLabel("Add Wishlist", Color.WHITE, headerFont);
        label.setBounds(125,-5, 391, 64);

        headerPanel.add(label);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        //text field
        JLabel nameLabel = new CustomJLabel("Name your wishlist:", Color.BLACK, headerFont);
        nameLabel.setBounds(95, 114, 185, 24);

        JTextField nameField = new JTextField("", 20);
        nameField.setBounds(32, 160, 296, 40);
        nameField.setBorder(new RoundedBorder(5));

        // middle panel
        GradientJPanel middlePanel = new GradientJPanel(null, color1, color2);
        middlePanel.add(nameLabel);
        middlePanel.add(nameField);

        // buttons
        CustomJButton cancelButton = new CustomJButton("Cancel", 0 , 0,
                Color.WHITE, Color.WHITE, headerFont);
        cancelButton.setBorder(new RoundedBorder(20));
        cancelButton.setBounds(187, 221, 119, 51);

        CustomJButton createButton = new CustomJButton("Add", 0 , 0,
                Color.WHITE, Color.WHITE, headerFont);
        createButton.setBorder(new RoundedBorder(20));
        createButton.setBounds(53, 221, 119, 51);

        middlePanel.add(cancelButton);
        middlePanel.add(createButton);

        // inception
        mainPanel.add(middlePanel, BorderLayout.CENTER);

        createButton.addActionListener(e -> {
            // Currently navigates to GUI.WishlistPage
            WishlistPage wlPage = new WishlistPage();
            wlPage.setContentPane(wlPage.getMainPanel());
            wlPage.setVisible(true);
            wlPage.setLocationRelativeTo(null);
            wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
        cancelButton.addActionListener(e -> {
            // Returns to GUI.HomePage()
            HomePage listOfWL = new HomePage();
            listOfWL.setContentPane(listOfWL.getMainPanel());
            listOfWL.setVisible(true);
            listOfWL.setLocationRelativeTo(null);
            listOfWL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
    }
}
