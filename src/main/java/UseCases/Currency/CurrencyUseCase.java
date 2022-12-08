package UseCases.Currency;

import DataBase.*;
import Entities.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Objects;

import java.text.DecimalFormat;


/** A use case for products to update their price in supported currencies */
public class CurrencyUseCase {
    private final HashMap<String, Double> cadConversion;
    private final HashMap<String, Double> usdConversion;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CurrencyUseCase() {
        this.cadConversion = new HashMap<>();
        cadConversion.put("USD", 0.76);

        this.usdConversion = new HashMap<>();
        usdConversion.put("CAD", 1.34);
    }
    /** Toggles currency of User Settings, and converts all products from all wishlists of user
     * */
    public void toggleCurrency() throws IOException, ParseException, org.json.simple.parser.ParseException {
        DataBaseController dataBaseController = new DataBaseController();
        User currUser = dataBaseController.getCurrentUser();

        if (currUser.getCurrency().equals("CAD")){
            currUser.changeCurrency("USD");
        }
        else{
            currUser.changeCurrency("CAD");
        }
        // updating all items found in all wishlists of the user

        ListOfProductLists updatedProductLists = new ListOfWishlists();
        for (ProductList wishlist: dataBaseController.getListOfWishlists(currUser.getName()).getListOfWishlist()){
            ProductList updatedWishlist = new Wishlist(wishlist.getName());
            for (Product item: wishlist.getProductList()){
                updateProductCurrency(item);
                updatedWishlist.addProduct(item);
            }
            updatedProductLists.addWishlist(updatedWishlist);
        }
        dataBaseController.saveListOfWishlists(updatedProductLists, currUser);

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
                product.setProductPrice(Double.parseDouble(df.format(cadConversion.get(newCurrency) *
                        product.getProductPrice())));
                break;
            case "USD":
                product.setProductPrice(Double.parseDouble(df.format(usdConversion.get(newCurrency) *
                        product.getProductPrice())));
                break;
        }

        product.setProductCurrency(newCurrency);
    }
}
