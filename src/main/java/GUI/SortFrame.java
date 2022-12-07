package GUI;

import Entities.ProductList;
import Entities.Wishlist;
import Controller.ProductComparatorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;


public class SortFrame extends JFrame {
    JPanel mainPanel;
    ProductList wl;
    WishlistPage wlp;
    Font textFont = new Font("Arial", Font.PLAIN, 12);

    ArrayList<CustomJButton> sortButtons;
    String currentSortingMethod;
    boolean isAscending;
    CustomJButton sortByName;
    CustomJButton sortByPrice;
    CustomJButton sortByDate;
    CustomJButton sortByReviewStars;
    CustomJButton sortByReviewCount;
    CustomJButton ascending;
    CustomJButton descending;
    CustomJButton sort;
    JLabel sortingText;
    public SortFrame(WishlistPage wlp, ProductList wl, String curSortMethod, boolean b){
        super("Sort");
        this.wl = wl;
        this.wlp = wlp;
        this.currentSortingMethod = curSortMethod;
        this.isAscending = b;
        initializeJFrame();
        initializeMainPanel();
    }
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
