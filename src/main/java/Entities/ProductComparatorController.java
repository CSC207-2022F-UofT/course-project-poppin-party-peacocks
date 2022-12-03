package Entities;

/**
 * a controller class that uses comparator factory to create the different types of comparators used in sorting
 */
public class ProductComparatorController {
    /**
     * Returns a ProductComparator based off word
     * @param word String value that corresponds to what type of comparator is created
     * @return ProductComparator that is created in the method depending on word
     */
    public ProductComparator sortWishlist (String word) {
        ProductComparatorFactory ProductFactory = new ProductComparatorFactory();

        switch (word.toLowerCase()) {
            case "date":
                return ProductFactory.createComparator("date");
            case "name":
                return ProductFactory.createComparator("name");
            case "review star":
                return ProductFactory.createComparator("review star");
            case "review count":
                return ProductFactory.createComparator("review count");
            case "price":
                return ProductFactory.createComparator("price");
            default:
                throw new IllegalArgumentException("Unknown comparator name "+ word.toLowerCase());
        }
    }
}
