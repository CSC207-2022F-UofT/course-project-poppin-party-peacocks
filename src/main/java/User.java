import java.util.ArrayList;
import java.util.List;

public class User {

    private String currency;
    private String name;
    private String password;

    private listOfWishlist listwishlist;



    public User(String name, String password){
        this.name = name;
        this.password = password;
        this.currency = "CAD";
    }


    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;

    }

    public boolean changeCurrency(String newcurr){
        String[] currencyBank = {"USD", "CAD", "YUAN"};
        for (String currency: currencyBank){
            if (currency.equals(newcurr)){
                this.currency = newcurr;
                return true;
            }
        }
        return false;
    }


}
