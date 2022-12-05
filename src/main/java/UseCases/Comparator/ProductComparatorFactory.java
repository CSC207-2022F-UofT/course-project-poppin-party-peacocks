package UseCases.Comparator;

import Entities.*;

/**
 * a class that returns ProductComparators depending on word
 */
public class ProductComparatorFactory {
    public ProductComparator createComparator (String word) {
        String newWord = word.toLowerCase();

        if (newWord.isEmpty())
            return null;
        switch (newWord) {
            case "date":
                return new ProductDateComparator();
            case "name":
                return new ProductNameComparator();
            case "price":
                return new ProductPriceComparator();
            case "review count":
                return new ProductReviewCountComparator();
            case "review star":
                return new ProductReviewStarComparator();
        }
        return null;
    }
}
