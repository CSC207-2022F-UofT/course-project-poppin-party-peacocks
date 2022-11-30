package GUI;

import Entities.Item;
import Entities.Wishlist;
import javax.swing.*;
import java.awt.*;

public class WishlistPage extends JFrame {

    private GradientJPanel mainPanel;
    private Wishlist wl;

    public WishlistPage(){
        super();
        wl = new Wishlist("New Wishlist");
        this.setTitle(wl.getName());
        setLayout(null);
        setSize(360, 640);
        setResizable(false);
        mainPanel = new GradientJPanel(null);
        initialiseMainPanel();
    }
    public WishlistPage(Wishlist wishlist) {
        super(wishlist.getName());
        wl = wishlist;
        setLayout(null);
        setSize(360, 640);
        setResizable(false);
        mainPanel = new GradientJPanel(null);
        initialiseMainPanel();
    }
    public JPanel getMainPanel(){return mainPanel;}


    private void initialiseMainPanel(){
        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(new Color(106, 189, 154));
        topPanel.setBounds(0,0,360,56);
        JLabel titleLabel = new JLabel(wl.getName());
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(50,20,200,20);
        titleLabel.setFont(new Font("Montserrat", Font.PLAIN, 20));
        topPanel.add(titleLabel);

        mainPanel.add(topPanel);

//        JPanel botPanel = new JPanel(null);
//        botPanel.setBackground(new Color(106, 189, 154));
//        botPanel.setBounds(0,536,360,56);
//        mainPanel.add(botPanel);




        ItemPanel testItem = new ItemPanel("https://cdn.discordapp.com/attachments/1021470245690544208/1047350845303422996/FWNDO5cX0AEOk9y.jpg",
                "test item", "$100.00");
//        testItem.setLocation(21,100);
//        mainPanel.add(testItem);
        Item myFavDrink = new Item("Lime Bubbly", 5.47, 5.00, "www.shoppers.com/bubbly",
                "my favorite drink, bubbly", new String[]{"Drink"}, 69, 4.19,"www.shoppersimage.com/bubbly");
        Item animeFigure = new Item("Starlight Anya Forger", 100, 85.00, "www.amazon.com/AnyaPeanuts", "new Anya figure", new String[]{"Figure"}, 150, 4.8,"www.amazonimage.com/AnyaPeanuts" );
        Item plushie = new Item("Whale Plushie", 40.99, 30.00, "www.amazon.com/WhalePlushie",
                "Giant Whale Plushie", new String[]{"toys"}, 1050, 4.3, "www.amazonimage.com/OhWhale");

        Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");
        christmasWishlist.addProduct(myFavDrink);
        christmasWishlist.addProduct(animeFigure);
        christmasWishlist.addProduct(plushie);
        christmasWishlist.addProduct(plushie);
        christmasWishlist.addProduct(plushie);
        christmasWishlist.addProduct(plushie);


        ItemPanel[] panelList = new ItemPanel[christmasWishlist.getListSize()];
        Item[] itemList = new Item[christmasWishlist.getListSize()];
        itemList = christmasWishlist.getProductList().toArray(itemList);
        for (int i = 0; i < itemList.length; i++){
//            ItemPanel tempPanel = new ItemPanel(itemList[i].getProductURL(), itemList[i].getProductName(), itemList[i].getProductPriceString());
//            panelList[i] = tempPanel;
            panelList[i] = testItem;
        }
        //mainPanel.add(panelList[0]);
//        ItemPanel[] panelList = new ItemPanel[wl.getListSize()];
//        Item[] itemList = new Item[wl.getListSize()];
//        itemList = wl.getProductList().toArray(itemList);
//        for (int i = 0; i < itemList.length; i++){
//            ItemPanel tempPanel = new ItemPanel(itemList[i].getProductURL(), itemList[i].getProductName(), itemList[i].getProductPriceString());
//            panelList[i] = tempPanel;
//        }

        JList<ItemPanel> itemJList = new JList<>(panelList);

        itemJList.setCellRenderer(new ItemPanelRenderer());
        itemJList.setFixedCellHeight(100);
        itemJList.setFixedCellWidth(310);
        itemJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemJList.setBackground(new Color(194, 234, 186));
        JScrollPane itemScrollPane = new JScrollPane(itemJList);
        itemScrollPane.setHorizontalScrollBar(null);
        itemScrollPane.setBounds(16,80,310,420);
        //itemScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        itemScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        mainPanel.add(itemScrollPane);

        BackButton backButton = new BackButton();
        backButton.setBounds(10,17,24,21);
        mainPanel.add(backButton);

        AddButton addButton = new AddButton();
        addButton.setBounds(140,515,60,60);
        mainPanel.add(addButton);
    }
}
