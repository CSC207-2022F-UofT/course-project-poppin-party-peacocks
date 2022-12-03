package UseCases.Currency;

import DataBase.*;
import Entities.DataBase.DataBaseController;
import Entities.Product;

import java.util.HashMap;
import java.util.Objects;

/** A use case for products to update their price in supported currencies */
public class CurrencyUseCase {
    private final HashMap<String, Double> cadConversion;
    private final HashMap<String, Double> yuanConversion;
    private final HashMap<String, Double> usdConversion;

    public CurrencyUseCase() {
        this.cadConversion = new HashMap<>();
        cadConversion.put("USD", 0.76);
        cadConversion.put("YUAN", 5.33);

        this.yuanConversion = new HashMap<>();
        yuanConversion.put("USD", 0.14);
        yuanConversion.put("CAD", 0.19);

        this.usdConversion = new HashMap<>();
        usdConversion.put("CAD", 1.34);
        usdConversion.put("YUAN", 7.17);
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
            case "YUAN":
                product.setProductPrice(yuanConversion.get(newCurrency) * product.getProductPrice());
                break;
        }
        product.setProductCurrency(newCurrency);
    }
}
