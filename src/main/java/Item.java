import java.util.*;
public class Item {


    private String name;
    private double price;
    private double priceChange;
    private Date date;
    private String url;

    public Item(String name, double price, String url){
        this.name = name;
        this.price = price;
        this.priceChange = price;
        this.date = new Date();
        this.url = url;

    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }



}
