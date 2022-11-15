import java.util.*;

public class Item {

    private double reviewStars;
    private int reviewCount;
    private String itemName;
    private String url;
    //a short description of the item from the webpage
    private String itemDescription;
    private String[] tags;
    private double itemPrice;
    private double priceChange;
    private double desiredPrice;
    private Date dateAdded;
    private Date dateLastUpdated;


    public Item(String name, double price, double desiredPrice, String url, String itemDescription, String[] tags, int reviewCount, double reviewStars){
        this.itemName = name;
        this.itemPrice = price;
        this.priceChange = price;
        this.desiredPrice = desiredPrice;
        this.dateAdded = new Date();
        this.url = url;
        this.itemDescription = itemDescription;
        this.tags = tags;
        this.dateLastUpdated = new Date();
        this.reviewCount = reviewCount;
        this.reviewStars = reviewStars;

    }

    public String getItemName(){
        return this.itemName;
    }
    public String getItemDescription(){
        return this.itemDescription;
    }
    public String getItemURL(){
        return this.url;
    }
    public double getItemPrice(){
        return this.itemPrice;
    }
    public double getItemDesiredPrice(){
        return this.desiredPrice;
    }
    public Date getItemDateAdded(){
        return this.dateAdded;
    }
    public String[] getTags(){
        return this.tags;
    }
    public void setName(String newName){
        this.itemName = newName;
    }
    public void setItemDescription(String description) {
        this.itemDescription = description;
    }
    public void setDesiredPrice(double newDesiredPrice) {
        this.desiredPrice = newDesiredPrice;
    }
    public void setReviewStars(double newReviewStars) { this.reviewStars = newReviewStars;}

    public double getReviewStars() { return reviewStars;}

    public void setReviewCount(int reviewCount) { this.reviewCount = reviewCount;}

    public int getReviewCount() { return reviewCount;}

    public void displayItemInConsole(int ranking){
        System.out.println("------------------------------------------");
        System.out.println("(" + ranking + "): " + itemName);
        System.out.println("Price: " + itemPrice);
        System.out.println("Date added: " + dateAdded);
        System.out.println("Last Updated: " + dateLastUpdated);
        System.out.println("Description:" + itemDescription);
        System.out.println("Review Stars:" + reviewStars);
        System.out.println("Review Count:" + reviewCount);
        System.out.println("------------------------------------------");
    }
}
