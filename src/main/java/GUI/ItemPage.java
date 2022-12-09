package GUI;

import Entities.Product;
import Entities.ProductList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.parser.ParseException;

/**
 * This ItemPage class is a JFrame that displays the attributes of a given item from a wishlist.
 */
public class ItemPage extends JFrame {
    // main panel
    private final GradientJPanel mainPanel;
    // item to be shown
    private final Product item;

    /**
     * mainPanel getter method.
     * @return mainPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * ItemPage constructor.
     * @param item item to display in this page.
     * @param wl that the item belongs to in order to return.
     */
    public ItemPage(Product item, ProductList wl) {

        // JFrame setup
        super(item.getProductName());
        setLayout(null);
        setSize(360, 640);
        setResizable(false);

        this.item = item;

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
        String productName = item.getProductName();
        if (productName.length() > 24){
            productName = productName.substring(0,23) + "...";
        }
        CustomJLabel thisItemLabel = new CustomJLabel(productName, Color.WHITE, titleFont);
        thisItemLabel.setBounds(75, 17, 250, 24);
        headerPanel.add(thisItemLabel);

        CustomJButton graphButton = new CustomJButton("Details", 0, 0, color2, Color.WHITE, textFont);
        graphButton.setBounds(130, 565, 90, 30);

        mainPanel.add(graphButton);
        mainPanel.add(headerPanel);

        // image
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        Image image;
        Image resizedImage;
        try {
            URL url = new URL(item.getProductImageURL());
            image = ImageIO.read(url);
            resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        } catch (IOException e) {
            try{
                URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png");
                image = ImageIO.read(url);
                resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(resizedImage));
            }
            catch (IOException e1){
                e1.printStackTrace();
            }
        }
        imageLabel.setBounds(75, 76, 200, 200);
        mainPanel.add(imageLabel);

        // Item Information
        String currency = item.getProductCurrency();
        String itemPrice = item.getProductPriceString();
        double reviewStars = item.getReviewStars();
        int reviewCount = item.getReviewCount();
        String itemDescription = item.getProductDescription();
        double desiredPrice = item.getProductDesiredPrice();
        double itemPriceChange = item.getPriceChange();
        Date itemDateAdded = item.getProductDateAdded();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String itemDateAddedFormatted = dateFormat.format(itemDateAdded);
        String url = item.getProductURL();

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
        scrollBar.getVerticalScrollBar().setUnitIncrement(20);
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
        // price change
        CustomJLabel priceChange = new CustomJLabel("Price Change: " + itemPriceChange + " " + currency, Color.WHITE, textFont);
        contentPanel.add(priceChange);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // date added
        CustomJLabel dateAdded = new CustomJLabel("Date Added: " + itemDateAddedFormatted, Color.WHITE, textFont);
        contentPanel.add(dateAdded);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // desired price
        CustomJLabel desiredPriceLabel = new CustomJLabel("Desired Price: " + desiredPrice + " " + currency, Color.WHITE, textFont);
        contentPanel.add(desiredPriceLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField desiredPriceInput = new JTextField("", 5);
        desiredPriceInput.setForeground(Color.black);
        JButton desiredPriceButton = new JButton("Set Desired Price");

        contentPanel.add(desiredPriceInput);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPanel.add(desiredPriceButton);

        mainPanel.add(scrollBar);

        // url
        CustomJLabel urlLabel = new CustomJLabel("URL:", Color.WHITE, textFont);
        urlLabel.setBounds(160, 510, 100, 20);
        mainPanel.add(urlLabel);
        JTextField urlField = new JTextField("URL:\n" + url);
        urlField.setEditable(false);
        urlField.setBounds(75, 530, 200, 30);
        mainPanel.add(urlField);

        // Button Logic
        // Navigates back to WishlistPage.
        backButton.addActionListener(e -> {
            WishlistPage wlPage;
            try {
                wlPage = new WishlistPage(wl);
            } catch (IOException | ParseException | java.text.ParseException ex) {
                throw new RuntimeException(ex);
            }
            wlPage.setContentPane(wlPage.getMainPanel());
            wlPage.setVisible(true);
            wlPage.setLocationRelativeTo(null);
            wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
        // Opens up graph page alongside current ItemPage.
        graphButton.addActionListener(e -> {

            PriceHistoryPage priceHistoryPage = new PriceHistoryPage(item, wl);
            priceHistoryPage.setContentPane(priceHistoryPage.getMainPanel());
            priceHistoryPage.setVisible(true);
            priceHistoryPage.setLocationRelativeTo(null);

            priceHistoryPage.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.dispose();
        });
        // Button logic for desired price change.
        desiredPriceButton.addActionListener(e -> {
            String priceText = desiredPriceInput.getText();
            double updatedDesiredPrice = Double.parseDouble(priceText);
            this.item.setDesiredPrice(updatedDesiredPrice);
        });
    }
}
