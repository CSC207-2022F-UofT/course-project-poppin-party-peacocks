public class main {
    public static void main(String[] args) {

        Item keyboard = new Item("Keyboard", 300.1, 250.0, "www.amazon.com/keyboard",
                "Description from amazon (or you write your own)", new String[] {"computer accesssories", "Tech", "Mechanical"},
                619, 4.2);
        Item monitor = new Item("Monitor", 120.99, 85.00, "www.amazon.com/monitor",
                "second monitor dab", new String[] {"computer accesssories", "Tech", "IPS"}, 6, 0.6);
        Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
                "Description from amazon (or you write your own)", new String[] {"toys"}, 50, 4.5);

        Wishlist christmasWishlist = new Wishlist("Christmas Wishlist");

        // add items keyboard, monitor, plushie as test and displaying them
        System.out.println(christmasWishlist.addItem(keyboard));
        System.out.println(christmasWishlist.addItem(monitor));
        System.out.println(christmasWishlist.addItem(plushie));
        christmasWishlist.displayList();

        //filtering wishlist by tag: "Tech"
//        christmasWishlist.filterWishlists(new String[] {"Tech"});
//        christmasWishlist.displayList();
    }
}
