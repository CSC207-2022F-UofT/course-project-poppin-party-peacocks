import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ExternalInterface.*;
import Entities.*;
import java.io.IOException;
import java.util.ArrayList;

public class SearchItemTest {
    /**
     * Testing search item feature and if all items in the return list are of Object Item
     */
    @Test
    public void searchItemTestItemInstance() throws IOException, InterruptedException {
        SearchitemsApi apiSearcher = new SearchitemsApi();

        ArrayList itemSearchList = apiSearcher.searchToList("mechanical keyboard", "CA");
        for (Object item : itemSearchList) {
            Assertions.assertEquals(true, item instanceof Item);
        }
    }

    /**
     * Testing search item feature and if 10 items were correct added to the list
     */
    @Test
    public void searchItemTestListLengthReturn() throws IOException, InterruptedException {
        SearchitemsApi apiSearcher = new SearchitemsApi();

        ArrayList itemSearchList = apiSearcher.searchToList("mechanical keyboard", "CA");

        Assertions.assertEquals(10, itemSearchList.size());
    }
}
