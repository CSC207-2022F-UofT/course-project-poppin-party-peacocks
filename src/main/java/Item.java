import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Date;

public class Item {
    private String itemName;
    private String url;
    private String imageUrl;
    //a short description of the item from the webpage
    private String itemDescription;
    private String[] tags;
    private double itemPrice;
    private double priceChange;
    private double desiredPrice;
    private Date dateAdded;
    private Date dateLastUpdated;
    private double reviewStars;
    private int reviewCount;



    public Item(String name, double price, double desiredPrice, String url, String imageUrl, String itemDescription, String[] tags, int reviewCount, double reviewStars){
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

    public String getItemImageURL(){
        return this.imageUrl;
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

    /** Updates price of Item object through web-scraping the product page on Amazon
     * */
    public void updatePrice() throws IOException{
        try {
            // This line specifies window type and layout of amazon page based on  Window Version and browser for webscraping
            Document doc = Jsoup.connect(url).timeout(10000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36").get();
            Element price = doc.select(".a-offscreen").first();
            assert price != null;
            double sellingPrice = Double.parseDouble(price.text().substring(1));
            priceChange = itemPrice - sellingPrice;
            itemPrice = sellingPrice;
            dateLastUpdated = new Date();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean isPriceBelowDesiredPrice(){
        return itemPrice < desiredPrice;
    }
}
