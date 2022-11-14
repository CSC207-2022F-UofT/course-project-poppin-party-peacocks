public class main {
    public static void main(String[] args) {

        Item keyboard = new Item("Keyboard", 300.1, 250.0, "www.amazon.com/keyboard",
                "Description from amazon (or you write your own)", new String[] {"computer accesssories", "Tech", "Mechanical"});
        Item monitor = new Item("Monitor", 120.99, 85.00, "www.amazon.com/monitor",
                "second monitor dab", new String[] {"computer accesssories", "Tech", "IPS"});
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", new String[] {"toys"});

        Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");

        // add items keyboard, monitor, plushie as test and displaying them
        System.out.println(christmasWishlist.addItem(keyboard));
        System.out.println(christmasWishlist.addItem(monitor));
        System.out.println(christmasWishlist.addItem(plushie));
        christmasWishlist.displayList();

        //filtering wishlist by tag: "Tech"
        //christmasWishlist.filterWishlists(new String[] {"Tech"});
        //christmasWishlist.displayList();

        //sorting wishlist by price
        //christmasWishlist.sortWishlistByPrice("ascending");
        //christmasWishlist.sortWishlistByPrice("descending");
        //christmasWishlist.sortWishlistByPrice("");
        //christmasWishlist.displayList();

        //sorting wishlist by name
        //christmasWishlist.sortWishlistByName("ascending");
        //christmasWishlist.sortWishlistByName("descending");
        //christmasWishlist.sortWishlistByName("");
        //christmasWishlist.displayList();
    }
}
