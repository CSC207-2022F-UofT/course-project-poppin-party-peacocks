import java.io.IOException;
import java.util.ArrayList;

import DataBase.DataBase;
import Entities.Item;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

//        Item keyboard = new Item("Keyboard", 300.1, 250.0, "www.amazon.com/keyboard",
//
//                "Description from amazon (or you write your own)", new String[]{"computer accesssories", "Tech", "Mechanical"}, 0, 0,"www.amazonimage.com/keyboard");
//        Item monitor = new Item("Monitor", 120.99, 85.00, "www.amazon.com/monitor", "second monitor dab", new String[]{"computer accesssories", "Tech", "IPS"}, 0, 0,"www.amazonimage.com/keyboard" );
//        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
//                "Description from amazon (or you write your own)", new String[]{"toys"}, 0, 0, "www.amazonimage.com/keyboard");
//

//        Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");
//
//        // add items keyboard, monitor, plushie as test and displaying them
//        System.out.println(christmasWishlist.addItem(keyboard));
//        System.out.println(christmasWishlist.addItem(monitor));
//        System.out.println(christmasWishlist.addItem(plushie));
//        christmasWishlist.displayList();
//
//        //filtering wishlist by tag: "Tech"
//        christmasWishlist.filterWishlists(new String[]{"Tech"});
//        christmasWishlist.displayList();
//
//        christmasWishlist.filterWishlists(new String[]{"Tech"});
//        christmasWishlist.displayList();
//
//        Item priceUpdateTestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
//                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
//                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
//                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
//                        "Backed by One-year Amazon Basics Warranty\n" +
//                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "www.amazonimage.com/keyboard");
//
//        priceUpdateTestItem.displayItemInConsole(0);
//        priceUpdateTestItem.updatePrice();
//        priceUpdateTestItem.displayItemInConsole(0);
//


        ItemSearcher itemSearcher = new ItemSearcher();
        itemSearcher.searchItemKeywords("mechanical keyboard");


        Item searchKeyboard = itemSearcher.searchItemUrl("https://www.amazon.ca/AmazonBasics-15-Piece-Non-Stick-Cookware-Set/dp/B07481LPMF/ref=sr_1_1_sspa?crid=GL9OB02V670X&keywords=pan&qid=1669055492&qu=eyJxc2MiOiI1Ljk4IiwicXNhIjoiNS42OCIsInFzcCI6IjUuMDgifQ%3D%3D&sprefix=pa%2Caps%2C150&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");

        searchKeyboard.displayItemInConsole(1);
        ArrayList<Item> searchItems = itemSearcher.searchItemKeywords("mechanical keyboard");

        for (Item item: searchItems){
            item.displayItemInConsole(1);
        }



    }

}
