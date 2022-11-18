import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Item keyboard = new Item("Keyboard", 300.1, 250.0, "www.amazon.com/keyboard", "www.amazonimage.com/keyboard",

                "Description from amazon (or you write your own)", new String[]{"computer accesssories", "Tech", "Mechanical"}, 0, 0);
        Item monitor = new Item("Monitor", 120.99, 85.00, "www.amazon.com/monitor",
                "www.amazonimage.com/keyboard", "second monitor dab", new String[]{"computer accesssories", "Tech", "IPS"}, 0, 0);
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie", "www.amazonimage.com/keyboard",
                "Description from amazon (or you write your own)", new String[]{"toys"}, 0, 0);


        Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");

        // add items keyboard, monitor, plushie as test and displaying them
        System.out.println(christmasWishlist.addItem(keyboard));
        System.out.println(christmasWishlist.addItem(monitor));
        System.out.println(christmasWishlist.addItem(plushie));
        christmasWishlist.displayList();

        //filtering wishlist by tag: "Tech"
        christmasWishlist.filterWishlists(new String[]{"Tech"});
        christmasWishlist.displayList();

        christmasWishlist.filterWishlists(new String[]{"Tech"});
        christmasWishlist.displayList();

        Item priceUpdateTestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1", "www.imageurl.com",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0);

        priceUpdateTestItem.displayItemInConsole(0);
        priceUpdateTestItem.updatePrice();
        priceUpdateTestItem.displayItemInConsole(0);

        SearchitemsApi apiSearcher = new SearchitemsApi();

        ArrayList<Item> itemList = apiSearcher.searchToList("mechanical keyboard", "CA");

        for (int i = 0; i < 3; i++) {
            itemList.get(i).displayItemInConsole(i + 1);
        }


    }
}
