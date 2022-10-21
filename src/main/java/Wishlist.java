import java.util.*;

public class Wishlist {

    private String name;

    private ArrayList<Item> itemList;

    public Wishlist(String name){

        this.name = name;

        this.itemList = new ArrayList<Item>();


    }

    public boolean addItem(Item item){
        itemList.add(item);
        return true;

    }

    public boolean removeItem(Item deleteItem){
        itemList.remove(deleteItem);
        return true;
    }
}
