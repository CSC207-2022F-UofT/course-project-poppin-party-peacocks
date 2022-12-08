package GUI;

import Entities.Product;
import Entities.ProductList;
import Entities.Wishlist;
import UseCases.Currency.CurrencyUseCase;
import Entities.*;
import UseCases.Notification.PriceDropNotification;
import UseCases.Notification.SaleNotification;
import DataBase.*;

import ExternalInterface.ItemUpdateChecker;

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
public class WishlistPage extends JFrame {
    // the main panel that contains all the page's contents.
    private GradientJPanel mainPanel;
    // the wishlist being loaded and displayed.
    private ProductList wl;
    // a temporary item list loaded from the wishlist.
    private ArrayList<Product> itemList;
    // the list of item panels created from the item list. Is displayed through the scroll pane.
    private JList<ItemPanel> itemPanelJList;
    // the scroll pane that displays a section of the itemPanelJList.
    private JScrollPane itemScrollPane;
    // a boolean to keep track of whether the sorting frame is already opened.
    private boolean isSortFrameOpen = false;
    // the current sorting method selected from the sorting frame.
    String currentSortingMethod;
    // the current ascending/descending setting for sorting
    boolean isSortedAscending;
    // database controller for reading and writing the wishlist and list of wishlist
    private DataBaseController dbc;
    // a temporary list of product list to save to the database after being mutated
    private final ListOfProductLists lwl;


