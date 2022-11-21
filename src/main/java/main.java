import java.io.IOException;
import java.util.ArrayList;

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
//        SearchitemsApi apiSearcher = new SearchitemsApi();
//
//        ArrayList<Item> itemList = apiSearcher.searchToList("mechanical keyboard", "CA");
//
//        for (int i = 0; i < 3; i++) {
//            itemList.get(i).displayItemInConsole(i + 1);
//        }

        SearchItemUrl itemSearcher = new SearchItemUrl();


        Item searchItem = itemSearcher.searchItem("https://www.amazon.ca/Nintendo-Pok%C3%A9monTM-Violet/dp/B0B327JQWT/?_encoding=UTF8&pd_rd_w=lTAnj&content-id=amzn1.sym.b09e9731-f0de-43db-b62a-8954bcec282c&pf_rd_p=b09e9731-f0de-43db-b62a-8954bcec282c&pf_rd_r=RH5X0J96GKQA6C0H20T0&pd_rd_wg=Xvb9Y&pd_rd_r=bdbbe5ac-ee8c-4fd6-9682-439fdabf981f&ref_=pd_gw_ci_mcx_mr_hp_atf_m&th=1");

        System.out.println(searchItem.getItemName());
        System.out.println(searchItem.getItemDescription());
        System.out.println(searchItem.getItemPrice());
        System.out.println(searchItem.getItemURL());
        System.out.println(searchItem.getReviewCount());
        System.out.println(searchItem.getReviewStars());
        System.out.println(searchItem.getItemImageURL());

    }

}
