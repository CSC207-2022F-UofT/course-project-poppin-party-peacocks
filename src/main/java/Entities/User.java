package Entities;

import java.util.ArrayList;

public class User {
    private String currency;
    private String name;
    private String password;
    private ListOfProductLists wishlists;
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
     * @param newCurr The value of string whether the user wants the wishlist to be ascending or descending
     * @return True/False, depends on if the active currency is currency the user wants
     */
    public boolean changeCurrency(String newCurr){
        for (String currency: currencyBank){
            if (currency.equals(newCurr)){
                this.currency = newCurr;
                return true;
            }
        }
        return false;
    }
}
