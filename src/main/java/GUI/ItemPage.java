package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ItemPage extends JFrame {
    private final GradientJPanel mainPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public ItemPage() {
        super("Item name here");
        setLayout(null);
        setSize(360, 640);
        setResizable(false);

        final Color color1 = new Color(194, 234, 186);
        final Color color2 = new Color(106, 189, 154);
        final Font textFont = new Font("Montserrat", Font.PLAIN, 12);
        final Font titleFont = new Font("Sans Serif", Font.PLAIN, 20);

        mainPanel = new GradientJPanel(null, color1, color2);
        mainPanel.setBounds(0, 0, 360, 640);
        // header
        JPanel headerPanel = new JPanel(null);
        headerPanel.setBackground(color2);
        headerPanel.setBounds(0, 0, 360, 56);
        CustomJButton backButton = new CustomJButton("", 0, 0,
                color2, color2, textFont);
        backButton.setIcon(new ImageIcon("src/main/java/Assets/backArrow.png"));
        backButton.setBounds(15, 15, 25, 25);
        headerPanel.add(backButton);
        CustomJLabel thisItemLabel = new CustomJLabel("Get this item title", Color.WHITE, titleFont);
        thisItemLabel.setBounds(60, 17, 360, 24);
        headerPanel.add(thisItemLabel);
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

        // image
        imageLabel.setBounds(75, 76, 200, 200);
        mainPanel.add(imageLabel);
        // item price
        CustomJLabel itemPriceLabel = new CustomJLabel("Price: $12.34", Color.WHITE, textFont);
        itemPriceLabel.setBounds(75, 300, 300, 15);
        mainPanel.add(itemPriceLabel);
        // item description
        CustomJLabel description = new CustomJLabel("Description: ", Color.WHITE, textFont);
        description.setBounds(75, 330, 200, 15);
        mainPanel.add(description);
        // price chance
        CustomJLabel priceChange = new CustomJLabel("Price Change: ", Color.WHITE, textFont);
        priceChange.setBounds(75, 360, 300, 15);
        mainPanel.add(priceChange);
        // date added
        CustomJLabel dateAdded = new CustomJLabel("Date Added: ", Color.WHITE, textFont);
        dateAdded.setBounds(75, 390, 300, 15);
        mainPanel.add(dateAdded);
        // url
        CustomJLabel url = new CustomJLabel("URL: ", Color.WHITE, textFont);
        url.setBounds(75, 420, 300, 15);
        mainPanel.add(url);
        // tags
        String[] tags = {"a", "b", "c", "on sale"};
        CustomJLabel tagLabel = new CustomJLabel("", Color.WHITE, textFont);
        StringBuilder totalTag = new StringBuilder("Tags: ");
        for (String tag : tags) {
            totalTag.append(tag);
            totalTag.append(" ");
        }
        tagLabel.setText(totalTag.toString());
        tagLabel.setBounds(75, 450, 300, 15);
        mainPanel.add(tagLabel);

        // footer
        JPanel footerPanel = new JPanel(new FlowLayout());
        footerPanel.setBackground(color2);
        CustomJButton deleteThisItemButton = new CustomJButton("Delete this item", 0, 0,
                color2, Color.WHITE, textFont);
        footerPanel.setBounds(0, 530, 360, 100);
        footerPanel.add(deleteThisItemButton);
        // add footer to mainPanel
        mainPanel.add(footerPanel);

        deleteThisItemButton.addActionListener(e -> {
            // TODO
        });

        backButton.addActionListener(e -> {
            // TODO
            // Currently navigates to GUI.WishlistPage.
            WishlistPage wlPage = new WishlistPage();
            wlPage.setContentPane(wlPage.getMainPanel());
            wlPage.setVisible(true);
            wlPage.setLocationRelativeTo(null);
            wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
    }
}
