package GUI;

import Entities.Item;
import GUI.ListOfWishlistsPage;
import Entities.Wishlist;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        titleLabel.setBounds(113,20,200,20);
        titleLabel.setFont(new Font("Montserrat", Font.PLAIN, 20));
        topPanel.add(titleLabel);

        mainPanel.add(topPanel);

        JPanel botPanel = new JPanel(null);
        botPanel.setBackground(new Color(106, 189, 154));
        botPanel.setBounds(0,536,360,56);
        mainPanel.add(botPanel);

        BackButton backButton = new BackButton();
        backButton.setBounds(10,17,24,21);
        mainPanel.add(backButton);


        ItemPanel testItem = new ItemPanel(new ImageIcon("logo_white.png"),
                "test item", "100.00");
        testItem.setLocation(21,100);
        mainPanel.add(testItem);

//        JList itemJList = new JList();
//        JPanel[] panelList = new JPanel[wl.getListSize()];
//        Item[] itemList = new Item[wl.getListSize()];
//        itemList = wl.getItemList().toArray(itemList);
//        for (Item i:itemList){
//            JPanel tempPanel = new JPanel(null);
//
//        }
    }
}
