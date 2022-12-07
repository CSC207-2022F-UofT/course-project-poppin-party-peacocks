import Entities.Item;
import UseCases.PriceHistory.PriceHistoryUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.NOVEMBER;


public class PriceHistoryTest {
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 0, 0, "www.amazonimage.com/keyboard");
    Calendar calendar = Calendar.getInstance();
    PriceHistoryUseCase priceHistory = new PriceHistoryUseCase(plushie);

    /**
     * Testing setter and getter for the priceHistoryData field
     */
    @Test
    public void TestSetGetPriceHistoryData(){
        ArrayList<Double> priceHistoryData = new ArrayList<>();
        priceHistoryData.add(40.99);
        priceHistoryData.add(59.38);
        priceHistoryData.add(32.44);
        plushie.setPriceHistoryData(priceHistoryData);
        Assertions.assertEquals(plushie.getPriceHistoryData(), priceHistoryData);
    }

    /**
     * Testing setter and getter for the priceHistoryDates field
     */
    @Test
    public void TestSetGetPriceHistoryDates() {

        ArrayList<Date> priceHistoryDates = new ArrayList<>();
        calendar.set(2022,
                NOVEMBER, 18, 12, 0, 0);
        priceHistoryDates.add(calendar.getTime());
        calendar.set(2022,
                NOVEMBER, 19, 12, 0, 0);
        priceHistoryDates.add(calendar.getTime());
        calendar.set(2022,
                NOVEMBER, 20, 12, 0, 0);
        priceHistoryDates.add(calendar.getTime());
        plushie.setPriceHistoryDates(priceHistoryDates);
        Assertions.assertEquals(plushie.getPriceHistoryDates(), priceHistoryDates);
    }

    /**
     * Mock testing the updatePriceHistory method
     */

    @Test
    public void MockTestUpdatePriceHistoryData(){
        ArrayList<Double> updatedPriceHistoryData = new ArrayList<>();
        updatedPriceHistoryData.add(121.22);
        updatedPriceHistoryData.add(132.20);
        updatedPriceHistoryData.add(134.34);
        ArrayList<Date> updatedPriceHistoryDates = new ArrayList<>();
        updatedPriceHistoryDates.add(new Date());
        updatedPriceHistoryDates.add(new Date());
        updatedPriceHistoryDates.add(new Date());

        plushie.setPriceHistoryData(updatedPriceHistoryData);
        plushie.setPriceHistoryDates(updatedPriceHistoryDates);

        Assertions.assertEquals(updatedPriceHistoryData, plushie.getPriceHistoryData());
        Assertions.assertEquals(updatedPriceHistoryDates, plushie.getPriceHistoryDates());
    }


    /**
     * testing that the convertValidTimePeriodToDaysHelper method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
    @Test
    public void TestConvertValidTimePeriodToDaysHelperValidInputs(){
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>(500);
        for (int i = 0; i< 500; i++){
            priceHistoryDatesTester.add(new Date());
        }
        plushie.setPriceHistoryDates(priceHistoryDatesTester);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("24 hours"), 1);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("1 week"), 7);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("30 days"), 30);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("6 months"), 183);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("1 year"), 365);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("All Time"), 500);
    }

    /**
     * testing that the convertValidTimePeriodToDaysHelper method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */
    @Test
    public void testConvertValidTimePeriodToDaysHelperInvalidInputs(){
        ArrayList<Date> priceHistoryDatesSmall = new ArrayList<>(2);
        for (int i = 0; i< 2; i++){
            priceHistoryDatesSmall.add(new Date());
        }
        plushie.setPriceHistoryDates(priceHistoryDatesSmall);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("1 week"), -1);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("30 days"), -1);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("6 months"), -1);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("1 year"), -1);
        Assertions.assertEquals(priceHistory.convertValidTimePeriodToDaysHelper("ajshfgdj"), -1);
    }

    /**
     * testing that the calculateAveragePrice method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */
    @Test
    public void testCalculateAveragePriceInvalidInputs(){
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTesterEmpty = new ArrayList<>();
        plushie.setPriceHistoryDates(priceHistoryDatesTesterEmpty);
        Assertions.assertEquals(priceHistory.calculateAveragePrice("ajshf"), -1);
        Assertions.assertEquals(priceHistory.calculateAveragePrice("1 year"), -1);
        Assertions.assertEquals(priceHistory.calculateAveragePrice("All Time"), -1);
    }

    /**
     * testing that the calculateAveragePrice method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
    @Test
    public void testCalculateAveragePriceValidInputs() {
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            priceHistoryDataTester.add(1.0);
            priceHistoryDataTester.add(2.0);
            priceHistoryDataTester.add(3.0);
        }
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesSmall = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            priceHistoryDatesSmall.add(new Date());
        }
        plushie.setPriceHistoryDates(priceHistoryDatesSmall);
        Assertions.assertEquals(priceHistory.calculateAveragePrice("30 days"), 2);
        Assertions.assertEquals(priceHistory.calculateAveragePrice("24 hours"), 3);
        Assertions.assertEquals(priceHistory.calculateAveragePrice("1 week"), 2.14);
        Assertions.assertEquals(priceHistory.calculateAveragePrice("All Time"), 2);
    }

    /**
     * testing that the calculateLowestPrice method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
    @Test
    public void testCalculateLowestPriceValidInputs(){
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        for (double i = 0; i < 50; i++) {
            priceHistoryDataTester.add(i);
        }
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            priceHistoryDatesTester.add(new Date());
        }
        plushie.setPriceHistoryDates(priceHistoryDatesTester);
        Assertions.assertEquals(priceHistory.calculateLowestPrice("30 days"), 20);
        Assertions.assertEquals(priceHistory.calculateLowestPrice("All Time"), 0);

    }

    /**
     * testing that the calculateLowestPrice method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */

    @Test
    public void testCalculateLowestPriceInvalidInputs(){
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        for (double i = 0; i < 30; i++) {
            priceHistoryDataTester.add(i);
        }
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        for (double i = 0; i < 30; i++) {
            priceHistoryDatesTester.add(new Date());
        }
        plushie.setPriceHistoryDates(priceHistoryDatesTester);

        Assertions.assertEquals(priceHistory.calculateLowestPrice("asdfsd"), -1);
        Assertions.assertEquals(priceHistory.calculateLowestPrice("1 year"), -1);
        Assertions.assertEquals(priceHistory.calculateLowestPrice("6 months"), -1);
    }


    /**
     * testing that the calculateHighestPrice method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
//    @Test
//    public void testCalculateHighestPriceValidInputs(){
//        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
//        for (double i = 0; i < 50; i++) {
//            priceHistoryDataTester.add(i);
//        }
//        plushie.setPriceHistoryData(priceHistoryDataTester);
//        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
//        for (int i = 0; i < 50; i++){
//            priceHistoryDatesTester.add(new Date());
//        }
//        plushie.setPriceHistoryDates(priceHistoryDatesTester);
//        Assertions.assertEquals(priceHistory.calculateHighestPrice("30 days"), 49);
//        Assertions.assertEquals(priceHistory.calculateHighestPrice("All Time"), 49);
//
//    }

    /**
     * testing that the calculateHighestPrice method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */

    @Test
    public void testCalculateHighestPriceInvalidInputs(){
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        for (double i = 0; i < 30; i++) {
            priceHistoryDataTester.add(i);
        }
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        for (double i = 0; i < 30; i++) {
            priceHistoryDatesTester.add(new Date());
        }
        plushie.setPriceHistoryDates(priceHistoryDatesTester);
        Assertions.assertEquals(priceHistory.calculateHighestPrice("asdfsd"), -1);
        Assertions.assertEquals(priceHistory.calculateHighestPrice("1 year"), -1);
        Assertions.assertEquals(priceHistory.calculateHighestPrice("6 months"), -1);
    }


    /**
     * testing that the calculatePercentChangeFromDesiredPrice method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */
    @Test
    public void testCalculatePercentChangeFromDesiredPriceInvalidInputs(){
        plushie.setDesiredPrice(0);
        Assertions.assertEquals(priceHistory.calculatePercentChangeFromDesiredPrice(), -1);
    }

    /**
     * testing that the calculatePercentChangeFromDesiredPrice method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
    @Test
    public void testCalculatePercentChangeFromDesiredPriceValidInputs(){
        Assertions.assertEquals(priceHistory.calculatePercentChangeFromDesiredPrice(), 136.63);
    }

    /**
     * testing that the calculatePercentChangeFromOriginalPrice method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */
    @Test
    public void testCalculatePercentChangeFromOriginalPriceInvalidInputs(){

        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        priceHistoryDataTester.add(0.0);
        priceHistoryDataTester.add(40.99);
        plushie.setPriceHistoryData(priceHistoryDataTester);
        Assertions.assertEquals(priceHistory.calculatePercentChangeFromOriginalPrice(), -1);
    }

    /**
     * testing that the calculatePercentChangeFromOriginalPrice method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
    @Test
    public void testCalculatePercentChangeFromOriginalPriceValidInputs(){
        //mocking an update price
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        priceHistoryDataTester.add(35.00);
        priceHistoryDataTester.add(40.99);
        plushie.setPriceHistoryData(priceHistoryDataTester);
        Assertions.assertEquals(priceHistory.calculatePercentChangeFromOriginalPrice(), 117.11);
    }


    /**
     * testing that the compareToAveragePrice method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */

    @Test
    public void testCompareToAveragePriceInvalidInputs(){
        // will get average price in last 24 hours = 0
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        priceHistoryDataTester.add(0.0);
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        priceHistoryDatesTester.add(new Date());
        plushie.setPriceHistoryDates(priceHistoryDatesTester);

        Assertions.assertEquals(priceHistory.compareToAveragePrice("asdf"), -1);
        Assertions.assertEquals(priceHistory.compareToAveragePrice("24 hours"), -1);
    }


    /**
     * testing that the compareToAveragePrice method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
    @Test
    public void testCompareToAveragePriceValidInputs(){
        //average of 25.25, most recent price of 40.99
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        priceHistoryDataTester.add(10.0);
        priceHistoryDataTester.add(20.0);
        priceHistoryDataTester.add(30.0);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(40.99);
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        plushie.setPriceHistoryDates(priceHistoryDatesTester);

        Assertions.assertEquals(priceHistory.compareToAveragePrice("1 week"), 162.34);
    }

    /**
     * testing that the compareToLowestPrice method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */

    @Test
    public void testCompareToLowestPriceInvalidInputs(){

        //makes denominator (lowest price in last 24 hours) = 0
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        priceHistoryDataTester.add(0.0);
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        priceHistoryDatesTester.add(new Date());
        plushie.setPriceHistoryDates(priceHistoryDatesTester);

        Assertions.assertEquals(priceHistory.compareToLowestPrice("asdf"), -1);
        Assertions.assertEquals(priceHistory.compareToLowestPrice("24 hours"), -1);
    }


    /**
     * testing that the compareToLowestPrice method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
    @Test
    public void testCompareToLowestPriceValidInputs(){

        //lowest price of 10, most recent price of 40.99
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        priceHistoryDataTester.add(10.0);
        priceHistoryDataTester.add(20.0);
        priceHistoryDataTester.add(30.0);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(40.99);
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        plushie.setPriceHistoryDates(priceHistoryDatesTester);

        Assertions.assertEquals(priceHistory.compareToLowestPrice("1 week"), 409.9);
    }

    /**
     * testing that the compareToHighestPrice method returns correct outputs with invalid inputs (reaching
     * all invalid input branches/lines of code)
     */

    @Test
    public void testCompareToHighestPriceInvalidInputs(){
        Item plushieTester = new Item("Plushie", 0, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", new String[]{"toys"}, 0, 0, "www.amazonimage.com/keyboard");
        PriceHistoryUseCase priceHistoryTester = new PriceHistoryUseCase(plushieTester);

        // will get average price in last 24 hours = 0
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        priceHistoryDataTester.add(0.0);
        plushieTester.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        priceHistoryDatesTester.add(new Date());
        plushieTester.setPriceHistoryDates(priceHistoryDatesTester);

        Assertions.assertEquals(priceHistoryTester.compareToHighestPrice("asdf"), -1);
        Assertions.assertEquals(priceHistoryTester.compareToHighestPrice("24 hours"), -1);
    }


    /**
     * testing that the compareToHighestPrice method returns correct outputs with valid inputs (reaching
     * all valid input branches/lines of code)
     */
    @Test
    public void testCompareToHighestPriceValidInputs(){

        //lowest price of 10, most recent price of 40.99
        ArrayList<Double> priceHistoryDataTester = new ArrayList<>();
        priceHistoryDataTester.add(10.0);
        priceHistoryDataTester.add(20.0);
        priceHistoryDataTester.add(30.0);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(25.25);
        priceHistoryDataTester.add(40.99);
        plushie.setPriceHistoryData(priceHistoryDataTester);
        ArrayList<Date> priceHistoryDatesTester = new ArrayList<>();
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        priceHistoryDatesTester.add(new Date());
        plushie.setPriceHistoryDates(priceHistoryDatesTester);

        Assertions.assertEquals(priceHistory.compareToHighestPrice("1 week"), 100);
    }



}

