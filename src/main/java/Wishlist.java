import javax.lang.model.type.ErrorType;
import java.util.*;
import java.util.logging.ErrorManager;

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

    /**
     * Sorts wishlist by date in added date (earliest date-latest date) or (latest date-earliest date)
     * @param order The value of string whether the user wants the wishlist to be ascending or descending
     * @return function is void, but function mutates the wishlist by sorting by date
     */
    public void sortWishlistByDate(String order){
        Comparator<Item> itemDateComparator = new ItemDateComparator();

        switch (order.toLowerCase()) {
            case "ascending":
                displayedList.sort(itemDateComparator);
                break;
            case "descending":
                displayedList.sort(Collections.reverseOrder(itemDateComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Sorts wishlist by name in ascending order (A-Z) or descending order (Z-A)
     * @param order The value of string whether the user wants the wishlist to be ascending or descending
     * @return function is void, but function mutates the wishlist by sorting with name
     */
    public void sortWishlistByName(String order) {
        Comparator<Item> itemNameComparator = new ItemNameComparator();

        switch (order.toLowerCase()) {
            case "ascending":
                displayedList.sort(itemNameComparator);
                break;
            case "descending":
                displayedList.sort(Collections.reverseOrder(itemNameComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Sorts wishlist by review stars in ascending order (lowest-highest) or descending order (highest-lowest)
     * @param order The value of string whether the user wants the wishlist to be ascending or descending
     * @return function is void, but function mutates the wishlist by sorting with review stars
     */
    public void sortWishlistByReviewStars(String order) {
        //Comparator<Item> itemReviewStarComparator = new ItemReviewStarComparator();
    }

    /**
     * Sorts wishlist by review count in ascending order (lowest-highest) or descending order (highest-lowest)
     * @param order The value of string whether the user wants the wishlist to be ascending or descending
     * @return function is void, but function mutates the wishlist by sorting with review count
     */
    public void sortWishlistByReviewCount(String order) {
        //Comparator<Item> itemReviewCount = new ItemReviewCountComparator();
    }

    /**
     * Sorts wishlist by price in ascending order (lowest-highest) or descending order (highest-lowest)
     * @param order The value of string whether the user wants the wishlist to be ascending or descending
     * @return function is void, but function mutates the wishlist by sorting with price
     */
    public void sortWishlistByPrice(String order) {
        Comparator<Item> itemPriceComparator = new ItemPriceComparator();

        switch (order.toLowerCase()) {
            case "ascending":
                displayedList.sort(itemPriceComparator);
                break;
            case "descending":
                displayedList.sort(Collections.reverseOrder(itemPriceComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Adding an Item to the wishlist
     * @param item The Item that the user wants to add to the wishlist
     * @return True when an Item gets added to the wishlist
     */
    public boolean addItem(Item item){
        itemList.add(item);
        displayedList.add(item);
        sortWishlistByDate("ascending");
        return true;
    }

    /**
     * Removing an Item from the wishlist
     * @param deleteItem The Item the user wants to delete from the wishlist
     * @return True when an Item gets removed from the wishlist
     */
    public boolean removeItem(Item deleteItem){
        itemList.remove(deleteItem);
        return true;
    }

    /**
     * Filters wishlist by tag
     * @param tags The value of sets of strings of tags
     * @return function is void, but function mutates the wishlist by filtering tags
     */
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

    /**
     * Displays list of tags in console
     * @return function is void, but function displays the tags in console
     */
    public void displayTags(){
        Set<String> tags = new HashSet<String>();
        for(Item i : itemList) {
            for (String tag : i.getTags()) {
                tags.add(tag);
            }
        }
        System.out.println("Tags: " + tags.toString());
    }

    /**
     * Displays wishlist in console
     * @return function is void, but function displays the wishlist in console
     */
    public void displayList(){
        System.out.println("Now displaying: " + name);
        System.out.println("Currently selected tags: " + selectedTags.toString());
        for(int i = 0; i < displayedList.size(); i++){
            displayedList.get(i).displayItemInConsole(i+1);
        }
    }
}
