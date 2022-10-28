//test
public class User {

    private String currency;
    private String name;
    private String password;

    private ListOfWishlists wishlists;
    private static final String[] currencyBank = {"USD", "CAD", "YUAN"};


    public User(String name, String password){
        this.name = name;
        this.password = password;
        this.currency = "CAD";
        wishlists = new ListOfWishlists();
    }


    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

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
