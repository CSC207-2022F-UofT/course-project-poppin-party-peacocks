import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Item keyboard = new Item("Keyboard", 300.1, 250.0, "www.amazon.com/keyboard",
                "Description from amazon (or you write your own)", new String[] {"computer accesssories", "Tech", "Mechanical"});
        Item monitor = new Item("Monitor", 120.99, 85.00, "www.amazon.com/monitor",
                "second monitor dab", new String[] {"computer accesssories", "Tech", "IPS"});
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", new String[] {"toys"});

        Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");


//        System.out.println(christmasWishlist.addItem(keyboard));
//        System.out.println(christmasWishlist.addItem(monitor));
//        System.out.println(christmasWishlist.addItem(plushie));
//        christmasWishlist.displayList();
//        christmasWishlist.filterWishlists(new String[] {"Tech"});
//        christmasWishlist.displayList();

        SearchitemsApi apiSearcher = new SearchitemsApi();

        System.out.println(apiSearcher.apiSearch("keyboard", "CA"));
    }
}
