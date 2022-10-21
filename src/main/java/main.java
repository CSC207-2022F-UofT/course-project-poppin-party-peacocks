public class main {
    public static void main(String[] args) {

        Item keyboard = new Item("Keyboard", 300.1, "www.amazon.com/keyboard");

        Wishlist christmasWishlist = new Wishlist("Christmas");


        System.out.println(christmasWishlist.addItem(keyboard));


    }
}
