package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This ItemPage class is a JFrame that displays the attributes of a given item from a wishlist.
 */
public class ItemPage extends JFrame {
    private final GradientJPanel mainPanel;

    /**
     * mainPanel getter method.
     * @return mainPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * ItemPage constructor.
     */

    public ItemPage() {

        // JFrame setup
        super("Item name here");
        setLayout(null);
        setSize(360, 640);
        setResizable(false);

        // constants
        final Color color1 = new Color(194, 234, 186);
        final Color color2 = new Color(106, 189, 154);
        final Font textFont = new Font("Montserrat", Font.PLAIN, 14);
        final Font titleFont = new Font("Montserrat", Font.PLAIN, 20);

        // main panel
        mainPanel = new GradientJPanel(null, color1, color2);
        mainPanel.setBounds(0, 0, 360, 640);

        // header panel
        JPanel headerPanel = new JPanel(null);
        headerPanel.setBackground(color2);
        headerPanel.setBounds(0, 0, 360, 56);
        CustomJButton backButton = new CustomJButton("", 0, 0,
                color2, color2, textFont);
        backButton.setIcon(new ImageIcon("src/main/java/Assets/backArrow.png"));
        backButton.setBounds(15, 15, 25, 25);
        headerPanel.add(backButton);
        CustomJLabel thisItemLabel = new CustomJLabel("Get this item title", Color.WHITE, titleFont);
        thisItemLabel.setBounds(75, 17, 360, 24);
        headerPanel.add(thisItemLabel);
        CustomJButton graphButton = new CustomJButton("Details", 0, 0, color2, Color.WHITE, textFont);
        graphButton.setBounds(250, 13, 90, 30);
        headerPanel.add(graphButton);
        mainPanel.add(headerPanel);

        // image
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        Image image;
        Image resizedImage;
        try {
            URL url = new URL("https://www.gardeningknowhow.com/wp-content/uploads/2021/05/whole-and-slices-watermelon.jpg");
            image = ImageIO.read(url);
            resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        } catch (IOException e) {
            System.out.println("Image not found!");
        }
        imageLabel.setBounds(75, 76, 200, 200);
        mainPanel.add(imageLabel);

        // Item Information
        String currency = "USD";
        double itemPrice = 56.78;
        double reviewStars = 4.5;
        int reviewCount = 258;
        String itemDescription = "This product is bubly.\n Hello watermelon1 watermelon2 watermelon3. Herms " +
                "likes bubly in the following flavours: lime, orange, mango, everything else, grapefruit. " +
                "He was not joking.";
        double desiredPrice = 60;
        double itemPriceChange = 3.00;
        Date itemDateAdded = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String itemDateAddedFormatted = dateFormat.format(itemDateAdded);
        String url = "https://www.amazon.ca/gp/product/B0B2449PY2/ref=ppx_yo_dt_b_asin_title_o00_s00?ie=UTF8&th=1";
        String[] tags = {"a", "b", "f"};
        StringBuilder totalTag = new StringBuilder();
        for (String tag : tags) {
            totalTag.append(tag);
            totalTag.append(" ");
        }

        String html = "<html><body style='width: %1spx'>%1s";

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.setMaximumSize(new Dimension(200, 200));
        contentPanel.setBackground(color2);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollBar = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollBar.setBorder(null);
        scrollBar.setBounds(75, 300, 200, 200);

        // item price
        CustomJLabel itemPriceLabel = new CustomJLabel("Price: " + itemPrice + " " + currency, Color.WHITE, textFont);
        contentPanel.add(itemPriceLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // ratings
        CustomJLabel ratings = new CustomJLabel("Stars: " + reviewStars + " (" + reviewCount + ")", Color.WHITE, textFont);
        contentPanel.add(ratings);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // item description
        CustomJLabel description = new CustomJLabel(String.format(html, 130, "Description: " + itemDescription), Color.WHITE, textFont);
        contentPanel.add(description);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // desired price
        CustomJLabel desiredPriceLabel = new CustomJLabel("Desired Price: " + desiredPrice + " " + currency, Color.WHITE, textFont);
        contentPanel.add(desiredPriceLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // price chance
        CustomJLabel priceChange = new CustomJLabel("Price Change: " + itemPriceChange + " " + currency, Color.WHITE, textFont);
        contentPanel.add(priceChange);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // date added
        CustomJLabel dateAdded = new CustomJLabel("Date Added: " + itemDateAddedFormatted, Color.WHITE, textFont);
        contentPanel.add(dateAdded);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // tags
        CustomJLabel tagLabel = new CustomJLabel("Tags: " + totalTag, Color.WHITE, textFont);
        contentPanel.add(tagLabel);

        mainPanel.add(scrollBar);

        // url
        CustomJLabel urlLabel = new CustomJLabel("URL:", Color.WHITE, textFont);
        urlLabel.setBounds(160, 520, 100, 20);
        mainPanel.add(urlLabel);
        JTextField urlField = new JTextField("URL:\n" + url);
        urlField.setEditable(false);
        urlField.setBounds(75, 550, 200, 30);
        mainPanel.add(urlField);

        // Button Logic
        // Navigates back to WishlistPage.
        backButton.addActionListener(e -> {
            WishlistPage wlPage = new WishlistPage();
            wlPage.setContentPane(wlPage.getMainPanel());
            wlPage.setVisible(true);
            wlPage.setLocationRelativeTo(null);
            wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
        // Opens up graph page alongside current ItemPage.
        graphButton.addActionListener(e -> {
            System.out.println("TODO");
        });
    }
}
