package DataBaseTest;

import DataBase.DataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataBaseTest {
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
