package Entities;

public class ProductComparatorController {
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
