import Entities.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

public class ItemTest {
//    /**
//     * Testing search item feature and if all items in the return list are of Object Entities.Item
//     */
//    @Test
//    public void searchItemTestItemInstance() throws IOException, InterruptedException {
//        SearchitemsApi apiSearcher = new SearchitemsApi();
//
//        ArrayList itemSearchList = apiSearcher.searchToList("mechanical keyboard", "CA");
//        for (Object item : itemSearchList) {
//            Assertions.assertEquals(true, item instanceof Item);
//        }
//    }
//
//    /**
//     * Testing search item feature and if 10 items were correct added to the list
//     */
//    @Test
//    public void searchItemTestListLengthReturn() throws IOException, InterruptedException {
//        SearchitemsApi apiSearcher = new SearchitemsApi();
//
//        ArrayList itemSearchList = apiSearcher.searchToList("mechanical keyboard", "CA");
//
//        Assertions.assertEquals(10, itemSearchList.size());
//    }

    /**
     * Testing updatePrice feature and if price has been updated (different price than initial price)
     */
    @Test
    public void updatePriceTestPriceChange() throws IOException {
        Item priceUpdateTestItem = new Item("AmazonBasics Wired Keyboard", 1000.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "www.imageurl.com");

        double initialPrice = priceUpdateTestItem.getProductPrice();

        priceUpdateTestItem.updatePrice();

        double newPrice = priceUpdateTestItem.getProductPrice();

        Assertions.assertEquals(true, initialPrice != newPrice);
    }

    /**
     * Testing setter and getter for Object Entities.Item name variable
     */
    @Test
    public void itemClassTestSetGetName() {
        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "imageurl");
        // Test 1:  Set and Get Name
        TestItem.setName("AmazonBasics Wired Office Keyboard");
        Assertions.assertEquals(true, "AmazonBasics Wired Office Keyboard".equals(TestItem.getProductName()));


    }

    /**
     * Testing getter for Object Entities.Item price variable
     */
    @Test
    public void itemClassTestGetPrice() throws IOException {
        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "imageurl");

        Assertions.assertEquals(true, 20.00 == TestItem.getProductPrice());
    }

    /**
     * Testing setter and getter for Object Entities.Item desired price
     */
    @Test
    public void itemClassTestSetGetDesiredPrice() {
        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "imageurl");

        TestItem.setDesiredPrice(17.00);
        Assertions.assertEquals(true, 17.00 == TestItem.getProductDesiredPrice());
    }

    /**
     * Testing getter for Object Entities.Item url variable
     */
    @Test
    public void itemClassTestSetGetUrl() {
        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "imageurl");
        String testUrl = "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1";

        Assertions.assertEquals(true, testUrl.equals(TestItem.getProductURL()));
    }

    /**
     * Testing getter for Object Entities.Item imageUrl variable
     */
    @Test
    public void itemClassTestSetGetImageUrl() throws IOException {
        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "imageurl");
        String testImageUrl = "imageurl";

        Assertions.assertEquals(true, testImageUrl.equals(TestItem.getProductImageURL()));
    }

    /**
     * Testing setter and getter for Object Entities.Item item description variable
     */
    @Test
    public void itemClassTestSetGetItemDescription() throws IOException {
        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "imageurl");
        String newDescription = "This is a new set item description for AmazonBasics Wired Office Keyboard";

        TestItem.setProductDescription(newDescription);
        Assertions.assertEquals(true, newDescription.equals(TestItem.getProductDescription()));
    }

    /**
     * Testing setter and getter for Object Entities.Item review count variable
     */
    @Test
    public void itemClassTestSetGetReviewCount() throws IOException {
        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "imageurl");

        TestItem.setReviewCount(30);
        Assertions.assertEquals(true, 30 == TestItem.getReviewCount());
    }

    /**
     * Testing setter and getter for Object Entities.Item review star variable
     */
    @Test
    public void itemClassTestSetGetReviewStar() throws IOException {
        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[]{"computer accesssories", "Tech", "office"}, 0, 0, "imageurl");

        TestItem.setReviewStars(4.2);
        Assertions.assertEquals(true, 4.2 == TestItem.getReviewStars());
    }
}