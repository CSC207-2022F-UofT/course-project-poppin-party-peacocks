package UseCasesTest.Comparator;

import Entities.*;
import UseCases.Comparator.ProductComparator;
import UseCases.Comparator.ProductComparatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductComparatorFactoryTest {
    @Test
    public void DateComparatorTest() {
        ProductComparator testComparator = new ProductComparatorFactory().createComparator("date");

        Assertions.assertTrue(true, String.valueOf(new ProductDateComparator().equals(testComparator)));
    }

    @Test
    public void NameComparatorTest() {
        ProductComparator testComparator = new ProductComparatorFactory().createComparator("name");

        Assertions.assertTrue(true, String.valueOf(new ProductNameComparator().equals(testComparator)));
    }

    @Test
    public void PriceComparatorTest() {
        ProductComparator testComparator = new ProductComparatorFactory().createComparator("price");

        Assertions.assertTrue(true, String.valueOf(new ProductPriceComparator().equals(testComparator)));
    }

    @Test
    public void ReviewCountComparatorTest() {
        ProductComparator testComparator = new ProductComparatorFactory().createComparator("review count");

        Assertions.assertTrue(true, String.valueOf(new ProductReviewCountComparator().equals(testComparator)));
    }

    @Test
    public void ReviewStarComparatorTest() {
        ProductComparator testComparator = new ProductComparatorFactory().createComparator("review star");

        Assertions.assertTrue(true, String.valueOf(new ProductReviewStarComparator().equals(testComparator)));
    }
}
