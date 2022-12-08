package GUI;

import DataBase.*;
import Entities.*;
import UseCases.Currency.CurrencyUseCase;

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
    private JList<WishlistPanel> wishlistPanelJList;
    private JScrollPane wishlistScrollPane;
    private DataBaseController dbc = new DataBaseController();
    Color color2 = new Color(106, 189, 154);
    Font headerFont = new Font("Montserrat", Font.PLAIN, 20);

    private ListOfProductLists listOfWishlists;

    private String userCurrency;

    public HomePage() throws IOException, ParseException, org.json.simple.parser.ParseException {
         // # TODO how to initialize listOfWishlist
        CurrencyUseCase currencyUseCase = new CurrencyUseCase();
        currencyUseCase.toggleCurrency();
        currencyUseCase.toggleCurrency();
        DataBaseController dbc = new DataBaseController();




        listOfWishlists = dbc.getListOfWishlists(dbc.getCurrentUser().getName());
        userCurrency = dbc.getCurrentUser().getCurrency();
        initialiseJFrame();
        initialiseMainPanel();
        generateListOfWishlists();
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

        currencyButton.addActionListener(e -> {
            mainPanel.remove(topPanel);

            if (userCurrency.equals("CAD")){
                userCurrency = "USD";
            }
            else {
                userCurrency = "CAD";
            }

            JPanel newTopPanel = new JPanel(null);
            newTopPanel.setBackground(color2);
            newTopPanel.setBounds(0,0,360,56);
            newTopPanel.add(titleLabel);

            // currency indicator

            JButton newCurrencyIcon = new JButton(new ImageIcon("src/main/java/Assets/cadIcon.png"));
            if (!userCurrency.equals("CAD")) {
                newCurrencyIcon = new JButton(new ImageIcon("src/main/java/Assets/usdIcon.png"));
            }
            newCurrencyIcon.setBounds(320, 12, 28, 28);
            newCurrencyIcon.setContentAreaFilled(false);
            newCurrencyIcon.setBorderPainted(true);
            newCurrencyIcon.setBorder(null);
            newTopPanel.add(newCurrencyIcon);
            mainPanel.add(newTopPanel);
            mainPanel.setComponentZOrder(newTopPanel, 2);
            mainPanel.revalidate();
            mainPanel.repaint();


            // TODO: implement price conversion use case here
            CurrencyUseCase currencyUseCase = new CurrencyUseCase();

            try {
                currencyUseCase.toggleCurrency();
                dbc = new DataBaseController();
                listOfWishlists = dbc.getListOfWishlists(dbc.getCurrentUser().getName());
                dbc.saveListOfWishlists(listOfWishlists, dbc.getCurrentUser());
            } catch (IOException | ParseException | org.json.simple.parser.ParseException ex) {
                throw new RuntimeException(ex);
            }
            userCurrency = dbc.getCurrentUser().getCurrency();

            mainPanel.remove(wishlistScrollPane);
            generateListOfWishlists();
        });


        deleteButton.addActionListener(e -> {
            mainPanel.remove(wishlistScrollPane);
            if (listOfWishlists.getListOfWishlist().size() > 0 & wishlistPanelJList.getSelectedIndex() >= 0){
                listOfWishlists.removeWishlist(listOfWishlists.getListOfWishlist().get(wishlistPanelJList.getSelectedIndex()));
                try {
                    dbc.saveListOfWishlists(listOfWishlists, dbc.getCurrentUser());
                    dbc = new DataBaseController();
                    listOfWishlists = dbc.getListOfWishlists(dbc.getCurrentUser().getName());
                } catch (ParseException | org.json.simple.parser.ParseException | IOException ex) {
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
            if (listOfWishlists.getListOfWishlist().size() > 0 & wishlistPanelJList.getSelectedIndex() >= 0){
                ProductList selectedWishlist = listOfWishlists.getListOfWishlist().get(wishlistPanelJList.getSelectedIndex());
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
        for (ProductList wishlist : listOfWishlists.getListOfWishlist()) {
            WishlistPanel wishlistPanel = new WishlistPanel(wishlist.getName());
            panelList.add(wishlistPanel);
        }
        WishlistPanel[] tempPanelList = new WishlistPanel[panelList.size()];
        tempPanelList = panelList.toArray(tempPanelList);
        wishlistPanelJList= new JList<>(tempPanelList);
        wishlistPanelJList.setCellRenderer(new WishlistPanelRenderer());
        wishlistPanelJList.setFixedCellHeight(100);
        wishlistPanelJList.setFixedCellWidth(310);
        wishlistPanelJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wishlistPanelJList.setBackground(new Color(194, 234, 186));
        wishlistScrollPane = new JScrollPane(wishlistPanelJList);
        wishlistScrollPane.setBounds(25,210,310,300);
        wishlistScrollPane.setHorizontalScrollBar(null);
        wishlistScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        mainPanel.add(wishlistScrollPane);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}