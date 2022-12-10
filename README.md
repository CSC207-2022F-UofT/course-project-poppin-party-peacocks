
## A wishlist app that keeps you updated on the items you want to buy!

### Project Description
This program is designed to allow the user to search for things on online retailer websites (currently only amazon is supported) and add items to a wishlist. The program then updates the prices of the items and notifies the user when an item is below their desired price for the item. Users can also view items in more detail along with their price data gathered over time.

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

Database - Users can create their own account which they can log back in for the app which saves their own wishlist data for future use. There can be multiple users per computer and each have their own associated wishlist data.

Notifications - Users can be notified with a red border around their item if the desired price they want their item to be is higher than the current sale price. 
They will also be notified if an item is on sale (cheaper than the time they added the item). The user must go back to the item page and refresh to see the changes.

## Planned features for future development
support for other online retailers

### How to run the project (Methods)

1. Clone the project on Intellij IDEA and run mainApp.java.
2. There is a .jar file in the src folder. To run the project, download the .jar file and run it with Java. (NOTE: the jar is currently broken and will not be fixed before the presentation)

### Sample Use Case (Making a new account, creating a new wishlist, searching for an Amazon product, adding it to the wishlist, viewing product details)
1. Launch the application
2. (Currently on Welcome Page): Click "Sign Up" at the bottom right of the screen.
3. Enter the required information and click large "Sign Up" button.
4. (Currently on Welcome page): Click "Log in" at the bottom left of the screen and log in with your newly created account
5. (Currently on Home Page): Click on the "+" button at the bottom of the screen to add a new wishlist.
6. (Currently on Add Wishlist Page): A window will open, prompting the user to enter a name for the new wishlist. Click the add button and the new wishlist will be opened
7. (Currently on a Wishlist Page): Click the "+" button at the bottom right of the screen to search for a new item.
8. (Currently on the Item Search Page): In the text bar on the top of the page, enter a desired keyword and click the "Go" Button (example: "mechanical keyboard"), or paste an amazon URL of a specific item you want to add to the wishlist.
9. If searching via a keyword, wait up to 70 seconds for the search results to appear on screen. If searching via URL, the search result will appear on screen after a few seconds.
10. Select the item you want to add by clicking on it in the displayed list and click the "Add Selected" button at the bottom of the window.
11. (Currently on the Wishlist Page): Click on the item in the list and click on the "->" button at the bottom of the screen to view the item's details
12. (Currently on the Item Page): Here, the user can view the details of the item by scrolling the green panel. The user can also click on the details button at the bottom of the screen to view price history details.

### Testing Coverage 
Link to drive: https://drive.google.com/drive/folders/1vBOrXq9PS0V2Lgpx0BiFhdVVPZ0tIobO?usp=sharing
![image](https://user-images.githubusercontent.com/33236708/206597408-60bb1d4d-36ff-4e6b-8608-adabddd37b35.png)

Note: Some tests fail with autograder, but work on some of our member's local machines. For user tests, Lina's machine runs it perfectly. For Database tests, Herman's machine runs it perfectly.

