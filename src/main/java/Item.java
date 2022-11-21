import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.*;

public class Item {
    private String itemName;
    private String url;
    private String imageUrl;
    //a short description of the item from the webpage
    private String itemDescription;
    private String[] tags;
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

    private Scheduler scheduler;

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
        this.priceHistoryData = new ArrayList<Double>();
        this.priceHistoryData.add(this.itemPrice);
        this.priceHistoryDates = new ArrayList<Date>();
        this.priceHistoryDates.add(new Date());

        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                try {
                    updatePrice();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        this.scheduler = new Scheduler(t, 1000 * 60 * 60);
    }
    public Item(String name, double price, double desiredPrice, String url, String itemDescription, String[] tags, double priceChange, Date dateAdded, int reviewCount, double reviewStars, String imageUrl){
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
    public double getPriceChange(){
        return this.priceChange;
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

    public ArrayList<Double> getPriceHistoryData(){
        return this.priceHistoryData;
    }
    public ArrayList<Date> getPriceHistoryDates() {return this.priceHistoryDates; }


    public String getItemCurrency() {return this.itemCurrency; }
    public void setName(String newName){
        this.itemName = newName;
    }
    public void setDateAdded(Date date) { this.dateAdded = date; }
    public void setItemDescription(String description) {
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
    public void updateCurrency() {
        HashMap<String, Double> cadConversion = new HashMap<>();
        cadConversion.put("USD", 0.76);
        cadConversion.put("YUAN", 5.33);
        HashMap<String, Double> yuanConversion = new HashMap<>();
        yuanConversion.put("USD", 0.14);
        yuanConversion.put("CAD", 0.19);
        HashMap<String, Double> usdConversion = new HashMap<>();
        usdConversion.put("CAD", 1.34);
        usdConversion.put("YUAN", 7.17);

        String currentCurrency = this.itemCurrency;
        String newCurrency = DataBase.currentUser.getCurrency();

        if (Objects.equals(currentCurrency, newCurrency)) {
            return;
        }

        switch (currentCurrency) {
            case "CAD":
                this.itemPrice = cadConversion.get(newCurrency) * this.itemPrice;
                break;
            case "USD":
                this.itemPrice = usdConversion.get(newCurrency) * this.itemPrice;
                break;
            case "YUAN":
                this.itemPrice = yuanConversion.get(newCurrency) * this.itemPrice;
                break;
        }
        this.itemCurrency = newCurrency;
    }

    public boolean isPriceBelowDesiredPrice(){
        return itemPrice < desiredPrice;
    }
}
