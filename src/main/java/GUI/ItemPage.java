package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class ItemPage extends JFrame {
    private final JPanel rightPanel;

    public JPanel getMainPanel() {
        return rightPanel;
    }

    public ItemPage() {
        super("Item name here");
        setLayout(null);
        setSize(400, 638);
        setResizable(false);

        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.blue);
        rightPanel.setBounds(800, 0, 400, 600);
        // header
        JPanel rightPanelNORTH = new JPanel(new FlowLayout());
        rightPanelNORTH.setBackground(Color.darkGray);
        JLabel thisItemLabel = new JLabel("Get this item title");
        rightPanelNORTH.add(thisItemLabel);
        JLabel itemPriceLabel = new JLabel("$12.34");
        rightPanelNORTH.add(itemPriceLabel);
        rightPanel.add(rightPanelNORTH, BorderLayout.NORTH);
        // centre
        JPanel rightPanelCENTRE = new JPanel(new GridLayout(0, 1));
        rightPanelCENTRE.setBackground(Color.GRAY);
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
        rightPanelCENTRE.add(imageLabel);
        // item description
        String itemDescriptionVar = "Item description here.";
        JLabel description = new JLabel(itemDescriptionVar);
        rightPanelCENTRE.add(description);
        // price chance
        String priceChangeStr = "Price change here.";
        JLabel priceChange = new JLabel(priceChangeStr);
        rightPanelCENTRE.add(priceChange);
        // date added
        String dateAddedVar = "Date added here.";
        JLabel dateAdded = new JLabel(dateAddedVar);
        rightPanelCENTRE.add(dateAdded);
        // url
        String urlVar = "url here.";
        JLabel url1 = new JLabel(urlVar);
        rightPanelCENTRE.add(url1);

        rightPanel.add(rightPanelCENTRE, BorderLayout.CENTER);
        // WEST side for tags
        JPanel tagsColumnPanel = new JPanel();
        tagsColumnPanel.setLayout(new BoxLayout(tagsColumnPanel, BoxLayout.Y_AXIS));
        tagsColumnPanel.setBackground(Color.red);
        String[] tags = {"a", "b", "c", "fjdksal;"};    // dummy tags
        for (String tag : tags) {
            JLabel tagLabel = new JLabel(tag);
            tagsColumnPanel.add(tagLabel);
        }
        rightPanel.add(tagsColumnPanel, BorderLayout.WEST);
        // footer
        JPanel rightFooterPanel = new JPanel(new FlowLayout());
        rightFooterPanel.setBackground(Color.YELLOW);
        JButton backButton = new JButton("Back to Wishlist");
        rightFooterPanel.add(backButton);
        JButton deleteThisItemButton = new JButton("Delete this item");
        rightFooterPanel.add(deleteThisItemButton);
        // add footer to rightPanel
        rightPanel.add(rightFooterPanel, BorderLayout.SOUTH);

        deleteThisItemButton.addActionListener(e -> {
            // TODO
        });

        backButton.addActionListener(e -> {
            // TODO
            // Currently navigates to GUI.WishlistPage.
            WishlistPage wlPage = new WishlistPage( );
            wlPage.setContentPane(wlPage.getMainPanel());
            wlPage.setVisible(true);
            wlPage.setLocationRelativeTo(null);
            wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
    }
}
