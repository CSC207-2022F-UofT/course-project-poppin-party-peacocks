package GUI;

import Entities.ListOfWishlists;
import Entities.ProductList;
import Entities.Wishlist;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * A GUI class that handles the visual representation of a product list. Handles navigation to adjacent pages and logic
 * for adding and deleting products from the list.
 */
public class HomePage extends JFrame {

    private GradientJPanel mainPanel;
    private final ListOfProductLists lwl;
    private JList<WishlistPanel> wishlistPanelJList;
    private JScrollPane wishlistScrollPane;
    private final DataBaseController dbc;
    Color color2 = new Color(106, 189, 154);
    Font headerFont = new Font("Montserrat", Font.PLAIN, 20);

    private final ListOfProductLists listOfWishlists;
    private JList<ItemPanel> itemPanelJList;
    private JScrollPane itemScrollPane;

    private String userCurrency;

    public HomePage() {
         // # TODO how to initialize listOfWishlist
        DataBaseController dataBaseController = new DataBaseController();
        User currUser = dataBaseController.getCurrentUser();
        this.lwl = dbc.getListOfWishlists(dbc.getCurrentUser().getName());
        listOfWishlists = currUser.getWishlists();
        userCurrency = currUser.getCurrency();
        initialiseJFrame();
        initialiseMainPanel();
    }

    /**
     * @return the main panel for this JFrame
     */
    public JPanel getMainPanel(){return mainPanel;}

    /**
     * sets up the JFrame
     */
    private void initialiseJFrame(){
        setLayout(null);
        setResizable(false);
        setSize(360, 640);
        setVisible(true);
        mainPanel = new GradientJPanel(null);
    }

    /**
     * Initialises the main panel to contain all of its buttons and items
     * Adds action listeners to the buttons to facilitate page navigation and other functionality
     */

    private void initialiseMainPanel(){
        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(color2);
        topPanel.setBounds(0,0,360,56);
        String titleString = "My Wishlists";
        JLabel titleLabel = new CustomJLabel(titleString, Color.WHITE, headerFont);
        titleLabel.setBounds(122,17,130,24);
        topPanel.add(titleLabel);

        // currency indicator

        JButton currencyIcon = new JButton(new ImageIcon("src/main/java/Assets/cadIcon.png"));
        if (!userCurrency.equals("CAD")) {
            currencyIcon = new JButton(new ImageIcon("src/main/java/Assets/usdIcon.png"));
        }
        currencyIcon.setBounds(320, 12, 28, 28);
        currencyIcon.setContentAreaFilled(false);
        currencyIcon.setBorderPainted(true);
        currencyIcon.setBorder(null);
        topPanel.add(currencyIcon);

        mainPanel.add(topPanel);

        // welcome message
        JLabel welcomeLabel = new CustomJLabel("Welcome!", Color.white, headerFont);
        welcomeLabel.setBounds(137, 63, 118, 29);
        mainPanel.add(welcomeLabel);

        // logo
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("src/main/java/Assets/smallerLogo.png"));
        logo.setBounds(130,60,180,180);
        mainPanel.add(logo);


        // toggle currency button
        JButton currencyButton = new ToggleCurrencyButton();
        currencyButton.setBounds(20, 515, 60 ,60);
        mainPanel.add(currencyButton);

        // buttons
        DeleteButton deleteButton = new DeleteButton();
        deleteButton.setBounds(102, 515, 60 ,60);
        mainPanel.add(deleteButton);

        AddButton addButton = new AddButton();
        addButton.setBounds(184,515,60,60);
        mainPanel.add(addButton);

        RightArrowButton viewWishlistButton = new RightArrowButton();
        viewWishlistButton.setBounds(266, 515, 60 ,60);
        mainPanel.add(viewWishlistButton);

        mainPanel.setComponentZOrder(titleLabel, 1);
        mainPanel.setComponentZOrder(topPanel, 2);


        deleteButton.addActionListener(e -> {
            mainPanel.remove(itemScrollPane);
            if (listOfWishlists.getListOfWishlist().size() > 0 & itemPanelJList.getSelectedIndex() >= 0){
                listOfWishlists.removeWishlist(listOfWishlists.getListOfWishlist().get(itemPanelJList.getSelectedIndex()).getName());
                generateListOfWishlists();
            }
        });

        addButton.addActionListener(e -> {
            AddWishlistPage addPage = new AddWishlistPage(listOfWishlists);
            addPage.setContentPane(addPage.getMainPanel());
            addPage.setVisible(true);
            addPage.setLocationRelativeTo(null);
            addPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });

        viewWishlistButton.addActionListener(e -> {
            if (listOfWishlists.getListOfWishlist().size() > 0 & itemPanelJList.getSelectedIndex() >= 0){
                ProductList selectedWishlist = listOfWishlists.getListOfWishlist().get(itemPanelJList.getSelectedIndex());
                WishlistPage wishlistPage = null;
                try {
                    wishlistPage = new WishlistPage(selectedWishlist);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                wishlistPage.setContentPane(wishlistPage.getMainPanel());
                wishlistPage.setVisible(true);
                wishlistPage.setLocationRelativeTo(null);
                wishlistPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dispose();
            }
        });
    }

    /**
     * creates a JScrollPane from a JList from a list from the wishlist
     * Configures the JScrollPane and adds it to the main panel
     */
    private void generateListOfWishlists(){
        ArrayList<WishlistPanel> panelList = new ArrayList<>();

        for (ProductList wishlist : listOfWishlists.getListOfWishlist()) {
            WishlistPanel wishlistPanel = new WishlistPanel(wishlist.getName());

            panelList.add(wishlistPanel);
        }
        ItemPanel[] tempPanelList = new ItemPanel[panelList.size()];
        tempPanelList = panelList.toArray(tempPanelList);
        itemPanelJList = new JList<>(tempPanelList);
        itemPanelJList.setCellRenderer(new ItemPanelRenderer());
        itemPanelJList.setFixedCellHeight(100);
        itemPanelJList.setFixedCellWidth(310);
        itemPanelJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemPanelJList.setBackground(new Color(194, 234, 186));
        itemScrollPane = new JScrollPane(itemPanelJList);
        itemScrollPane.setBounds(16,80,310,400);
        itemScrollPane.setHorizontalScrollBar(null);
        itemScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        mainPanel.add(itemScrollPane);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}