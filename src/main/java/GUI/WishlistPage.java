package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WishlistPage extends JFrame {
    private JPanel middlePanel;
    private JPanel northPanel;
    private JLabel thisWishlistLabel;
    private JButton backButton;
    private JPanel itemPanel;
    private JLabel middleWestLabel;
    private JLabel middleEastLabel;
    private JPanel middleFooterPanel;
    private JButton deleteThisWishlistButton;
    private JButton addItemButton;

    private JButton dummy4;
    private JButton dummy5;
    private JButton dummy6;

    public JPanel getMainPanel() {
        return middlePanel;
    }

    public WishlistPage() {
        super("Wishlist name here");
        setLayout(null);
        setSize(400, 638);
        setResizable(false);


        // constants
        Color color = new Color(150, 75, 130);
        Color color1 = new Color(194, 234, 186);
        Color color2 = new Color(106, 189, 154);
        Font font1 = new Font("Montserrat", Font.PLAIN, 12);

        middlePanel = new JPanel(new BorderLayout(20, 20));
        middlePanel.setBackground(color1);
        middlePanel.setBounds(400, 0, 400, 600);
        // top label (wishlist name)
        northPanel = new JPanel(new FlowLayout());
        backButton = new JButton("Back to List of Wishlists");
        northPanel.add(backButton);
        thisWishlistLabel = new JLabel("Get this wishlist title");
        thisWishlistLabel.setForeground(Color.white);

        thisWishlistLabel.setHorizontalAlignment(JLabel.CENTER);
        northPanel.add(thisWishlistLabel);
        northPanel.setBackground(color2);
        middlePanel.add(northPanel, BorderLayout.NORTH);
        // items
        itemPanel = new JPanel();
        itemPanel.setBackground(color2);
        itemPanel.setLayout(new GridLayout(0, 1));
        dummy4 = new JButton("d4");
        dummy5 = new JButton("d5");
        dummy6 = new JButton("d6");
        itemPanel.add(dummy4);
        itemPanel.add(dummy5);
        itemPanel.add(dummy6);
        middlePanel.add(itemPanel, BorderLayout.CENTER);
        // list padding
        middleWestLabel = new JLabel("");
        middlePanel.add(middleWestLabel, BorderLayout.WEST);
        middleEastLabel = new JLabel("");
        middlePanel.add(middleEastLabel, BorderLayout.EAST);
        // footer
        middleFooterPanel = new JPanel(new FlowLayout());
        middleFooterPanel.setBackground(color2);

        deleteThisWishlistButton = new CustomJButton("Delete this Wishlist", 0, 0, color2, Color.white, font1);
        middleFooterPanel.add(deleteThisWishlistButton);

        addItemButton = new CustomJButton("Add Item", 0, 0, color2, Color.white, font1);
        middleFooterPanel.add(addItemButton);

        // add footer to middlePanel
        middlePanel.add(middleFooterPanel, BorderLayout.SOUTH);

        deleteThisWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddItemPage addItemPage = new AddItemPage();
                addItemPage.setContentPane(addItemPage.getMainPanel());
                addItemPage.setVisible(true);
                addItemPage.setLocationRelativeTo(null);
                addItemPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                // Currently navigates to GUI.ListOfWishlistsPage.
                HomePage listOfWlPage = new HomePage();
                listOfWlPage.setContentPane(listOfWlPage.getMainPanel());
                listOfWlPage.setVisible(true);
                listOfWlPage.setLocationRelativeTo(null);
                listOfWlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }
}
