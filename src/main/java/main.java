import java.util.Objects;

public class main {
    public static void main(String[] args) {

        Item keyboard = new Item("Keyboard", 300.1, 250.0, "www.amazon.com/keyboard",
                "Description from amazon (or you write your own)", new String[] {"computer accesssories", "Tech", "Mechanical"});
        Item monitor = new Item("Monitor", 120.99, 85.00, "www.amazon.com/monitor",
                "second monitor dab", new String[] {"computer accesssories", "Tech", "IPS"});
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", new String[] {"toys"});

        Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");
        ListOfWishlists wishlists = new ListOfWishlists();
        wishlists.addWishlist(christmasWishlist);

        System.out.println(christmasWishlist.addItem(keyboard));
        System.out.println(christmasWishlist.addItem(monitor));
        System.out.println(christmasWishlist.addItem(plushie));

        User user = new User("Herman1", "Password");
        // user.writeUserToDatabase();
        // System.out.println(DataBase.getUser("Herman1").getName());
        DataBase.saveListOfWishlists(wishlists, user);
        System.out.println(DataBase.getListOfWishlists(user.getName()).listWishlist.get(0).getName());
    }
}
