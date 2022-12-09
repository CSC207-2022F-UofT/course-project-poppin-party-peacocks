package ExternallnterfaceTest;

import Entities.Item;
import Entities.Product;
import ExternalInterface.ItemSearcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ItemSearchTest {
    /**
     * Testing search item by keyword feature and if all items in the return list are of Object Entities.Item
     */
    @Test
    public void searchItemTestItemInstance() throws IOException, InterruptedException {
        ExternalInterface.ItemSearcher itemSearcher = new ExternalInterface.ItemSearcher();

        ArrayList<Product> itemSearchList = itemSearcher.searchItemKeywords("mechanical keyboard");
        for (Object item : itemSearchList) {
            Assertions.assertTrue(item instanceof Item);
        }
    }

    /**
     * Testing search item feature and if 10 items were correct added to the list
     */
    @Test
    public void searchItemTestListLengthReturn() throws IOException, InterruptedException {
        ExternalInterface.ItemSearcher itemSearcher = new ExternalInterface.ItemSearcher();

        ArrayList<Product> itemSearchList = itemSearcher.searchItemKeywords("mechanical keyboard");

        Assertions.assertEquals(10, itemSearchList.size());
    }

    /**
     * Testing search item by url feature and if it is scraping the correct value of price
     */
    @Test
    public void searchItemTestKittenPlushPrice() throws IOException {
        ItemSearcher itemSearcher = new ItemSearcher();

        String kittenplush = "https://www.amazon.ca/Kitten-Plush-Stuffed-Animal-Pillow/dp/B088BWPFYZ/ref=sr_1_5?crid=16S7RSE5N25AA&keywords=uwu+cat&qid=1669082008&qu=eyJxc2MiOiIyLjI1IiwicXNhIjoiMC4wMCIsInFzcCI6IjAuMDAifQ%3D%3D&sprefix=uwu+cat%2Caps%2C69&sr=8-5";

        Product kittenplushitem = itemSearcher.searchItemUrl(kittenplush, false);

        double price = kittenplushitem.getProductPrice();

        Assertions.assertTrue(price > 0.0); // as long as its a price above 0 then the price has been obtained
    }

    /**
     * Testing search item by url feature and if it is scraping the correct value of name
     */
    @Test
    public void searchItemTestWorstPlayerToadName() throws IOException {
        ItemSearcher itemSearcher = new ItemSearcher();

        String toadplush = "https://www.amazon.ca/uiuoutoy-Super-Mario-Bros-Mushroom/dp/B07CZGM7KV/ref=sr_1_1?crid=273IB3Y3TBWBZ&keywords=toad+mario+kart+plush&qid=1669082305&qu=eyJxc2MiOiIxLjQ1IiwicXNhIjoiMC4wMCIsInFzcCI6IjAuMDAifQ%3D%3D&s=books&sprefix=toad+mariokarplushie%2Cstripbooks%2C76&sr=1-1-catcorr";
        Product kittenplushitem = itemSearcher.searchItemUrl(toadplush, false);

        // as long as a string of length greater than 0, then item name has been obtained.

        Assertions.assertTrue(kittenplushitem.getProductName().length() > 0);
    }

    /**
     * Testing search item by url feature and if it is scraping the correct value of number of ratings for the product
     */
    @Test
    public void searchItemCarnivalCountRatingTest() throws IOException {
        ItemSearcher itemSearcher = new ItemSearcher();

        String carnivalplush = "https://www.amazon.ca/BB-Funhouse-Stuffed-Carnival-3-14inch/dp/B09NRGTT1R/ref=sr_1_7?crid=1QCCDI9NB8WIQ&keywords=whale+plush&qid=1669082056&qu=eyJxc2MiOiI2LjAyIiwicXNhIjoiNS4xMiIsInFzcCI6IjQuNTQifQ%3D%3D&sprefix=whale+plushie%2Caps%2C95&sr=8-7";
        Product kittenplushitem = itemSearcher.searchItemUrl(carnivalplush, false);

        Assertions.assertTrue(kittenplushitem.getReviewCount() >= 0);
    }
}

