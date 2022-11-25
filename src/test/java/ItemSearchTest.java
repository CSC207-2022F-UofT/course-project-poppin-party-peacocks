import Entities.Item;
import ExternalInterface.ItemSearcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ItemSearchTest {
//    /**
//     * Testing search item by keyword feature and if all items in the return list are of Object Entities.Item
//     */
//    @Test
//    public void searchItemTestItemInstance() throws IOException, InterruptedException {
//        ExternalInterface.ItemSearcher itemSearcher = new ExternalInterface.ItemSearcher();
//
//        ArrayList itemSearchList = itemSearcher.searchItemKeywords("mechanical keyboard");
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
//        ExternalInterface.ItemSearcher itemSearcher = new ExternalInterface.ItemSearcher();
//
//        ArrayList itemSearchList = itemSearcher.searchItemKeywords("mechanical keyboard");
//
//        Assertions.assertEquals(10, itemSearchList.size());
//    }

//    /**
//     * Testing search item by url feature and if it is scraping the correct value of price
//    */
//    @Test
//    public void searchItemTestKittenPlushPrice() throws IOException, InterruptedException {
//        ItemSearcher itemSearcher = new ItemSearcher();
//
//        String kittenplush = "https://www.amazon.ca/Kitten-Plush-Stuffed-Animal-Pillow/dp/B088BWPFYZ/ref=sr_1_5?crid=16S7RSE5N25AA&keywords=uwu+cat&qid=1669082008&qu=eyJxc2MiOiIyLjI1IiwicXNhIjoiMC4wMCIsInFzcCI6IjAuMDAifQ%3D%3D&sprefix=uwu+cat%2Caps%2C69&sr=8-5";
//        double expectedPrice = 19.20;
//        Item kittenplushitem = itemSearcher.searchItemUrl(kittenplush, false);
//
//        Assertions.assertEquals(kittenplushitem.getItemPrice(), expectedPrice);
//
//    }

    /**
     * Testing search item by url feature and if it is scraping the correct value of name
     */
    @Test
    public void searchItemTestWorstPlayerToadName() throws IOException, InterruptedException {
        ItemSearcher itemSearcher = new ItemSearcher();

        String toadplush = "https://www.amazon.ca/uiuoutoy-Super-Mario-Bros-Mushroom/dp/B07CZGM7KV/ref=sr_1_1?crid=273IB3Y3TBWBZ&keywords=toad+mario+kart+plush&qid=1669082305&qu=eyJxc2MiOiIxLjQ1IiwicXNhIjoiMC4wMCIsInFzcCI6IjAuMDAifQ%3D%3D&s=books&sprefix=toad+mariokarplushie%2Cstripbooks%2C76&sr=1-1-catcorr";
        String expectedName = "uiuoutoy Super Mario Bros. Red Toad Plush Mushroom 7''";
        Item kittenplushitem = itemSearcher.searchItemUrl(toadplush, false);

        Assertions.assertEquals(kittenplushitem.getItemName(), expectedName);

    }
    /**
     * Testing search item by url feature and if it is scraping the correct value of number of ratings for the product
     */
    @Test
    public void searchItemCarnivalCountRatingTest() throws IOException, InterruptedException {
        ItemSearcher itemSearcher = new ItemSearcher();

        String carnivalplush = "https://www.amazon.ca/BB-Funhouse-Stuffed-Carnival-3-14inch/dp/B09NRGTT1R/ref=sr_1_7?crid=1QCCDI9NB8WIQ&keywords=whale+plush&qid=1669082056&qu=eyJxc2MiOiI2LjAyIiwicXNhIjoiNS4xMiIsInFzcCI6IjQuNTQifQ%3D%3D&sprefix=whale+plushie%2Caps%2C95&sr=8-7";
        Integer expectedCount = 7;
        Item kittenplushitem = itemSearcher.searchItemUrl(carnivalplush, false);

        Assertions.assertEquals(kittenplushitem.getReviewCount(), expectedCount);

    }
}

