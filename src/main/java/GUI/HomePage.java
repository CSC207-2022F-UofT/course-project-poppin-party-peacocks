//package GUI;
//
//import Controller.UserRegisterController;
//import Entities.User;
//import UseCases.UserRegister.UserRegister;
//import UseCases.UserRegister.UserRegisterCreateUser;
//import UseCases.UserRegister.UserRegisterResponseFormatter;
//import UseCases.UserRegister.UserRegisterStatus;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ComponentAdapter;
//import java.awt.event.ComponentEvent;
//
//public class HomePage extends JFrame {
//    private JPanel mainPanel;
//    private JPanel upperPanel;
//    private JButton signoutButton;
//    private JLabel welcomeLabel;
//    private JLabel usernameLabel;
//    private JPanel upperFooterPanel;
//    private JPanel lowerPanel;
//    private JLabel listOfWishlistsLabel;
//    private JPanel wishlistPanel;
//    private JPanel outerWLPanel;
//    private JPanel lowerFooterPanel;
//    private JButton addWishlistButton;
//
//    private JButton dummyButton;
//    UserRegisterController userRegisterController;
//
//    public JPanel getMainPanel() {
//        return mainPanel;
//    }
//
//    public JLabel createLabel(String text, Font font, Color color) {
//        JLabel label = new JLabel(text);
//        label.setFont(font);
//        label.setForeground(color);
//        return label;
//    }
//
//    public HomePage() {
//        super("My Wishlists");
//        setLayout(null);
//        setSize(360, 640);
//        setResizable(false);
//
////        this.addComponentListener(new ComponentAdapter() {
////            public void componentResized(ComponentEvent e) {
////                JFrame f = (JFrame) e.getSource();
////                f.setSize(400, f.getHeight());
////                lowerPanel.setBounds(0, 300, 400, f.getHeight() - 338);
////                wishlistPanel.setPreferredSize(new Dimension(400, f.getHeight() - 338));
////            }
////        });
//
//        // Constants
//        Font font1 = new Font("Montserrat", Font.PLAIN, 12);
//        Font font2 = new Font("Montserrat", Font.PLAIN, 36);
//        Font headerfont = new Font("Arial", Font.PLAIN, 20);
//
//        Color color1 = new Color(194, 234, 186);
//        Color color2 = new Color(106, 189, 154);
//
//        // main panel
//        mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setBackground(Color.blue);
//        mainPanel.setBounds(0, 0, 360, 640);
////
////        // upper panel
////        upperPanel = new JPanel();
////        upperPanel.setBackground(color1);
////        upperPanel.setBounds(0, 0, 400, 300);
////        upperPanel.setLayout(new BorderLayout());
//
//        //header panel
//        JPanel headerPanel = new JPanel(null);
//        headerPanel.setBackground(color2);
//        headerPanel.setPreferredSize(new Dimension(360, 56));
//
//        // wishlist label
//        CustomJLabel wishlistLabel = new CustomJLabel("My Wishlists", Color.WHITE, headerfont);
//        wishlistLabel.setBounds(125,-5, 391, 64);
//
//        headerPanel.add(wishlistLabel);
//        mainPanel.add(headerPanel, BorderLayout.NORTH);
//
//        // sign out button
////        upperFooterPanel = new JPanel(new FlowLayout());
////        upperFooterPanel.setBackground(color2);
////        signoutButton = new CustomJButton("Sign Out", 150, 30, color2, Color.WHITE, font1);
////        upperFooterPanel.add(signoutButton);
////        upperPanel.add(upperFooterPanel, BorderLayout.SOUTH);
////        // lower panel
////        lowerPanel = new JPanel();
////        lowerPanel.setBackground(color1);
////        lowerPanel.setBounds(0, 300, 400, this.getHeight() - 338);
////        lowerPanel.setLayout(new BorderLayout(20, 20));
////        // wishlists label
////        listOfWishlistsLabel = createLabel("Your Wishlists", font1, Color.BLACK);
////        listOfWishlistsLabel.setHorizontalAlignment(JLabel.CENTER);
////        lowerPanel.add(listOfWishlistsLabel, BorderLayout.NORTH);
////        // footer
////        lowerFooterPanel = new JPanel();
////        lowerFooterPanel.setBackground(color2);
////        lowerFooterPanel.setLayout(new FlowLayout());
////        addWishlistButton = new CustomJButton("Add Wishlist", 150, 30, color2, Color.WHITE, font1);
////        lowerFooterPanel.add(addWishlistButton);
////        lowerPanel.add(lowerFooterPanel, BorderLayout.SOUTH);
//
////        // list of wishlists
////        wishlistPanel = new JPanel();
////        wishlistPanel.setPreferredSize(new Dimension(360, 584));
////        wishlistPanel.setBackground(Color.WHITE);
////        FlowLayout layout = new FlowLayout();
////        wishlistPanel.setLayout(layout);
////
//        // buttons
//        BackButton backButton = new BackButton();
//        backButton.setBounds(10,17,24,21);
//        mainPanel.add(backButton);
//
//        SortButton sortButton = new SortButton();
//        sortButton.setBounds(20, 515, 60 ,60);
//        mainPanel.add(sortButton);
//
//        DeleteButton deleteButton = new DeleteButton();
//        deleteButton.setBounds(102, 515, 60 ,60);
//        mainPanel.add(deleteButton);
//
//        AddButton addButton = new AddButton();
//        addButton.setBounds(184,515,60,60);
//        mainPanel.add(addButton);
//
//        RightArrowButton viewItemButton = new RightArrowButton();
//        viewItemButton.setBounds(266, 515, 60 ,60);
//        mainPanel.add(viewItemButton);
//
////        for (int i = 0; i < 10; i++) {
////            dummyButton = new CustomJButton("dummyButton" + Integer.toString(i), 0, 0, Color.WHITE, color2, font1);
////            wishlistPanel.add(dummyButton);
////        }
////
////        outerWLPanel = new JPanel(new FlowLayout());
////        outerWLPanel.setBackground(color1);
////        outerWLPanel.add(wishlistPanel, BorderLayout.CENTER);
////        lowerPanel.add(outerWLPanel, BorderLayout.CENTER);
//
////        // assemble panels
////        mainPanel.add(headerPanel);
////        mainPanel.add(wishlistPanel, BorderLayout.SOUTH);
//
////        addWishlistButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                // TODO
////                AddWishlistPage addPage = new AddWishlistPage();
////                addPage.setContentPane(addPage.getMainPanel());
////                addPage.setVisible(true);
////                addPage.setLocationRelativeTo(null);
////                addPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////                dispose();
////            }
////        });
//
////        signoutButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                // TODO
////                // Currently, this navigates to GUI.MainAppLoginSignupPage.
////                UserRegisterStatus presenter = new UserRegisterResponseFormatter();
////                UserRegisterCreateUser interactor = new UserRegister(presenter);
////                UserRegisterController userRegisterController = new UserRegisterController(
////                        interactor
////                );
////
////                WelcomePage loginSignupPage = new WelcomePage(userRegisterController);
////                loginSignupPage.setContentPane(loginSignupPage.getMainPanel());
////                loginSignupPage.setVisible(true);
////                loginSignupPage.setLocationRelativeTo(null);
////                loginSignupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////                dispose();
////            }
////        });
//    }
//
//}

