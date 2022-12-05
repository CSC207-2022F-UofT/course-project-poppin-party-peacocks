package GUI;

import Entities.Product;
import Entities.Wishlist;
import ExternalInterface.ItemUpdateChecker;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A GUI class that handles the visual representation of a product list. Handles navigation to adjacent pages and logic
 * for adding and deleting products from the list.
 */
public class WishlistPage extends JFrame {

    private GradientJPanel mainPanel;
    private Wishlist wl;
    private ArrayList<Product> itemList;
    private JList<ItemPanel> itemPanelJList;
    private JScrollPane itemScrollPane;
    private boolean isSortFrameOpen = false;

    public WishlistPage(Wishlist wishlist) {
        super(wishlist.getName());
        wl = wishlist;
        initialiseJFrame();
        initialiseMainPanel();
    }
    public void setWishlist(Wishlist wl){
        this.wl = wl;
    }
    public void setSortFrameOpen(boolean isOpen){
        this.isSortFrameOpen = isOpen;
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

        generateListOfItems();
        backButton.addActionListener(e -> {
            HomePage homePage = new HomePage();
            homePage.setContentPane(homePage.getMainPanel());
            homePage.setVisible(true);
            homePage.setLocationRelativeTo(null);
            homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        });
        refreshButton.addActionListener(e -> {
            System.out.println("updating");
            mainPanel.remove(itemScrollPane);
            ItemUpdateChecker IUC = new ItemUpdateChecker();
            mainPanel.repaint();
            for(int i = 0; i < wl.getProductList().size(); i++){
                try{
                    IUC.updatePriceCheck(wl.getDisplayedList().get(i));
                    itemPanelJList.getModel().getElementAt(i).setUpdateSuccess(true);
                }catch(IOException e1){
                    itemPanelJList.getModel().getElementAt(i).setUpdateSuccess(false);
                }
            }
            generateListOfItems();
        });
        sortButton.addActionListener(e -> {
            if(!isSortFrameOpen){
                SortFrame sortFrame = new SortFrame(this, wl);
                isSortFrameOpen = true;
            }
        });
        deleteButton.addActionListener(e -> {
            mainPanel.remove(itemScrollPane);
            if (itemList.size() > 0 & itemPanelJList.getSelectedIndex() >= 0){
                wl.removeProduct(itemList.get(itemPanelJList.getSelectedIndex()));
                generateListOfItems();
            }
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
     * creates a JScrollPane from a JList from a list from the wishlist
     * Configures the JScrollPane and adds it to the main panel
     */
    public void generateListOfItems(){
        ArrayList<ItemPanel> panelList = new ArrayList<>();
        itemList = wl.getProductList();
        for (Product product : itemList) {
            panelList.add(new ItemPanel(product.getProductImageURL(),
                    product.getProductName(), product.getProductPriceString(), product.getProductDateLastUpdated()));
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
