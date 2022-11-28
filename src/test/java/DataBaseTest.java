import DataBase.DataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;
import java.util.ArrayList;
import java.util.Date;
public class DataBaseTest {
    ArrayList<Double> priceData = new ArrayList();
    ArrayList<Date> priceDate = new ArrayList<>();
    String testDate = "Fri Nov 18 01:04:05 EST 2022";
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 40.99, new Date(testDate), 0, 0, "www.amazonimage.com/keyboard", "CAD", priceData, priceDate);

    @Test
    public void TestDataBaseReturnsUserFilePath() {
        Assertions.assertEquals(DataBase.getUserFilePath(), "src/main/database/users.txt");
    }
    @Test
    public void TestDataBaseReturnsWishListPath() {
        Assertions.assertEquals(DataBase.getWishlistPath("Herman1"), "src/main/database/Herman1.txt");
    }
    @Test
    public void TestDataBaseReturnsTempUserPath() {
        Assertions.assertEquals(DataBase.getTempUserFilePath(), "src/main/database/tempusers.txt");
    }
}
