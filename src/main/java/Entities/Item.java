package Entities;

import java.util.Date;
import java.util.*;

/**
 * a class that manages attributes for an Item
 */
public class Item implements Product {
    private String itemName;
    private final String url;
    private final String imageUrl;
    //a short description of the item from the webpage
    private String itemDescription;
    private final String[] tags;
    private double itemPrice;
    private String itemCurrency;
    private double priceChange;
    private double desiredPrice;
    private Date dateAdded;
    private Date dateLastUpdated;
    private double reviewStars;
    private int reviewCount;
    private ArrayList<Double> priceHistoryData;
    private ArrayList<Date> priceHistoryDates;

    public Item(String name, double price, double desiredPrice, String url, String itemDescription, String[] tags, int reviewCount, double reviewStars, String imageUrl){
        this.itemName = name;
        this.itemPrice = price;
        this.priceChange = price;
        this.desiredPrice = desiredPrice;
        this.dateAdded = new Date();
        this.url = url;
        this.imageUrl = imageUrl;
        this.itemDescription = itemDescription;
        this.tags = tags;
        this.dateLastUpdated = new Date();
        this.reviewCount = reviewCount;
        this.reviewStars = reviewStars;
        this.priceHistoryData = new ArrayList<>();
        this.priceHistoryData.add(this.itemPrice);
        this.itemCurrency = "CAD";
    }

    public Item(String name, double price, double desiredPrice, String url, String itemDescription, String[] tags, int reviewCount, double reviewStars, String imageUrl, String itemCurrency){
        this.itemName = name;
        this.itemPrice = price;
        this.priceChange = price;
        this.desiredPrice = desiredPrice;
        this.dateAdded = new Date();
        this.url = url;
        this.imageUrl = imageUrl;
        this.itemDescription = itemDescription;
        this.tags = tags;
        this.dateLastUpdated = new Date();
        this.reviewCount = reviewCount;
        this.reviewStars = reviewStars;
        this.priceHistoryData = new ArrayList<>();
        this.priceHistoryData.add(this.itemPrice);
        this.priceHistoryDates = new ArrayList<>();
        this.priceHistoryDates.add(new Date());
        this.itemCurrency = itemCurrency;
    }
    /** Constructor for database */
    public Item(String name, double price, double desiredPrice, String url, String itemDescription, String[] tags, double priceChange, Date dateAdded, int reviewCount, double reviewStars, String imageUrl, String itemCurrency, ArrayList<Double> priceHistoryData, ArrayList<Date> priceHistoryDates){
        this.itemName = name;
        this.itemPrice = price;
        this.priceChange = priceChange;
        this.desiredPrice = desiredPrice;
        this.dateAdded = dateAdded;
        this.url = url;
        this.itemDescription = itemDescription;
        this.tags = tags;
        this.reviewCount = reviewCount;
        this.reviewStars = reviewStars;
        this.imageUrl = imageUrl;
        this.itemCurrency = itemCurrency;
        this.priceHistoryData = priceHistoryData;
        this.priceHistoryDates = priceHistoryDates;
    }

     /** Constructor for comparators*/
     public Item (String name, double price, double desiredPrice, String url, String itemDescription, int reviewCount, double reviewStars, String imageUrl, Date dateAdded, String[] tags) {
         this.itemName = name;
         this.itemPrice = price;
         this.desiredPrice = desiredPrice;
         this.url = url;
         this.itemDescription = itemDescription;
         this.reviewStars = reviewStars;
         this.reviewCount = reviewCount;
         this.imageUrl = imageUrl;
         this.dateAdded = dateAdded;
         this.tags = tags;
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
    public String getProductPriceString(){
        String priceString;
        switch (itemCurrency){
            case "USD":
                priceString =  "$" + itemPrice;
            case "YUAN":
                priceString =  "¥" + itemPrice;
            default:
                priceString =  "$" + itemPrice;
        }
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
    public Date getProductDateLastUpdated() {return this.dateLastUpdated;}
    public String[] getTags(){
        return this.tags;
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
    public void setDateLastUpdated(Date date) {this.dateLastUpdated = date;}

}
