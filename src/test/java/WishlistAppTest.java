import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;


import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import tutorial.HelloWorld;

        import java.io.IOException;
        import java.util.ArrayList;


public class WishlistAppTest {


    /** Testing search item (amazon product searching) feature
     * */


    @Test
    public void correctReturnList() throws IOException, InterruptedException {
        SearchitemsApi apiSearcher = new SearchitemsApi();

        ArrayList itemSearchList = apiSearcher.searchToList("mechanical keyboard", "CA");

        // Test 1:  Checks if 10 items were correct added to the list
        Assertions.assertEquals(10, itemSearchList.size());

        // Test 2: Ensures that all items in the return list are of Object Item
        for (Object item: itemSearchList){
            Assertions.assertEquals(true, item instanceof Item);
        }


    }



    /** Testing updatePrice feature
     * */


    @Test
    public void updatePrice() throws IOException {


        Item priceUpdateTestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1", "www.imageurl.com",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[] {"computer accesssories", "Tech", "office"}, 0, 0 );


        double initialPrice = priceUpdateTestItem.getItemPrice();

        priceUpdateTestItem.updatePrice();

        double newPrice=  priceUpdateTestItem.getItemPrice();


        // Test 1:  Checks if price has been updated (different price than inital price
        Assertions.assertEquals(true, initialPrice != newPrice);

    }

    /** Testing setters and getters for Object Item
     * */


    @Test
    public void itemClassSetGet() throws IOException {


        Item TestItem = new Item("AmazonBasics Wired Keyboard", 20.00, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1", "imageurl",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", new String[] {"computer accesssories", "Tech", "office"}, 0, 0 );





        // Test 1:  Set and Get Name
        TestItem.setName("AmazonBasics Wired Office Keyboard");
        Assertions.assertEquals(true, "AmazonBasics Wired Office Keyboard" == TestItem.getItemName());
        // Test 2:  Get Price
        Assertions.assertEquals(true, 20.00 == TestItem.getItemPrice());
        // Test 3:  Set and Get Desired Price
        TestItem.setDesiredPrice(17.00);
        Assertions.assertEquals(true, 17.00 == TestItem.getItemDesiredPrice());
        // Test 4:  Get url
        String testUrl = "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1";
        Assertions.assertEquals(true, testUrl == TestItem.getItemURL());
        // Test 4:  Get url
        String testImageUrl = "imageurl";
        Assertions.assertEquals(true, testImageUrl == TestItem.getItemImageURL());
        // Test 5:  Set and Get Item Description
        String newDescription = "This is a new set item description for AmazonBasics Wired Office Keyboard";
        TestItem.setItemDescription(newDescription);
        Assertions.assertEquals(true, newDescription == TestItem.getItemDescription());
        // Test 6:  Set and Get Review Count
        TestItem.setReviewCount(30);
        Assertions.assertEquals(true, 30 == TestItem.getReviewCount());
        // Test 7:  Set and Get Review Star
        TestItem.setReviewStars(4.2);
        Assertions.assertEquals(true, 4.2 == TestItem.getReviewStars());

    }











}
