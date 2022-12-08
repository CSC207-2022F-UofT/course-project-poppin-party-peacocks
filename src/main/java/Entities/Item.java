package Entities;

import java.util.Date;
import java.util.*;

/**
 * a class that manages attributes for an Item
 */
public class Item implements Product {
    /** field that contains the name of the item*/
    private String itemName;
    /** field that contains url of the item*/
    private final String url;
    /** field that contains the image url of the item*/
    private final String imageUrl;
    /** field that contains the description of the item from the webpage */
    private String itemDescription;
    /** field that contains the price of the item*/
    private double itemPrice;
    /** field that contains the currency the item is set to*/
    private String itemCurrency;
    /** field that contains the difference between the new price and the current price of the item*/
    private double priceChange;
    /** field that contains the desired price of the item*/
    private double desiredPrice;
    /** field that contains the date added for the item*/
    private Date dateAdded;
    /** field that contains the review stars of the item*/
    private double reviewStars;
    /** field that contains the total review count of the item*/
    private int reviewCount;
    /** field that contains an ArrayList of price history for the item*/
    private ArrayList<Double> priceHistoryData;
    /** field that contains an ArrayList of the dates for price history for the item*/
    private ArrayList<Date> priceHistoryDates;

    public Item(String name, double price, double desiredPrice, String url, String itemDescription, int reviewCount, double reviewStars, String imageUrl){
        this.itemName = name;
        this.itemPrice = price;
        this.priceChange = price;
        this.desiredPrice = desiredPrice;
        this.dateAdded = new Date();
        this.url = url;
        this.imageUrl = imageUrl;
        this.itemDescription = itemDescription;
        this.reviewCount = reviewCount;
        this.reviewStars = reviewStars;
        this.priceHistoryData = new ArrayList<>();
        this.priceHistoryData.add(this.itemPrice);
        this.priceHistoryDates = new ArrayList<>();
        this.priceHistoryDates.add(new Date());
        this.itemCurrency = "CAD";
    }

    public Item(String name, double price, double desiredPrice, String url, String itemDescription, int reviewCount, double reviewStars, String imageUrl, String itemCurrency){
        this.itemName = name;
        this.itemPrice = price;
        this.priceChange = price;
        this.desiredPrice = desiredPrice;
        this.dateAdded = new Date();
        this.url = url;
        this.imageUrl = imageUrl;
        this.itemDescription = itemDescription;
        this.reviewCount = reviewCount;
        this.reviewStars = reviewStars;
        this.priceHistoryData = new ArrayList<>();
        this.priceHistoryData.add(this.itemPrice);
        this.priceHistoryDates = new ArrayList<>();
        this.priceHistoryDates.add(new Date());
        this.itemCurrency = itemCurrency;
    }
    /** Constructor for database */
    public Item(String name, double price, double desiredPrice, String url, String itemDescription, double priceChange, Date dateAdded, int reviewCount, double reviewStars, String imageUrl, String itemCurrency, ArrayList<Double> priceHistoryData, ArrayList<Date> priceHistoryDates){
        this.itemName = name;
        this.itemPrice = price;
        this.priceChange = priceChange;
        this.desiredPrice = desiredPrice;
        this.dateAdded = dateAdded;
        this.url = url;
        this.itemDescription = itemDescription;
        this.reviewCount = reviewCount;
        this.reviewStars = reviewStars;
        this.imageUrl = imageUrl;
        this.itemCurrency = itemCurrency;
        this.priceHistoryData = priceHistoryData;
        this.priceHistoryDates = priceHistoryDates;
    }

     /** Constructor for comparators*/
     public Item (String name, double price, double desiredPrice, String url, String itemDescription, int reviewCount, double reviewStars, String imageUrl, Date dateAdded) {
         this.itemName = name;
         this.itemPrice = price;
         this.desiredPrice = desiredPrice;
         this.url = url;
         this.itemDescription = itemDescription;
         this.reviewStars = reviewStars;
         this.reviewCount = reviewCount;
         this.imageUrl = imageUrl;
         this.dateAdded = dateAdded;
     }

    public String getProductName(){
        return this.itemName;
    }
    public String getProductDescription(){
        return this.itemDescription;
    }
    public String getProductURL(){
        return this.url;
    }
    public String getProductImageURL(){
        return this.imageUrl;
    }
    public double getProductPrice(){
        return this.itemPrice;
    }
    /** gets the price depending on if the currency is set to CAD or USD*/
    public String getProductPriceString(){
        String priceString;
        if ("USD".equals(itemCurrency)) {
            priceString = "$" + itemPrice;
        }
        priceString = "$" + itemPrice;
        return priceString;
    }
    public double getPriceChange(){
        return this.priceChange;
    }
    public double getProductDesiredPrice(){
        return this.desiredPrice;
    }
    public Date getProductDateAdded(){
        return this.dateAdded;
    }
    public ArrayList<Double> getPriceHistoryData(){
        return this.priceHistoryData;
    }
    public ArrayList<Date> getPriceHistoryDates() {return this.priceHistoryDates; }
    public String getProductCurrency() {return this.itemCurrency; }
    public void setName(String newName){
        this.itemName = newName;
    }
    public void setDateAdded(Date date) { this.dateAdded = date; }
    public void setProductDescription(String description) {
        this.itemDescription = description;
    }
    public void setPriceChange(Double priceChange) {
        this.priceChange = priceChange;
    }
    public void setDesiredPrice(double newDesiredPrice) {
        this.desiredPrice = newDesiredPrice;
    }
    public void setPriceHistoryData(ArrayList<Double> updatedPrices){
        this.priceHistoryData = updatedPrices;
    }
    public void setPriceHistoryDates(ArrayList<Date> updatedDates) {this.priceHistoryDates = updatedDates; }
    public void setReviewStars(double newReviewStars) { this.reviewStars = newReviewStars;}
    public double getReviewStars() { return reviewStars;}
    public void setReviewCount(int reviewCount) { this.reviewCount = reviewCount;}
    public int getReviewCount() { return reviewCount;}
    public void setProductPrice(double newPrice) {this.itemPrice = newPrice;}
    public void setProductCurrency(String newCurrency) {this.itemCurrency = newCurrency;}
    public Date getProductDateLastUpdated() {return new Date();}
}