package GUI;

import Entities.Product;
import Entities.Wishlist;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A GUI class that handles the visual representation of a product list. Handles navigation to adjacent pages and logic
 * for adding and deleting products from the list.
 */
public class HomePage extends JFrame {

    private GradientJPanel mainPanel;
    private final Wishlist wl;
    private ArrayList<Product> itemList;
    private JList<WishlistPanel> wishlistPanelJList;
    private JScrollPane itemScrollPane;

    public HomePage(){
        super();
        wl = new Wishlist("New Wishlist");
        this.setTitle(wl.getName());
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
        topPanel.setBackground(new Color(106, 189, 154));
        topPanel.setBounds(0,0,360,56);
        JLabel titleLabel = new JLabel(wl.getName());
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(50,20,300,20);
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
        refreshButton.addActionListener(e -> wl.refreshListPrices());
        sortButton.addActionListener(e -> {

        });
        deleteButton.addActionListener(e -> {
            mainPanel.remove(itemScrollPane);
            if (itemList.size() > 0 & wishlistPanelJList.getSelectedIndex() >= 0){
                wl.removeProduct(itemList.get(wishlistPanelJList.getSelectedIndex()));
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
            if (itemList.size() > 0 & wishlistPanelJList.getSelectedIndex() >= 0){
                Product selectedItem = itemList.get(wishlistPanelJList.getSelectedIndex());
                ItemPage itemPage = new ItemPage();
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
    private void generateListOfItems(){
        ArrayList<WishlistPanel> panelList = new ArrayList<>();
        itemList = wl.getProductList();
        for (Product product : itemList) {
            panelList.add(new WishlistPanel(product.getProductName()));
        }
        WishlistPanel[] tempPanelList = new WishlistPanel[panelList.size()];
        tempPanelList = panelList.toArray(tempPanelList);
        wishlistPanelJList = new JList<>(tempPanelList);
        wishlistPanelJList.setCellRenderer(new ItemPanelRenderer());
        wishlistPanelJList.setFixedCellHeight(100);
        wishlistPanelJList.setFixedCellWidth(310);
        wishlistPanelJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wishlistPanelJList.setBackground(new Color(194, 234, 186));
        itemScrollPane = new JScrollPane(wishlistPanelJList);
        itemScrollPane.setBounds(16,80,310,400);
        itemScrollPane.setHorizontalScrollBar(null);
        itemScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        mainPanel.add(itemScrollPane);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}

