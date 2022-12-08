
## A wishlist app that keeps you updated on the items you want to buy!

### Project Description
This program is designed to allow the user to search for things on online retailer websites (currently only amazon is supported) and add items to a wishlist. The program then updates the prices of the items and notifies the user when an item is below their desired price for the item.

## Currently implemented features
GUI features:
WelcomePage - where you log in or sign up

HomePage - after logging in, the user arrives at the HomePage, where all their wishlists are displayed in a list. The user can add, remove, or view a wishlist. The user can also change the currency the items use between CAD and USD. 

AddWishlistPage - when the user wants to add a wishlist, they can click on the + button in the homepage, which directs them to the addWishlistPage. There, they can enter a name for their new wishlist. Wishlists must have unique names.

WishlistPage - the user selects a wishlist to view from the homepage, which brings them to the wishlist page. There, an interactable list displays all of the items in that wishlist, which can be added to, removed from, and sorted. The user can also click the refresh button to update the prices of all the items in the wishlist.

AddItemPage - when the user wants to add an item, they click on an add button on the WishlistPage, which brings them to the addItemPage. In the addItemPage, there is a search bar in which the user inputs what they want to search, for example "Keyboard", or paste a URL of an amazon page. When a keyword is inputted, the search will display the top 10 searches fom Amazon (this can take a while, around 20 seconds). If a URL is inputted, the respective item will be displayed (this is much faster). If an invalid URL is inputted, the search will not return any items.

SortPage - from the wishlist page, the user can sort their wishlist by clicking on the sort button. Doing so will being up a smaller window, where the different sorting methods are displayed as buttons. The user can sort by item name, price, date added to the list, review stars, and review count. The user can also choose to sort the list in ascending or descending order. 

ItemPage - from the wishlist page, users can view a specific item by clicking the view item button. In the ItemPage, more details on the item is displayed.

PriceHistoryPage - from the ItemPage, users can view a detailed breakdown of an item's price history as a graph, as well as various comparisons between its current price and other metrics.

Backend features:
TODO


## Planned features for future development
support for other online retailers

### How to run the project (Methods)

1. There is a .jar file in the src folder. To run the project, download the .jar file and run it with Java.
2. Clone the project on Intellij IDEA and run main.java.

### Sample Use Case (Making a new account, creating a new wishlist, and searching for an Amazon product)
1. Launch the application
2. (Currently on Welcome Page): Click "Sign Up" at the bottom right of the screen.
3. Enter the required information and click large "Sign Up" button.
4. (Currently on the List Of Wishlists Page): Click on the "Add Wishlist" button at the bottom of the screen.
5. A window will open, prompting the user to enter a name for the new wishlist.
6. (Currently on a Wishlist Page): Click the "Add Item" button at the bottom right of the screen.
7. (Currently on the Item Search Page): At the text bar on the top of the page, enter a desired keyword and click the "Go" Button (example: "mechanical keyboard")
8. Wait up to 70 seconds for the search results to appear on screen. 
