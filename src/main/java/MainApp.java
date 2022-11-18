import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame{
    private JButton dummy1;
    private JButton dummy2;
    private JButton dummy3;
    private JButton dummy4;
    private JButton dummy5;
    private JButton dummy6;

    // Left Panel
    private JPanel leftPanel;
    private JPanel upperPanel;
    private JLabel welcomeLabel;
    private JLabel usernameLabel;
    private JPanel lowerPanel;
    private JLabel listOfWishlistsLabel;
    private JPanel wishlistPanel;
    private JPanel leftFooterPanel;
    private JButton addWishlistButton;
    private JLabel leftWestLabel;
    private JLabel leftEastLabel;

    // Middle Panel
    private JPanel middlePanel;
    private JLabel thisWishlistLabel;
    private JPanel itemPanel;
    private JLabel middleWestLabel;
    private JLabel middleEastLabel;
    private JPanel middleFooterPanel;
    private JButton deleteThisWishlistButton;
    private JButton addItemButton;

    // Right Panel
    private JPanel rightPanel;
    private JLabel thisItemLabel;
    private JPanel rightFooterPanel;
    private JButton deleteThisItemButton;

    public MainApp() {
        super("im a title123");

        // layout
//        FlowLayout layout = new FlowLayout();
//        setLayout(layout);

        //below idk which one
        //this.setLayout(null); ?
        setLayout(null);
        setSize(1200, 638);
        //setResizable(false);


        // ---------- CONSTANTS ----------
        Color color = new Color(150, 75, 130);
        Font font = new Font("Montserrat", Font.PLAIN, 24);

        // ---------- LEFT PANEL ----------
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.red);
        leftPanel.setBounds(0, 0, 400, 638);
        leftPanel.setLayout(null);

        upperPanel = new JPanel();
        upperPanel.setBackground(Color.green);
        upperPanel.setBounds(0, 0, 400, 300);
        upperPanel.setLayout(new BorderLayout());

        welcomeLabel = new JLabel("Party Peacocks");
        welcomeLabel.setIcon(new ImageIcon("sus.png"));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(font);
        upperPanel.add(welcomeLabel, BorderLayout.CENTER);

        usernameLabel = new JLabel("Hello Barry");
        usernameLabel.setHorizontalAlignment(JLabel.CENTER);
        upperPanel.add(usernameLabel, BorderLayout.NORTH);

        lowerPanel = new JPanel();
        lowerPanel.setBackground(Color.orange);
        lowerPanel.setBounds(0, 300, 400, 300);
        lowerPanel.setLayout(new BorderLayout(20, 20));

        listOfWishlistsLabel = new JLabel("Your Wishlists");
        listOfWishlistsLabel.setHorizontalAlignment(JLabel.CENTER);
        lowerPanel.add(listOfWishlistsLabel, BorderLayout.NORTH);

        leftFooterPanel = new JPanel();
        leftFooterPanel.setBackground(Color.MAGENTA);
        leftFooterPanel.setLayout(new FlowLayout());

        addWishlistButton = new JButton("Add Wishlist");
        leftFooterPanel.add(addWishlistButton);

        lowerPanel.add(leftFooterPanel, BorderLayout.SOUTH);

        leftWestLabel = new JLabel("");
        lowerPanel.add(leftWestLabel, BorderLayout.WEST);
        leftEastLabel = new JLabel("");
        lowerPanel.add(leftEastLabel, BorderLayout.EAST);

        wishlistPanel = new JPanel();
        wishlistPanel.setBackground(Color.CYAN);
        wishlistPanel.setLayout(new GridLayout(0, 2));
        dummy1 = new JButton("d1");
        dummy2 = new JButton("d2");
        dummy3 = new JButton("d3");
        wishlistPanel.add(dummy1);
        wishlistPanel.add(dummy2);
        wishlistPanel.add(dummy3);
        lowerPanel.add(wishlistPanel, BorderLayout.CENTER);

        leftPanel.add(upperPanel);
        leftPanel.add(lowerPanel);

        // ---------- MIDDLE PANEL ----------
        middlePanel = new JPanel();
        middlePanel.setBackground(color);
        middlePanel.setBounds(400, 0, 400, 600);
        middlePanel.setLayout(new BorderLayout(20, 20));

        thisWishlistLabel = new JLabel("Get this wishlist title" );
        thisWishlistLabel.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(thisWishlistLabel, BorderLayout.NORTH);

        itemPanel = new JPanel();
        itemPanel.setBackground(Color.PINK);
        itemPanel.setLayout(new GridLayout(0, 1));
        dummy4 = new JButton("d4");
        dummy5 = new JButton("d5");
        dummy6 = new JButton("d6");
        itemPanel.add(dummy4);
        itemPanel.add(dummy5);
        itemPanel.add(dummy6);
        middlePanel.add(itemPanel, BorderLayout.CENTER);

        middleWestLabel = new JLabel("");
        middlePanel.add(middleWestLabel, BorderLayout.WEST);
        middleEastLabel = new JLabel("");
        middlePanel.add(middleEastLabel, BorderLayout.EAST);

        middleFooterPanel = new JPanel();
        middleFooterPanel.setBackground(Color.DARK_GRAY);
        middleFooterPanel.setLayout(new FlowLayout());

        deleteThisWishlistButton = new JButton("Delete this Wishlist");
        middleFooterPanel.add(deleteThisWishlistButton);

        addItemButton = new JButton("Add Item");
        middleFooterPanel.add(addItemButton);

        middlePanel.add(middleFooterPanel, BorderLayout.SOUTH);

        // ---------- RIGHT PANEL ----------
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.blue);
        rightPanel.setBounds(800, 0, 400, 600);
        rightPanel.setLayout(new BorderLayout());

        thisItemLabel = new JLabel("Get this item title");
        thisItemLabel.setHorizontalAlignment(JLabel.CENTER);
        rightPanel.add(thisItemLabel, BorderLayout.NORTH);

        rightFooterPanel = new JPanel();
        rightFooterPanel.setBackground(Color.YELLOW);
        rightFooterPanel.setLayout(new FlowLayout());

        deleteThisItemButton = new JButton("Delete this item");
        rightFooterPanel.add(deleteThisItemButton);

        rightPanel.add(rightFooterPanel, BorderLayout.SOUTH);


        // ---------- LOGIC ----------
        // Left Panel
        addWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        // Middle Panel
        deleteThisWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change middlePanel top label
                thisWishlistLabel.setText("Choose a Wishlist");
                // Reset itemPanel
                middlePanel.remove(itemPanel);
                itemPanel = new JPanel();
                itemPanel.setBackground(Color.PINK);
                itemPanel.setLayout(new GridLayout(0, 1));
                middlePanel.add(itemPanel, BorderLayout.CENTER);
                middlePanel.revalidate();
                middlePanel.repaint();
            }
        });
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        // Right Panel
        deleteThisItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change rightPanel top label
                thisItemLabel.setText("Choose an item");
                // Reset item TODO
            }
        });


        // Adding major panels to JFrame
        add(leftPanel);
        add(middlePanel);
        add(rightPanel);
    }

}
