import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class MainApp extends JFrame{
    // placeholder buttons
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
    private JPanel rightPanelNORTH;
    private JLabel itemPriceLabel;
    private JPanel rightPanelCENTRE;
    private JLabel imageLabel;
    private JLabel description;
    private JLabel priceChange;
    private JLabel dateAdded;
    private JLabel url;
    private JPanel tagsColumnPanel;
    private JLabel tagLabel;
    private JPanel rightFooterPanel;
    private JButton deleteThisItemButton;


    public MainApp() {
        super("im a title123");
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
            // upper panel
        upperPanel = new JPanel();
        upperPanel.setBackground(Color.green);
        upperPanel.setBounds(0, 0, 400, 300);
        upperPanel.setLayout(new BorderLayout());
                // app name
        welcomeLabel = new JLabel("Party Peacocks");
        welcomeLabel.setIcon(new ImageIcon("sus.png"));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(font);
        upperPanel.add(welcomeLabel, BorderLayout.CENTER);
                // username label
        usernameLabel = new JLabel("Hello Barry");
        usernameLabel.setHorizontalAlignment(JLabel.CENTER);
        upperPanel.add(usernameLabel, BorderLayout.NORTH);
            // lower panel
        lowerPanel = new JPanel();
        lowerPanel.setBackground(Color.orange);
        lowerPanel.setBounds(0, 300, 400, 300);
        lowerPanel.setLayout(new BorderLayout(20, 20));
                // wishlists label
        listOfWishlistsLabel = new JLabel("Your Wishlists");
        listOfWishlistsLabel.setHorizontalAlignment(JLabel.CENTER);
        lowerPanel.add(listOfWishlistsLabel, BorderLayout.NORTH);
                // footer
        leftFooterPanel = new JPanel();
        leftFooterPanel.setBackground(Color.MAGENTA);
        leftFooterPanel.setLayout(new FlowLayout());
        addWishlistButton = new JButton("Add Entities.Wishlist");
        leftFooterPanel.add(addWishlistButton);
        lowerPanel.add(leftFooterPanel, BorderLayout.SOUTH);
                // right and left padding
        leftWestLabel = new JLabel("");
        lowerPanel.add(leftWestLabel, BorderLayout.WEST);
        leftEastLabel = new JLabel("");
        lowerPanel.add(leftEastLabel, BorderLayout.EAST);
                // list of wishlists
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
        // assemble panels
        leftPanel.add(upperPanel);
        leftPanel.add(lowerPanel);

        // ---------- MIDDLE PANEL ----------
        middlePanel = new JPanel(new BorderLayout(20, 20));
        middlePanel.setBackground(color);
        middlePanel.setBounds(400, 0, 400, 600);
            // top label (wishlist name)
        thisWishlistLabel = new JLabel("Get this wishlist title" );
        thisWishlistLabel.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(thisWishlistLabel, BorderLayout.NORTH);
            // items
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
            // list padding
        middleWestLabel = new JLabel("");
        middlePanel.add(middleWestLabel, BorderLayout.WEST);
        middleEastLabel = new JLabel("");
        middlePanel.add(middleEastLabel, BorderLayout.EAST);
            // footer
        middleFooterPanel = new JPanel(new FlowLayout());
        middleFooterPanel.setBackground(Color.DARK_GRAY);
                // footer buttons
        deleteThisWishlistButton = new JButton("Delete this Entities.Wishlist");
        middleFooterPanel.add(deleteThisWishlistButton);
        addItemButton = new JButton("Add Entities.Item");
        middleFooterPanel.add(addItemButton);
            // add footer to middlePanel
        middlePanel.add(middleFooterPanel, BorderLayout.SOUTH);

        // ---------- RIGHT PANEL ----------
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.blue);
        rightPanel.setBounds(800, 0, 400, 600);
            // header
        rightPanelNORTH = new JPanel(new FlowLayout());
        rightPanelNORTH.setBackground(Color.darkGray);
        thisItemLabel = new JLabel("Get this item title");
        rightPanelNORTH.add(thisItemLabel);
        itemPriceLabel = new JLabel("$12.34");
        rightPanelNORTH.add(itemPriceLabel);
        rightPanel.add(rightPanelNORTH, BorderLayout.NORTH);
            // centre
        rightPanelCENTRE = new JPanel(new GridLayout(0, 1));
        rightPanelCENTRE.setBackground(Color.GRAY);
                // image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        Image image = null;
        Image resizedImage = null;
        try {
            URL url = new URL("https://www.gardeningknowhow.com/wp-content/uploads/2021/05/whole-and-slices-watermelon.jpg");
            image = ImageIO.read(url);
            resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        }
        catch (IOException e) {
            System.out.println("Image not found!");
        }
        rightPanelCENTRE.add(imageLabel);
                // item description
        description = new JLabel("This is an item description.");
        rightPanelCENTRE.add(description);
                // price chance
        priceChange = new JLabel("Price change:");
        rightPanelCENTRE.add(priceChange);
                // date added
        dateAdded = new JLabel("Date Added:");
        rightPanelCENTRE.add(dateAdded);
                // url
        url = new JLabel("INSERT URL HERE");
        rightPanelCENTRE.add(url);

        rightPanel.add(rightPanelCENTRE, BorderLayout.CENTER);
            // WEST side for tags
        tagsColumnPanel = new JPanel();
        tagsColumnPanel.setLayout(new BoxLayout(tagsColumnPanel, BoxLayout.Y_AXIS));
        tagsColumnPanel.setBackground(Color.red);
        String[] tags = {"a", "b", "c", "fjdksal;"};    // dummy tags
        for (String tag: tags) {
            tagLabel = new JLabel(tag);
            tagsColumnPanel.add(tagLabel);
        }
        rightPanel.add(tagsColumnPanel, BorderLayout.WEST);
            // footer
        rightFooterPanel = new JPanel(new FlowLayout());
        rightFooterPanel.setBackground(Color.YELLOW);
        deleteThisItemButton = new JButton("Delete this item");
        rightFooterPanel.add(deleteThisItemButton);
            // add footer to rightPanel
        rightPanel.add(rightFooterPanel, BorderLayout.SOUTH);


        // ---------- LOGIC ----------
        // Left Panel
        addWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        // Middle Panel
        deleteThisWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                // Change middlePanel top label
//                thisWishlistLabel.setText("Choose a Entities.Wishlist");
//                // Reset itemPanel
//                middlePanel.remove(itemPanel);
//                itemPanel = new JPanel();
//                itemPanel.setBackground(Color.PINK);
//                itemPanel.setLayout(new GridLayout(0, 1));
//                middlePanel.add(itemPanel, BorderLayout.CENTER);
//                middlePanel.revalidate();
//                middlePanel.repaint();
                // TODO
            }
        });
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        // Right Panel
        deleteThisItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });

        // Adding major panels to JFrame
        add(leftPanel);
        add(middlePanel);
        add(rightPanel);
    }

}
