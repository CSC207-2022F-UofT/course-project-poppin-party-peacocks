package Entities;

/**
 * a class that manages User attributes and currency exchange
 */
public class User {
    /** field that contains the desired currency of the user*/
    private String currency;
    /** field that contains name of the user*/
    private String name;
    /** field that contains the password of the user*/
    private final String password;
    /** field that contains the listOfWishlist of the user*/
    private final ListOfProductLists wishlists;
    /** field that contains the supported currencies, CAD and USD*/
    private static final String[] currencyBank = {"USD", "CAD"};

    public User(String name, String password){
        this.name = name;
        this.password = password;
        this.currency = "CAD";
        wishlists = new ListOfWishlists();
    }

    public User(String name, String password, String currency){
        this.name = name;
        this.password = password;
        this.currency = currency;
        wishlists = new ListOfWishlists();
    }

    public String getName(){
        return this.name;
    }

    public String getCurrency(){
        return this.currency;
    }

    public String getPassword(){
        return this.password;
    }

    public ListOfProductLists getWishlists(){
        return this.wishlists;
    }

    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Changes current currency to user given currency
     *
     * @param newCurr The value of string whether the user wants the wishlist to be ascending or descending
     */
    public void changeCurrency(String newCurr){
        for (String currency: currencyBank){
            if (currency.equals(newCurr)){
                this.currency = newCurr;
                return;
            }
        }
    }
}
