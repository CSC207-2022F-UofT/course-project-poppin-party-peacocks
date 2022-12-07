package GUI;

import DataBase.*;
import Entities.ListOfProductLists;
import Entities.ProductList;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * A GUI class that handles the visual representation of a list of product list. Handles navigation to
 * adjacent pages and logic for adding and deleting product lists from the list.
 */
public class HomePage extends JFrame {
    private GradientJPanel mainPanel;
    private final ListOfProductLists lwl;
    private JList<WishlistPanel> wishlistPanelJList;
    private JScrollPane wishlistScrollPane;
    private final DataBaseController dbc;
    Color color2 = new Color(106, 189, 154);
    Font headerFont = new Font("Montserrat", Font.PLAIN, 20);

    /**
     * constructor
     * @throws FileNotFoundException fail to find user's data file
     * @throws ParseException fail to parse user's data file
     * @throws org.json.simple.parser.ParseException fail to parse user's data file
     */
    public HomePage() throws FileNotFoundException, ParseException, org.json.simple.parser.ParseException {
        dbc = new DataBaseController();
        this.lwl = dbc.getListOfWishlists(dbc.getCurrentUser().getName());
        initialiseJFrame();
        initialiseMainPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // currency button
        JButton currencyButton = new JButton(new ImageIcon("src/main/java/Assets/moneySymbol.png"));
        currencyButton.setBounds(320, 12, 28, 28);
        currencyButton.setContentAreaFilled(false);
        currencyButton.setBorderPainted(true);
        currencyButton.setBorder(null);
        topPanel.add(currencyButton);

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

        generateListOfWishlists();

        deleteButton.addActionListener(e -> {
            mainPanel.remove(wishlistScrollPane);
            if (lwl.getListOfWishlist().size() > 0 & wishlistPanelJList.getSelectedIndex() >= 0){
                lwl.removeWishlist(lwl.getListOfWishlist().get(wishlistPanelJList.getSelectedIndex()));
                try {
                    dbc.saveListOfWishlists(lwl, dbc.getCurrentUser());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                generateListOfWishlists();
            }
        });

        addButton.addActionListener(e -> {
            AddWishlistPage addPage;
            try {
                addPage = new AddWishlistPage();
            } catch (FileNotFoundException | ParseException | org.json.simple.parser.ParseException ex) {
                throw new RuntimeException(ex);
            }
            addPage.setContentPane(addPage.getMainPanel());
            addPage.setVisible(true);
            addPage.setLocationRelativeTo(null);
            addPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });

        viewWishlistButton.addActionListener(e -> {
            if (lwl.getListOfWishlist().size() > 0 & wishlistPanelJList.getSelectedIndex() >= 0){
                ProductList selectedWishlist = lwl.getListOfWishlist().get(wishlistPanelJList.getSelectedIndex());
                WishlistPage wishlistPage;
                try {
                    wishlistPage = new WishlistPage(selectedWishlist);
                } catch (IOException | ParseException | org.json.simple.parser.ParseException ex) {
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

        for (ProductList wishlist : lwl.getListOfWishlist()) {
            WishlistPanel wishlistPanel = new WishlistPanel(wishlist.getName());

            panelList.add(wishlistPanel);
        }
        WishlistPanel[] tempPanelList = new WishlistPanel[panelList.size()];
        tempPanelList = panelList.toArray(tempPanelList);
        wishlistPanelJList = new JList<>(tempPanelList);
        wishlistPanelJList.setCellRenderer(new WishlistPanelRenderer());
        wishlistPanelJList.setFixedCellHeight(80);
        wishlistPanelJList.setFixedCellWidth(300);
        wishlistPanelJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wishlistPanelJList.setBackground(new Color(194, 234, 186));
        wishlistScrollPane = new JScrollPane(wishlistPanelJList);
        wishlistScrollPane.setBounds(16,220,310,280);
        wishlistScrollPane.setHorizontalScrollBar(null);
        wishlistScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        mainPanel.add(wishlistScrollPane);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}