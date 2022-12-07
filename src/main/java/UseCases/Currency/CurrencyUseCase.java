package UseCases.Currency;

import DataBase.*;
import Entities.Product;
import Entities.ProductList;
import Entities.User;

import java.util.HashMap;
import java.util.Objects;

/** A use case for products to update their price in supported currencies */
public class CurrencyUseCase {
    private final HashMap<String, Double> cadConversion;
    private final HashMap<String, Double> usdConversion;

    public CurrencyUseCase() {
        this.cadConversion = new HashMap<>();
        cadConversion.put("USD", 0.76);

        this.usdConversion = new HashMap<>();
        usdConversion.put("CAD", 1.34);
    }
    /** Toggles currency of User Settings, and converts all products from all wishlists of user
     * */
    public void toggleCurrency(){
        DataBaseController dataBaseController = new DataBaseController();
        User currUser = dataBaseController.getCurrentUser();

        if (currUser.getCurrency().equals("CAD")){
            currUser.changeCurrency("USD");
        }
        else{
            currUser.changeCurrency("CAD");
        }


        // updating all items found in all wishlists of the user
        for (ProductList wishlist: currUser.getWishlists().getListOfWishlist()){
            for (Product item: wishlist.getProductList()){
                updateProductCurrency(item);
            }
        }

    }



    /** Updates currency of the product by converting product price and currency
     * @param product product to update currency
     * */
    public void updateProductCurrency(Product product) {
        DataBaseController dataBaseController = new DataBaseController();
        String currentCurrency = product.getProductCurrency();
        String newCurrency = dataBaseController.getCurrentUser().getCurrency();

        if (Objects.equals(currentCurrency, newCurrency)) {
            return;
        }

        switch (currentCurrency) {
            case "CAD":
                product.setProductPrice(cadConversion.get(newCurrency) * product.getProductPrice());
                break;
            case "USD":
                product.setProductPrice(usdConversion.get(newCurrency) * product.getProductPrice());
                break;
        }
        product.setProductCurrency(newCurrency);
    }
}
