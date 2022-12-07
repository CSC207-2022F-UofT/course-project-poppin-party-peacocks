
package GUI;

import Entities.Product;
import Entities.ProductList;
import Entities.Wishlist;
import ExternalInterface.PriceHistoryInterface;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PriceHistoryPage extends JFrame {
    private final GradientJPanel mainPanel;
    private final Product item;
    private final ProductList wl;
    private String compareOriginal;
    private String compareDesired;
    private String compareLowest;
    private String compareHighest;
    private String compareAverage;

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public PriceHistoryPage(Product product, ProductList wishlist) {
        super("Price History");
        this.setLayout((LayoutManager)null);
        this.setSize(360, 640);
        this.setResizable(false);
        this.item = product;
        this.wl = wishlist;
        this.compareHighest = "";
        this.compareAverage = "";
        this.compareDesired = "";
        this.compareLowest = "";
        this.compareOriginal = "";
        Color color1 = new Color(194, 234, 186);
        Color color2 = new Color(106, 189, 154);
        Font textFont = new Font("Montserrat", 0, 14);
        Font titleFont = new Font("Montserrat", 0, 20);
        Font headingFont = new Font("Montserrat", 0, 17);
        this.mainPanel = new GradientJPanel((LayoutManager)null, color1, color2);
        this.mainPanel.setBounds(0, 0, 360, 640);
        JPanel headerPanel = new JPanel((LayoutManager)null);
        headerPanel.setBackground(color2);
        headerPanel.setBounds(0, 0, 360, 56);
        CustomJButton backButton = new CustomJButton("", 0, 0, color2, color2, textFont);
        backButton.setIcon(new ImageIcon("src/main/java/Assets/backArrow.png"));
        backButton.setBounds(15, 15, 25, 25);
        headerPanel.add(backButton);
        String productName = this.item.getProductName();
        if (productName.length() > 24) {
            productName = productName.substring(0, 23) + "...";
        }

        CustomJLabel thisItemLabel = new CustomJLabel(productName, Color.WHITE, titleFont);
        thisItemLabel.setBounds(75, 17, 170, 24);
        headerPanel.add(thisItemLabel);
        this.mainPanel.add(headerPanel);
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(0);
        ImageIcon img = new ImageIcon("src/main/java/Assets/price_history.png");
        Image image = img.getImage();
        Image resizedImage = image.getScaledInstance(300, 250, 4);
        imageLabel.setIcon(new ImageIcon(resizedImage));
        imageLabel.setBounds(30, 76, 300, 250);
        this.mainPanel.add(imageLabel);
        CustomJLabel firstTextLabel = new CustomJLabel("Compare Current Price to:", Color.WHITE, textFont);
        firstTextLabel.setBounds(75, 330, 300, 24);
        this.mainPanel.add(firstTextLabel);
        CustomJLabel originalLabel = new CustomJLabel("Original Price", Color.WHITE, headingFont);
        originalLabel.setBounds(50, 352, 120, 30);
        originalLabel.setOpaque(true);
        originalLabel.setBackground(color2);
        originalLabel.setHorizontalAlignment(0);
        this.mainPanel.add(originalLabel);
        CustomJLabel originalLabelBox = new CustomJLabel(this.compareOriginal + "%", Color.WHITE, headingFont);
        originalLabelBox.setBounds(50, 382, 120, 35);
        originalLabelBox.setOpaque(true);
        originalLabelBox.setBackground(color1);
        originalLabelBox.setHorizontalAlignment(0);
        this.mainPanel.add(originalLabelBox);
        CustomJLabel desiredLabel = new CustomJLabel("Desired Price", Color.WHITE, headingFont);
        desiredLabel.setBounds(200, 352, 120, 30);
        desiredLabel.setOpaque(true);
        desiredLabel.setBackground(color2);
        desiredLabel.setHorizontalAlignment(0);
        this.mainPanel.add(desiredLabel);
        CustomJLabel desiredLabelBox = new CustomJLabel(this.compareDesired + "%", Color.WHITE, headingFont);
        desiredLabelBox.setBounds(200, 382, 120, 35);
        desiredLabelBox.setOpaque(true);
        desiredLabelBox.setBackground(color1);
        desiredLabelBox.setHorizontalAlignment(0);
        this.mainPanel.add(desiredLabelBox);
        CustomJLabel secondTextLabel = new CustomJLabel("Compare Current Price to Historical:", Color.WHITE, textFont);
        secondTextLabel.setBounds(60, 420, 300, 24);
        this.mainPanel.add(secondTextLabel);
        CustomJLabel lowestLabel = new CustomJLabel("Lowest", Color.WHITE, headingFont);
        lowestLabel.setBounds(30, 442, 75, 30);
        lowestLabel.setOpaque(true);
        lowestLabel.setBackground(color2);
        lowestLabel.setHorizontalAlignment(0);
        this.mainPanel.add(lowestLabel);
        CustomJLabel lowestLabelBox = new CustomJLabel(this.compareLowest + "%", Color.WHITE, headingFont);
        lowestLabelBox.setBounds(30, 472, 75, 35);
        lowestLabelBox.setOpaque(true);
        lowestLabelBox.setBackground(color1);
        lowestLabelBox.setHorizontalAlignment(0);
        this.mainPanel.add(lowestLabelBox);
        CustomJLabel highestLabel = new CustomJLabel("Highest", Color.WHITE, headingFont);
        highestLabel.setBounds(145, 442, 75, 30);
        highestLabel.setOpaque(true);
        highestLabel.setBackground(color2);
        highestLabel.setHorizontalAlignment(0);
        this.mainPanel.add(highestLabel);
        CustomJLabel highestLabelBox = new CustomJLabel(this.compareHighest + "%", Color.WHITE, headingFont);
        highestLabelBox.setBounds(145, 472, 75, 35);
        highestLabelBox.setOpaque(true);
        highestLabelBox.setBackground(color1);
        highestLabelBox.setHorizontalAlignment(0);
        this.mainPanel.add(highestLabelBox);
        CustomJLabel averageLabel = new CustomJLabel("Average", Color.WHITE, headingFont);
        averageLabel.setBounds(260, 442, 75, 30);
        averageLabel.setOpaque(true);
        averageLabel.setBackground(color2);
        averageLabel.setHorizontalAlignment(0);
        this.mainPanel.add(averageLabel);
        CustomJLabel averageLabelBox = new CustomJLabel(this.compareAverage + "%", Color.WHITE, headingFont);
        averageLabelBox.setBounds(260, 472, 75, 35);
        averageLabelBox.setOpaque(true);
        averageLabelBox.setBackground(color1);
        averageLabelBox.setHorizontalAlignment(0);
        this.mainPanel.add(averageLabelBox);
        CustomJLabel thirdTextLabel = new CustomJLabel("Select Time Range for Comparison:", Color.WHITE, textFont);
        thirdTextLabel.setBounds(60, 520, 350, 24);
        this.mainPanel.add(thirdTextLabel);
        CustomJButton priceButton1 = new CustomJButton("24 Hours", 0, 0, color2, Color.WHITE, textFont);
        priceButton1.setBounds(5, 550, 110, 20);
        this.mainPanel.add(priceButton1);
        CustomJButton priceButton2 = new CustomJButton("1 Week", 0, 0, color2, Color.WHITE, textFont);
        priceButton2.setBounds(125, 550, 110, 20);
        this.mainPanel.add(priceButton2);
        CustomJButton priceButton3 = new CustomJButton("30 Days", 0, 0, color2, Color.WHITE, textFont);
        priceButton3.setBounds(245, 550, 110, 20);
        this.mainPanel.add(priceButton3);
        CustomJButton priceButton4 = new CustomJButton("6 Months", 0, 0, color2, Color.WHITE, textFont);
        priceButton4.setBounds(5, 580, 110, 20);
        this.mainPanel.add(priceButton4);
        CustomJButton priceButton5 = new CustomJButton("1 Year", 0, 0, color2, Color.WHITE, textFont);
        priceButton5.setBounds(125, 580, 110, 20);
        this.mainPanel.add(priceButton5);
        CustomJButton priceButton6 = new CustomJButton("All Time", 0, 0, color2, Color.WHITE, textFont);
        priceButton6.setBounds(245, 580, 110, 20);
        this.mainPanel.add(priceButton6);
        backButton.addActionListener((e) -> {
            ItemPage itemPage = new ItemPage(this.item, (Wishlist)this.wl);
            itemPage.setContentPane(itemPage.getMainPanel());
            itemPage.setVisible(true);
            itemPage.setLocationRelativeTo((Component)null);
            itemPage.setDefaultCloseOperation(2);
            this.dispose();
        });
        PriceHistoryInterface ph = new PriceHistoryInterface(this.item);
        priceButton1.addActionListener((e) -> {
            try {
                ph.createPriceHistoryChart();
            } catch (IOException var9) {
                throw new RuntimeException(var9);
            }

            this.compareOriginal = ph.parseOriginalPrice();
            this.compareDesired = ph.parseDesiredPrice();
            this.compareLowest = ph.parseLowestPrice("24 hours");
            this.compareHighest = ph.parseHighestPrice("24 hours");
            this.compareAverage = ph.parseAveragePrice("24 hours");
            originalLabelBox.setText(this.compareOriginal + "%");
            originalLabelBox.revalidate();
            desiredLabelBox.setText(this.compareDesired + "%");
            desiredLabelBox.revalidate();
            lowestLabelBox.revalidate();
            lowestLabelBox.setText(this.compareLowest + "%");
            highestLabelBox.revalidate();
            highestLabelBox.setText(this.compareHighest + "%");
            averageLabelBox.revalidate();
            averageLabelBox.setText(this.compareAverage + "%");
        });
        priceButton2.addActionListener((e) -> {
            try {
                ph.createPriceHistoryChart();
            } catch (IOException var9) {
                throw new RuntimeException(var9);
            }

            this.compareOriginal = ph.parseOriginalPrice();
            this.compareDesired = ph.parseDesiredPrice();
            this.compareLowest = ph.parseLowestPrice("1 week");
            this.compareHighest = ph.parseHighestPrice("1 week");
            this.compareAverage = ph.parseAveragePrice("1 week");
            originalLabelBox.setText(this.compareOriginal + "%");
            originalLabelBox.revalidate();
            desiredLabelBox.setText(this.compareDesired + "%");
            desiredLabelBox.revalidate();
            lowestLabelBox.revalidate();
            lowestLabelBox.setText(this.compareLowest + "%");
            highestLabelBox.revalidate();
            highestLabelBox.setText(this.compareHighest + "%");
            averageLabelBox.revalidate();
            averageLabelBox.setText(this.compareAverage + "%");
        });
        priceButton3.addActionListener((e) -> {
            try {
                ph.createPriceHistoryChart();
            } catch (IOException var9) {
                throw new RuntimeException(var9);
            }

            this.compareOriginal = ph.parseOriginalPrice();
            this.compareDesired = ph.parseDesiredPrice();
            this.compareLowest = ph.parseLowestPrice("30 days");
            this.compareHighest = ph.parseHighestPrice("30 days");
            this.compareAverage = ph.parseAveragePrice("30 days");
            originalLabelBox.setText(this.compareOriginal + "%");
            originalLabelBox.revalidate();
            desiredLabelBox.setText(this.compareDesired + "%");
            desiredLabelBox.revalidate();
            lowestLabelBox.revalidate();
            lowestLabelBox.setText(this.compareLowest + "%");
            highestLabelBox.revalidate();
            highestLabelBox.setText(this.compareHighest + "%");
            averageLabelBox.revalidate();
            averageLabelBox.setText(this.compareAverage + "%");
        });
        priceButton4.addActionListener((e) -> {
            try {
                ph.createPriceHistoryChart();
            } catch (IOException var9) {
                throw new RuntimeException(var9);
            }

            this.compareOriginal = ph.parseOriginalPrice();
            this.compareDesired = ph.parseDesiredPrice();
            this.compareLowest = ph.parseLowestPrice("6 months");
            this.compareHighest = ph.parseHighestPrice("6 months");
            this.compareAverage = ph.parseAveragePrice("6 months");
            originalLabelBox.setText(this.compareOriginal + "%");
            originalLabelBox.revalidate();
            desiredLabelBox.setText(this.compareDesired + "%");
            desiredLabelBox.revalidate();
            lowestLabelBox.revalidate();
            lowestLabelBox.setText(this.compareLowest + "%");
            highestLabelBox.revalidate();
            highestLabelBox.setText(this.compareHighest + "%");
            averageLabelBox.revalidate();
            averageLabelBox.setText(this.compareAverage + "%");
        });
        priceButton5.addActionListener((e) -> {
            try {
                ph.createPriceHistoryChart();
            } catch (IOException var9) {
                throw new RuntimeException(var9);
            }

            this.compareOriginal = ph.parseOriginalPrice();
            this.compareDesired = ph.parseDesiredPrice();
            this.compareLowest = ph.parseLowestPrice("1 year");
            this.compareHighest = ph.parseHighestPrice("1 year");
            this.compareAverage = ph.parseAveragePrice("1 year");
            originalLabelBox.setText(this.compareOriginal + "%");
            originalLabelBox.revalidate();
            desiredLabelBox.setText(this.compareDesired + "%");
            desiredLabelBox.revalidate();
            lowestLabelBox.revalidate();
            lowestLabelBox.setText(this.compareLowest + "%");
            highestLabelBox.revalidate();
            highestLabelBox.setText(this.compareHighest + "%");
            averageLabelBox.revalidate();
            averageLabelBox.setText(this.compareAverage + "%");
        });
        priceButton6.addActionListener((e) -> {
            try {
                ph.createPriceHistoryChart();
            } catch (IOException var9) {
                throw new RuntimeException(var9);
            }

            this.compareOriginal = ph.parseOriginalPrice();
            this.compareDesired = ph.parseDesiredPrice();
            this.compareLowest = ph.parseLowestPrice("All Time");
            this.compareHighest = ph.parseHighestPrice("All Time");
            this.compareAverage = ph.parseAveragePrice("All Time");
            originalLabelBox.setText(this.compareOriginal + "%");
            originalLabelBox.revalidate();
            desiredLabelBox.setText(this.compareDesired + "%");
            desiredLabelBox.revalidate();
            lowestLabelBox.revalidate();
            lowestLabelBox.setText(this.compareLowest + "%");
            highestLabelBox.revalidate();
            highestLabelBox.setText(this.compareHighest + "%");
            averageLabelBox.revalidate();
            averageLabelBox.setText(this.compareAverage + "%");
        });
    }
}
