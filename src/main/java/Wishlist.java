import java.util.*;

public class Wishlist {

    private String name;

    private ArrayList<Item> itemList;
    private ArrayList<Item> displayedList;
    private Date dateAdded;
    private ArrayList<String> selectedTags;

    public Wishlist(String name){
        this.name = name;
        this.itemList = new ArrayList<Item>();
        this.displayedList = new ArrayList<Item>();
        this.dateAdded = new Date();
        this.selectedTags = new ArrayList<String>();
    }
    public void sortWishlistByDate(){
        Comparator<Item> itemDateComparator = new ItemDateComparator();
        displayedList.sort(itemDateComparator);
    }
    public boolean addItem(Item item){
        itemList.add(item);
        displayedList.add(item);
        sortWishlistByDate();
        return true;
    }

    public boolean removeItem(Item deleteItem){
        itemList.remove(deleteItem);
        return true;
    }
    public void filterWishlists(String[] tags){
        selectedTags.addAll(Arrays.asList(tags));
        displayedList = new ArrayList<Item>(itemList);
        ArrayList<Item> tempList = new ArrayList<Item>(itemList);
        for(Item i : displayedList){
            for(String tag : tags){
                ArrayList<String> iTags = new ArrayList<String>(Arrays.asList(i.getTags()));
                if(!iTags.contains(tag)){
                    tempList.remove(i);
                }
            }
        }
        displayedList = tempList;
    }
    public void displayTags(){
        Set<String> tags = new HashSet<String>();
        for(Item i : itemList) {
            for (String tag : i.getTags()) {
                tags.add(tag);
            }
        }
        System.out.println("Tags: " + tags.toString());
    }
    public void displayList(){
        System.out.println("Now displaying: " + name);
        System.out.println("Currently selected tags: " + selectedTags.toString());
        for(int i = 0; i < displayedList.size(); i++){
            displayedList.get(i).displayItemInConsole(i+1);
        }
    }
}
