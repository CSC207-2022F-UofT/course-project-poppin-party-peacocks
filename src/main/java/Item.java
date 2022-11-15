import java.util.*;
public class Item {


    private String itemName;
    private String url;
    private String itemDescription;
    private String[] tags;
    private double itemPrice;
    private double priceChange;
    private double desiredPrice;
    private Date dateAdded;


    public Item(String name, double price, double desiredPrice, String url, String itemDescription, String[] tags){
        this.itemName = name;
        this.itemPrice = price;
        this.priceChange = price;
        this.desiredPrice = desiredPrice;
        this.dateAdded = new Date();
        this.url = url;
        this.itemDescription = itemDescription;
        this.tags = tags;
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
    public void displayItemInConsole(int ranking){
        System.out.println("------------------------------------------");
        System.out.println("(" + ranking + "): " + itemName);
        System.out.println("Price: " + itemPrice);
        System.out.println("Date added: " + dateAdded);
        System.out.println("------------------------------------------");
    }
}
