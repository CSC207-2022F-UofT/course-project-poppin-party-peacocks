package Entities;
import java.util.*;

public class Wishlist {
    private String name;
    private ArrayList<Product> itemList;
    private ArrayList<Product> displayedList;
    private Date dateAdded;
    private ArrayList<String> selectedTags;

    public Wishlist(String name){
        this.name = name;
        this.itemList = new ArrayList<Product>();
        this.displayedList = new ArrayList<Product>();
        this.dateAdded = new Date();
        this.selectedTags = new ArrayList<String>();
    }

    public Wishlist(String name, ArrayList<Product> itemList, ArrayList<Product> displayedList, Date dateAdded, ArrayList<String> selectedTags){
        this.name = name;
        this.itemList = itemList;
        this.displayedList = displayedList;
        this.dateAdded = dateAdded;
        this.selectedTags = selectedTags;
    }

    public String getName() { return  this.name; };
    public ArrayList<Product> getItemList() {return this.itemList; };
    public ArrayList<Product> getDisplayedList() {return this.displayedList; };
    public Date getDateAdded() {return this.dateAdded; };
    public ArrayList<String> getSelectedTags() {return this.selectedTags; };

    public void setDateAdded(Date date) { this.dateAdded = date; }
    /**
     * Sorts wishlist by date in added date (earliest date-latest date) or (latest date-earliest date)
     * @param order The value of string whether the user wants the wishlist to be ascending or descending
     * @return function is void, but function mutates the wishlist by sorting by date
     */
    public void sortWishlistByDate(String order){
        Comparator<Product> itemDateComparator = new ItemDateComparator();

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
        Comparator<Product> itemNameComparator = new ItemNameComparator();

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
        Comparator<Product> itemReviewStarComparator = new ItemReviewStarComparator();

        switch (order.toLowerCase()) {
            case "descending":
                displayedList.sort(itemReviewStarComparator);
                break;
            case "ascending":
                displayedList.sort(Collections.reverseOrder(itemReviewStarComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Sorts wishlist by review count in ascending order (lowest-highest) or descending order (highest-lowest)
     * @param order The value of string whether the user wants the wishlist to be ascending or descending
     * @return function is void, but function mutates the wishlist by sorting with review count
     */
    public void sortWishlistByReviewCount(String order) {
        Comparator<Product> itemReviewCount = new ItemReviewCountComparator();

        switch (order.toLowerCase()) {
            case "descending":
                displayedList.sort(itemReviewCount);
                break;
            case "ascending":
                displayedList.sort(Collections.reverseOrder(itemReviewCount));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Sorts wishlist by price in ascending order (lowest-highest) or descending order (highest-lowest)
     * @param order The value of string whether the user wants the wishlist to be ascending or descending
     * @return function is void, but function mutates the wishlist by sorting with price
     */
    public void sortWishlistByPrice(String order) {
        Comparator<Product> itemPriceComparator = new ItemPriceComparator();

        switch (order.toLowerCase()) {
            case "descending":
                displayedList.sort(itemPriceComparator);
                break;
            case "ascending":
                displayedList.sort(Collections.reverseOrder(itemPriceComparator));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Adding an Entities.Item to the wishlist
     * @param item The Entities.Item that the user wants to add to the wishlist
     * @return True when an Entities.Item gets added to the wishlist
     */
    public boolean addItem(Item item){
        itemList.add(item);
        displayedList.add(item);
        sortWishlistByDate("ascending");
        return true;
    }

    /**
     * Removing an Entities.Item from the wishlist
     * @param deleteItem The Entities.Item the user wants to delete from the wishlist
     * @return True when an Entities.Item gets removed from the wishlist
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
        displayedList = new ArrayList<Product>(itemList);
        ArrayList<Product> tempList = new ArrayList<Product>(itemList);
        for(Product i : displayedList){
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
        for(Product i : itemList) {
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

    /**
    * @return returns the size of the item list
    **/
    public int getListSize(){
        return itemList.size();
    }
}
