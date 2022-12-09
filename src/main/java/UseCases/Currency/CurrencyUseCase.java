package UseCases.Currency;

import DataBase.DataBaseController;
import Entities.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


/** A use case for products to update their price in supported currencies */
public class CurrencyUseCase {
    private final HashMap<String, Double> cadConversion;
    private final HashMap<String, Double> usdConversion;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CurrencyUseCase() {
        this.cadConversion = new HashMap<>();
        cadConversion.put("USD", (1/1.34));

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
        double currencyConversion;

        switch (currentCurrency) {
            case "CAD":
                currencyConversion = cadConversion.get(newCurrency);
                break;
            case "USD":
                currencyConversion = usdConversion.get(newCurrency);
                break;
            default:
                currencyConversion = 1;
                break;
        }
        product.setProductPrice(Double.parseDouble(df.format(currencyConversion *
                product.getProductPrice())));
        product.setDesiredPrice(Double.parseDouble(df.format(currencyConversion *
                product.getProductDesiredPrice())));
        product.setPriceChange(Double.parseDouble(df.format(currencyConversion *
                product.getPriceChange())));
        ArrayList<Double> priceData = product.getPriceHistoryData();
        ArrayList<Double> newPriceData = new ArrayList<>();
        for (Double price: priceData){
            newPriceData.add(Double.parseDouble(df.format(currencyConversion *
                    price)));
        }
        product.setPriceHistoryData(newPriceData);
        product.setProductCurrency(newCurrency);
    }
}
