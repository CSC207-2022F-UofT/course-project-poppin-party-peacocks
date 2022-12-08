package UseCasesTest.Currency;

import Entities.Item;
import Entities.User;
import UseCases.Currency.CurrencyUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import DataBase.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class CurrencyUseCaseTest {

    @Test
    public void CurrencyUseCaseUpdatesCurrencyCAD() {
        Item testItem = new Item("AmazonBasics Wired Keyboard", 1.0, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", 0, 0, "imageurl", "CAD");
        DataBase.currentUser = new User("A", "B", "USD");
        CurrencyUseCase currencyUseCase = new CurrencyUseCase();
        currencyUseCase.updateProductCurrency(testItem);
        Assertions.assertEquals(testItem.getProductPrice(), 0.76);
    }

    @Test
    public void CurrencyUseCaseUpdatesCurrencyUSD() {
        Item testItem = new Item("AmazonBasics Wired Keyboard", 1.0, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", 0, 0, "imageurl", "USD");
        DataBase.currentUser = new User("A", "B", "CAD");
        CurrencyUseCase currencyUseCase = new CurrencyUseCase();
        currencyUseCase.updateProductCurrency(testItem);
        Assertions.assertEquals(testItem.getProductPrice(), 1.34);
    }

    @Test
    public void CurrencyUseCaseUpdatesCurrencySame() {
        Item testItem = new Item("AmazonBasics Wired Keyboard", 1.0, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", 0, 0, "imageurl", "CAD");
        DataBase.currentUser = new User("A", "B", "CAD");
        CurrencyUseCase currencyUseCase = new CurrencyUseCase();
        currencyUseCase.updateProductCurrency(testItem);
        Assertions.assertEquals(testItem.getProductPrice(), 1.0);
    }


    @Test
    public void CurrencyUseCaseToggleTest() throws ParseException, org.json.simple.parser.ParseException, IOException {
        Item testItem = new Item("AmazonBasics Wired Keyboard", 1.0, 15.00, "https://www.amazon.ca/AmazonBasics-KU-0833-Wired-Keyboard/dp/B005EOWBHC/ref=sr_1_6?crid=LXQRVB06NTVV&keywords=keyboard&qid=1668040664&qu=eyJxc2MiOiI3LjM4IiwicXNhIjoiNi42NSIsInFzcCI6IjUuOTMifQ%3D%3D&sprefix=keyboard%2Caps%2C90&sr=8-6&th=1",
                "Low-profile Keys Provide a Quiet, Comfortable Typing Experience\n" +
                        "Hotkeys Enable Easy Access for Media, My Computer, Mute, Volume down, Volume up, and Calculator; 4 Function Keys Control Previous Track, Stop, Play/pause, next Track on Your Media Player\n" +
                        "Simple Wired USB Connection; Works with Windows 2000, XP, Vista, 7, 8, and 10\n" +
                        "Backed by One-year Amazon Basics Warranty\n" +
                        "Ships in Certified Frustration-free Packaging", 0, 0, "imageurl", "CAD");
        DataBase.currentUser = new User("A", "B", "CAD");
        CurrencyUseCase currencyUseCase = new CurrencyUseCase();
        currencyUseCase.updateProductCurrency(testItem);
        Assertions.assertEquals(testItem.getProductCurrency(), "CAD");
        currencyUseCase.toggleCurrency();
        currencyUseCase.updateProductCurrency(testItem);
        Assertions.assertEquals(testItem.getProductCurrency(), "USD");


    }



}
