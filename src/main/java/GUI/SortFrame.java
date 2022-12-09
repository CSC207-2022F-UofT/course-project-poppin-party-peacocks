package GUI;

import Entities.ProductList;
import Controller.ProductComparatorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

/**
 * the frame that contains the sorting methods that the user can choose from.
 */
public class SortFrame extends JFrame {
    // the main panel that contains all the buttons and labels.
    JPanel mainPanel;
    // the wishlist to sort.
    ProductList wl;
    // the wishlist page that the sorting frame is being called from.
    WishlistPage wlp;
    // the font used for displaying the text in buttons and labels.
    Font textFont = new Font("Arial", Font.PLAIN, 12);
    // the list of buttons. Used to change the appearance of the selected one.
    ArrayList<CustomJButton> sortButtons;
    // the current sorting method selected by the user that the list is using.
    String currentSortingMethod;
    // the current ascending/descending sorting settings that the user selected.
    boolean isAscending;
    // the sort by name button. When pressed, sorts the list by name in ascending/descending order.
    CustomJButton sortByName;
    // the sort by price button. When pressed, sorts the list by price in ascending/descending order.
    CustomJButton sortByPrice;
    // the sort by date button. When pressed, sorts the list by date in ascending/descending order.
    CustomJButton sortByDate;
    // the sort by review stars button. When pressed, sorts the list by review stars in ascending/descending order.
    CustomJButton sortByReviewStars;
    // the sort by review count button. When pressed, sorts the list by review count in ascending/descending order.
    CustomJButton sortByReviewCount;
    // the ascending button. When pressed, makes all sorting methods sort in ascending order.
    CustomJButton ascending;
    // the descending button. When pressed, makes all sorting methods sort in descending order.
    CustomJButton descending;
    // the sort button. When pressed, sorts the list based on the current sorting method and order setting.
    CustomJButton sort;
    // the text that displays the current sorting method and sorting order.
    JLabel sortingText;

    /**
     * constructor. Creates an instance of SortFrame that has references to the wishlist page it was opened from,
     * the withlist to sort, the current sorting method, and the sorting order.
     * @param wlp the wishlist page the sort frame was opened from
     * @param wl the wishlist to sort
     * @param curSortMethod the previously selected sorting method, as of opening the sort frame
     * @param isAscending the previously selected sorting order, as of opening the sort frame
     */
    public SortFrame(WishlistPage wlp, ProductList wl, String curSortMethod, boolean isAscending){
        super("Sort");
        this.wl = wl;
        this.wlp = wlp;
        this.currentSortingMethod = curSortMethod;
        this.isAscending = isAscending;
        initializeJFrame();
        initializeMainPanel();
    }