    /**
     * constructor.
     * @param wishlist wishlist to be loaded
     */
    public WishlistPage(ProductList wishlist) throws IOException, ParseException, org.json.simple.parser.ParseException {
        super(wishlist.getName());
        wl = wishlist;
        dbc = new DataBaseController();
        lwl = dbc.getListOfWishlists(dbc.getCurrentUser().getName());
        initialiseJFrame();
        initialiseMainPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * sets current wishlist to be displayed.
     * @param wl the new wishlist
     */
    public void setWishlist(ProductList wl){
        this.wl = wl;
    }

    /**
     * sets isSortFrameOpen. Will not open another sorting frame if a current one is already open.
     * @param isOpen the new boolean
     */
    public void setSortFrameOpen(boolean isOpen){
        this.isSortFrameOpen = isOpen;
    }

    /**
     * saves sorting method to be loaded by the sorting frame
     * @param s the new sorting method
     */
    public void setCurrentSortingMethod(String s) {this.currentSortingMethod = s; }

    /**
     * sets the current ascending/descending setting to be loaded by the sorting frame
     * @param b the new ascending/descending setting
     */
    public void setIsAscending(boolean b) {this.isSortedAscending = b; }
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
    private void initialiseMainPanel() throws IOException {
        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(new Color(106, 189, 154));
        topPanel.setBounds(0,0,360,56);
        String titleString = wl.getName();
        if (titleString.length() > 20){
            titleString = titleString.substring(0,19);
        }
        JLabel titleLabel = new JLabel(titleString);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(50,20,280,20);
        titleLabel.setFont(new Font("Montserrat", Font.PLAIN, 20));
        topPanel.add(titleLabel);

        mainPanel.add(topPanel);
        RefreshButton refreshButton = new RefreshButton();
        refreshButton.setBounds(300,9,36,36);
        mainPanel.add(refreshButton);

        BackButton backButton = new BackButton();
        backButton.setBounds(10,17,24,21);
        mainPanel.add(backButton);

        SortButton sortButton = new SortButton();
        sortButton.setBounds(20, 515, 60 ,60);
        mainPanel.add(sortButton);

        DeleteButton deleteButton = new DeleteButton();
        deleteButton.setBounds(102, 515, 60 ,60);
        mainPanel.add(deleteButton);

        AddButton addButton = new AddButton();
        addButton.setBounds(184,515,60,60);
        mainPanel.add(addButton);

        RightArrowButton viewItemButton = new RightArrowButton();
        viewItemButton.setBounds(266, 515, 60 ,60);
        mainPanel.add(viewItemButton);

        mainPanel.setComponentZOrder(titleLabel, 1);
        mainPanel.setComponentZOrder(topPanel, 2);

        currentSortingMethod = "Sort By Date";
        isSortedAscending = true;

        generateListOfItems(false);

        backButton.addActionListener(e -> {
            HomePage homePage;
            try {
                homePage = new HomePage();
            } catch (FileNotFoundException | org.json.simple.parser.ParseException | ParseException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            homePage.setContentPane(homePage.getMainPanel());
            homePage.setVisible(true);
            homePage.setLocationRelativeTo(null);
            homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
        refreshButton.addActionListener(e -> {
            mainPanel.remove(itemScrollPane);
            ItemUpdateChecker IUC = new ItemUpdateChecker();
            mainPanel.repaint();
            for(int i = 0; i < wl.getProductList().size(); i++){
                try {
                    IUC.updatePriceCheck(wl.getDisplayedList().get(i));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                itemPanelJList.getModel().getElementAt(i).setUpdateSuccess(true);
            }
            try {
                generateListOfItems(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        sortButton.addActionListener(e -> {
            if(!isSortFrameOpen){
                @SuppressWarnings("unused")
                SortFrame sortFrame = new SortFrame(this, wl, currentSortingMethod, isSortedAscending);
                isSortFrameOpen = true;
            }
        });
        deleteButton.addActionListener(e -> {
            mainPanel.remove(itemScrollPane);
            try {
                ListOfProductLists updateList = dbc.getListOfWishlists(dbc.getCurrentUser().getName());
                ProductList updateWishList = new Wishlist(wl.getName());
                updateList.removeWishlistByName(wl.getName());
                if (itemList.size() > 0 & itemPanelJList.getSelectedIndex() >= 0){
                    wl.removeProduct(itemList.get(itemPanelJList.getSelectedIndex()));
                    try {
                        generateListOfItems(false);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                for (Product item: wl.getDisplayedList()){
                    updateWishList.addProduct(item);
                }
                updateList.addWishlist(updateWishList);
                dbc.saveListOfWishlists(updateList, dbc.getCurrentUser());
                wl = updateWishList;

            } catch (ParseException | org.json.simple.parser.ParseException | IOException ex) {
                throw new RuntimeException(ex);
            }
//            if (itemList.size() > 0 & itemPanelJList.getSelectedIndex() >= 0){
//                wl.removeProduct(itemList.get(itemPanelJList.getSelectedIndex()));
//                try {
//                    generateListOfItems(false);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }

        });
        addButton.addActionListener(e -> {
            AddItemPage addItemPage = new AddItemPage(wl);
            addItemPage.setContentPane(addItemPage.getMainPanel());
            addItemPage.setVisible(true);
            addItemPage.setLocationRelativeTo(null);
            addItemPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dispose();
        });
        viewItemButton.addActionListener(e -> {
            if (itemList.size() > 0 & itemPanelJList.getSelectedIndex() >= 0){
                Product selectedItem = itemList.get(itemPanelJList.getSelectedIndex());
                ItemPage itemPage = new ItemPage(selectedItem, wl);
                itemPage.setContentPane(itemPage.getMainPanel());
                itemPage.setVisible(true);
                itemPage.setLocationRelativeTo(null);
                itemPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dispose();
            }
        });
    }

    /**
     * removes the current JScrollPane, updates the item list with the new wishlist, and adds a new JScrollPane
     * in place of the old one.
     */
    public void refreshMainPanel(){
        mainPanel.remove(itemScrollPane);
        try {
            generateListOfItems(false);
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }
    /**
     * creates a JScrollPane from a JList from a list from the wishlist
     * Configures the JScrollPane and adds it to the main panel
     */
    private void generateListOfItems(boolean raiseNotification) throws IOException {
        ArrayList<ItemPanel> panelList = new ArrayList<>();
        itemList = wl.getDisplayedList();
        for (Product product : itemList) {
            ItemPanel itemPanel = new ItemPanel(product.getProductImageURL(),
                    product.getProductName(), product.getProductPriceString(), product.getProductDateLastUpdated());
            if(raiseNotification){
                SaleNotification saleNotification = new SaleNotification(product);
                PriceDropNotification priceDropNotification = new PriceDropNotification(product);

                if (saleNotification.checkNotificationAction() || priceDropNotification.checkNotificationAction()) {
                    itemPanel.setBorderColor(new Color(255, 0 ,0));
                }
            }
            panelList.add(itemPanel);
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
        saveWishlistData();
    }

    /**
     * overwrites the wishlist in the list of wishlists and saves it to the database.
     */
    private void saveWishlistData() throws IOException {
        int index = lwl.getIndexByName(wl.getName());
        lwl.setWishlist(index, wl);
        dbc.saveListOfWishlists(lwl, dbc.getCurrentUser());
    }
}