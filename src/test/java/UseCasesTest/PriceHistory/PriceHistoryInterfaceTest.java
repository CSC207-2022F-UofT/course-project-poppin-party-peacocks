package UseCasesTest.PriceHistory;

import Entities.Item;
import ExternalInterface.PriceHistoryInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PriceHistoryInterfaceTest {

    @Test
    public void TestParseOriginalPrice(){
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", 0, 0, "www.amazonimage.com/keyboard");

        ArrayList<Double> prices = new ArrayList<>();
        prices.add(12.23);
        prices.add(23.3);
        prices.add(31.12);

        ArrayList<Date> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.NOVEMBER, 12);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 13);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 14);
        dates.add(cal.getTime());

        plushie.setPriceHistoryDates(dates);
        plushie.setPriceHistoryData(prices);
        PriceHistoryInterface historyInterface = new PriceHistoryInterface(plushie);
        Assertions.assertEquals(historyInterface.parseOriginalPrice(), "335.16");
    }

    @Test
    public void TestParseDesiredPrice(){
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", 0, 0, "www.amazonimage.com/keyboard");

        ArrayList<Double> prices = new ArrayList<>();
        prices.add(12.23);
        prices.add(23.3);
        prices.add(31.12);

        ArrayList<Date> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.NOVEMBER, 12);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 13);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 14);
        dates.add(cal.getTime());

        plushie.setPriceHistoryDates(dates);
        plushie.setPriceHistoryData(prices);
        PriceHistoryInterface historyInterface = new PriceHistoryInterface(plushie);
        Assertions.assertEquals(historyInterface.parseDesiredPrice(), "136.63");
    }

    @Test
    public void TestParseLowestPrice(){
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", 0, 0, "www.amazonimage.com/keyboard");

        ArrayList<Double> prices = new ArrayList<>();
        prices.add(12.23);
        prices.add(23.3);
        prices.add(31.12);

        ArrayList<Date> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.NOVEMBER, 12);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 13);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 14);
        dates.add(cal.getTime());

        plushie.setPriceHistoryDates(dates);
        plushie.setPriceHistoryData(prices);
        PriceHistoryInterface historyInterface = new PriceHistoryInterface(plushie);
        Assertions.assertEquals(historyInterface.parseLowestPrice("All Time"), "335.16");
        Assertions.assertEquals(historyInterface.parseLowestPrice("1 week"), "-");
    }

    @Test
    public void TestParseHighestPrice(){
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)",0, 0, "www.amazonimage.com/keyboard");

        ArrayList<Double> prices = new ArrayList<>();
        prices.add(12.23);
        prices.add(23.3);
        prices.add(31.12);

        ArrayList<Date> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.NOVEMBER, 12);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 13);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 14);
        dates.add(cal.getTime());

        plushie.setPriceHistoryDates(dates);
        plushie.setPriceHistoryData(prices);
        PriceHistoryInterface historyInterface = new PriceHistoryInterface(plushie);
        Assertions.assertEquals(historyInterface.parseHighestPrice("All Time"), "100.0");
        Assertions.assertEquals(historyInterface.parseHighestPrice("1 week"), "-");
    }

    @Test
    public void TestParseAveragePrice(){
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", 0, 0, "www.amazonimage.com/keyboard");

        ArrayList<Double> prices = new ArrayList<>();
        prices.add(12.23);
        prices.add(23.3);
        prices.add(31.12);

        ArrayList<Date> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.NOVEMBER, 12);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 13);
        dates.add(cal.getTime());
        cal.set(2022, Calendar.NOVEMBER, 14);
        dates.add(cal.getTime());

        plushie.setPriceHistoryDates(dates);
        plushie.setPriceHistoryData(prices);
        PriceHistoryInterface historyInterface = new PriceHistoryInterface(plushie);
        Assertions.assertEquals(historyInterface.parseAveragePrice("All Time"), "184.47");
        Assertions.assertEquals(historyInterface.parseAveragePrice("1 week"), "-");
    }


}