    /**
     * initialises the JFrame. Sets up its settings and initialises the main panel.
     */
    public void initializeJFrame(){
        setLayout(null);
        setResizable(false);
        setSize(360, 300);
        setVisible(true);
        mainPanel = new GradientJPanel(null);
        setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * initialises the main panel. Creates and adds all buttons and labels used. Adds the buttons' action listeners
     */
    public void initializeMainPanel(){
        sortButtons = new ArrayList<>();
        sortByName = new CustomJButton("Sort By Name", 0 , 0,
                Color.BLACK, Color.BLACK, textFont);
        sortByName.setBounds(10,10,120,30);
        mainPanel.add(sortByName);
        sortByPrice = new CustomJButton("Sort By Price", 0 , 0,
                Color.BLACK, Color.BLACK, textFont);
        sortByPrice.setBounds(10,50,120,30);
        mainPanel.add(sortByPrice);
        sortByDate = new CustomJButton("Sort By Date", 0 , 0,
                Color.BLACK, Color.BLACK, textFont);
        sortByDate.setBounds(10,90,120,30);
        mainPanel.add(sortByDate);
        sortByReviewStars = new CustomJButton("Sort By Review Stars", 0 , 0,
                Color.BLACK, Color.BLACK, textFont);
        sortByReviewStars.setBounds(150,10,180,30);
        mainPanel.add(sortByReviewStars);
        sortByReviewCount = new CustomJButton("Sort By Review Count", 0 , 0,
                Color.BLACK, Color.BLACK, textFont);
        sortByReviewCount.setBounds(150,50,180,30);
        mainPanel.add(sortByReviewCount);
        ascending = new CustomJButton("Ascending Order", 0 , 0,
                Color.BLACK, Color.BLACK, textFont);
        ascending.setBounds(10,130,150,30);
        mainPanel.add(ascending);
        descending = new CustomJButton("Descending Order", 0 , 0,
                Color.BLACK, Color.BLACK, textFont);
        descending.setBounds(180,130,150,30);
        mainPanel.add(descending);
        sort = new CustomJButton("Sort", 0 , 0,
                Color.BLACK, Color.BLACK, textFont);
        sort.setBounds(230, 170,100,30);
        mainPanel.add(sort);

        sortButtons.add(sortByName);
        sortButtons.add(sortByPrice);
        sortButtons.add(sortByDate);
        sortButtons.add(sortByReviewCount);
        sortButtons.add(sortByReviewStars);

        sortingText = new JLabel(currentSortingMethod + " | Ascending");
        sortingText.setBounds(10,170,200,30);
        mainPanel.add(sortingText);

        sortByName.addActionListener(e -> {
            currentSortingMethod = sortByName.getText();
            updateSelection();
        });
        sortByDate.addActionListener(e -> {
            currentSortingMethod = sortByDate.getText();
            updateSelection();
        });
        sortByPrice.addActionListener(e -> {
            currentSortingMethod = sortByPrice.getText();
            updateSelection();
        });
        sortByReviewStars.addActionListener(e -> {
            currentSortingMethod = sortByReviewStars.getText();
            updateSelection();
        });
        sortByReviewCount.addActionListener(e -> {
            currentSortingMethod = sortByReviewCount.getText();
            updateSelection();
        });
        ascending.addActionListener(e -> {
            isAscending = true;
            updateSelection();
        });
        descending.addActionListener(e -> {
            isAscending = false;
            updateSelection();
        });
        sort.addActionListener(e -> {
            ProductComparatorController comparator = new ProductComparatorController(wl);
            if(isAscending){
                if(currentSortingMethod.equals(sortByDate.getText())){
                    comparator.sortList("ascending", "date");
                } else if (currentSortingMethod.equals(sortByName.getText())) {
                    comparator.sortList("ascending", "name");
                } else if (currentSortingMethod.equals(sortByPrice.getText())) {
                    comparator.sortList("ascending", "price");
                } else if (currentSortingMethod.equals(sortByReviewCount.getText())) {
                    comparator.sortList("ascending", "review count");
                } else if (currentSortingMethod.equals(sortByReviewStars.getText())) {
                    comparator.sortList("ascending", "review star");
                }
            } else {
                if(currentSortingMethod.equals(sortByDate.getText())){
                    comparator.sortList("descending", "date");
                } else if (currentSortingMethod.equals(sortByName.getText())) {
                    comparator.sortList("descending", "name");
                } else if (currentSortingMethod.equals(sortByPrice.getText())) {
                    comparator.sortList("descending", "price");
                } else if (currentSortingMethod.equals(sortByReviewCount.getText())) {
                    comparator.sortList("descending", "review count");
                } else if (currentSortingMethod.equals(sortByReviewStars.getText())) {
                    comparator.sortList("descending", "review star");
                }
            }
            wlp.setWishlist(wl);
            wlp.setSortFrameOpen(false);
            dispose();
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                wlp.setSortFrameOpen(false);
                wlp.refreshMainPanel();
                wlp.setCurrentSortingMethod(currentSortingMethod);
                wlp.setIsAscending(isAscending);
            }
        });
        updateSelection();
    }

    /**
     * updates the appearances of all the buttons so that the currently selected one is highlighted.
     */
    public void updateSelection(){
        for (CustomJButton b:sortButtons){
            if (b.getText().equals(currentSortingMethod)){
                b.setForeground(Color.WHITE);
            }else{
                b.setForeground(Color.BLACK);
            }
        }
        if(isAscending){
            ascending.setForeground(Color.WHITE);
            descending.setForeground(Color.BLACK);
            sortingText.setText(currentSortingMethod + " | Ascending");
        }else{
            ascending.setForeground(Color.BLACK);
            descending.setForeground(Color.WHITE);
            sortingText.setText(currentSortingMethod + " | Descending");
        }
        sortingText.repaint();
        sortByDate.repaint();
        sortByName.repaint();
        sortByPrice.repaint();
        sortByReviewCount.repaint();
        sortByReviewStars.repaint();
        ascending.repaint();
        descending.repaint();
        sortingText.repaint();
        mainPanel.repaint();
    }
}
