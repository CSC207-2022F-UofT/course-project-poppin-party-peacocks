package GUI;

import Entities.Product;
import Entities.ProductList;
import ExternalInterface.ItemSearcher;
import UseCases.Notification.PriceDropNotification;
import UseCases.Notification.SaleNotification;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

/**
 *  This AddItemPage class is a JFrame that allows the user to search for a new item to add to the current wishlist.
 */
public class AddItemPage extends JFrame {
    private final JPanel mainPanel;
    private final JTextField searchBar;
    private JPanel contentPanel;
    private JList<JPanel> itemJList;
    private final ProductList currWishlist;
    private Product[] itemList;

    /**
     * AddItemPage constructor.
     * @param wishlist the wishlist to add the item to.
     */
    public AddItemPage(ProductList wishlist) {
        super("Add Item");
        setLayout(null);
        setSize(360, 640);
        setResizable(false);

        this.currWishlist = wishlist;
        // constants
        Color color1 = new Color(194, 234, 186);
        Color color2 = new Color(106, 189, 154);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBounds(0, 0, 400, 600);
        // header
        JPanel headerPanel = new JPanel(new FlowLayout());
        headerPanel.setBackground(color2);
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setForeground(Color.white);
        searchBar = new JTextField("", 15);
        JButton searchButton = new JButton("Go");
        headerPanel.add(searchLabel);
        headerPanel.add(searchBar);
        headerPanel.add(searchButton);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.setBackground(color1);

        // centre
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JPanel[] array = new JPanel[10];
        itemJList = new JList<>(array);
        itemJList.setCellRenderer(new PanelRenderer());
        itemJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contentPanel.add(new JScrollPane(itemJList));
        // Note: adding centre panel to main panel is done in renderCentre().

        // footer
        JButton cancelButton = new JButton("Cancel");
        JPanel footerPanel = new JPanel(new FlowLayout());
        JButton addSelectedItemButton = new JButton("Add Selected Item");

        footerPanel.add(cancelButton);
        footerPanel.add(addSelectedItemButton);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(e -> {
            try {
                BorderLayout layout = (BorderLayout) mainPanel.getLayout();
                if(layout.getLayoutComponent(BorderLayout.CENTER) != null){
                    mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                }
                contentPanel = new JPanel();
                contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
                JPanel[] array1 = new JPanel[10];
                String keyword = searchBar.getText();
                ItemSearcher itemSearcher = new ItemSearcher();
                itemList = new Product[1];
                if (keyword.contains("amazon.")){
                    itemList[0] = itemSearcher.searchItemUrl(keyword, false);
                    array1 = new JPanel[1];
                }
                else{
                    itemList = itemSearcher.searchItemKeywords(keyword).toArray(itemList);
                }

                for (int i = 0; i < itemList.length; i++) {
                    array1[i] = createPanel(itemList[i], i + 1);
                }
                itemJList = new JList<>(array1);
                itemJList.setCellRenderer(new PanelRenderer());
                itemJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                contentPanel.add(new JScrollPane(itemJList));
                renderCentre();
            } catch (NullPointerException error) {
                error.printStackTrace();
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            mainPanel.repaint();
            mainPanel.revalidate();
        });

        cancelButton.addActionListener(e -> {
            WishlistPage wlPage;
            try {
                wlPage = new WishlistPage(currWishlist);
            } catch (IOException | ParseException | org.json.simple.parser.ParseException ex) {
                throw new RuntimeException(ex);
            }
            wlPage.setContentPane(wlPage.getMainPanel());
            wlPage.setVisible(true);
            wlPage.setLocationRelativeTo(null);
            wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });

        addSelectedItemButton.addActionListener(e -> {
            if (itemJList.getSelectedIndex() >= 0){
                Product selectedItem = itemList[itemJList.getSelectedIndex()];

                // Create notification timers
                SaleNotification saleNotification = new SaleNotification(selectedItem);
                PriceDropNotification priceDropNotification = new PriceDropNotification(selectedItem);
                saleNotification.startNotificationListener();
                priceDropNotification.startNotificationListener();
                currWishlist.addProduct(itemList[itemJList.getSelectedIndex()]);
                WishlistPage updatedWishlistPage;
                try {
                    updatedWishlistPage = new WishlistPage(currWishlist);
                } catch (IOException | ParseException | org.json.simple.parser.ParseException ex) {
                    throw new RuntimeException(ex);
                }
                updatedWishlistPage.setContentPane(updatedWishlistPage.getMainPanel());
                updatedWishlistPage.setVisible(true);
                updatedWishlistPage.setLocationRelativeTo(null);
                updatedWishlistPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }

    /**
     * @return mainPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Creates JPanel instance to store and display the information of an item.
     * @param item the item being represented.
     * @param index index of the item from the search.
     * @return JPanel of item.
     */
    public static JPanel createPanel(Product item, int index) {
        JPanel panel = new JPanel(new BorderLayout());
        // icon
        JLabel imageLabel = new JLabel();
        Image image;
        Image resizedImage;
        try {
            URL url = new URL(item.getProductImageURL());
            image = ImageIO.read(url);
            resizedImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        } catch (IOException e) {
            System.out.println("Image not found!");
        }
        // text
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));
        JLabel nameLabel = new JLabel(item.getProductName());
        JLabel costLabel = new JLabel(Double.toString(item.getProductPrice()));
        centrePanel.add(nameLabel);
        centrePanel.add(costLabel);
        JLabel indexLabel = new JLabel(Integer.toString(index));

        panel.add(indexLabel, BorderLayout.EAST);
        panel.add(centrePanel, BorderLayout.CENTER);
        panel.add(imageLabel, BorderLayout.WEST);
        return panel;
    }

    /**
     * Adds contentPanel to mainPanel.
     */
    public void renderCentre() {
        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }
}
