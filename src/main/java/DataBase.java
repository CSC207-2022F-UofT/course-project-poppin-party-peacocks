import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class DataBase {

    public static String getUserFilePath() {
        return "src/main/database/users.txt";
    }

    private static String getWishlistPath(String userName) {
        return "src/main/database/" + userName + ".txt";
    }

    /** Creates a new file at the specified directory
     * @param fileDirectory File directory to create a new file at
     * */
    public static void createFile(String fileDirectory) {
        try {
            File file = new File(fileDirectory);

            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred creating file.");
            e.printStackTrace();
        }
    }

    /** Adds a new user to the database in JSON format
     * @param user user to add to the database
     * @param password password passed from user to store in the database
     * */
    public static boolean addUser(User user, String password) {
        File file = new File(DataBase.getUserFilePath());

        // If the file directory doesn't exist, create a new file
        if (!file.isFile()) {
           createFile(DataBase.getUserFilePath());
        }

        try {
            FileWriter fileWriter = new FileWriter(DataBase.getUserFilePath(), true);
            JSONObject userObject = new JSONObject();
            userObject.put("user", user.getName());
            userObject.put("password", password);
            userObject.put("currency", user.getCurrency());
            fileWriter.write(userObject.toJSONString() + '\n');
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /** Retrieves and returns a User object based on name
     * @param name Unique name of the user
     * */
    public static User getUser(String name) {
        try {
            File myObj = new File(DataBase.getUserFilePath());
            Scanner myReader = new Scanner(myObj);
            // Find the first user with the correct name
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                JSONParser jsonParser = new JSONParser();
                JSONObject parsedData = (JSONObject) jsonParser.parse(data);
                if (Objects.equals(parsedData.get("user").toString(), name)) {
                    String userName = (String) parsedData.get("user");
                    String password = (String) parsedData.get("password");
                    String currency = (String) parsedData.get("currency");
                    return new User(userName, password, currency);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred file not found.");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("An error occurred failed to parse user data.");
            e.printStackTrace();
        }
        // Return a default user if user doesn't exist
        return new User("Default User", "Password");
    }

    /** Creates an item in JSON format
     * @param item item to convert to json format
     * */
    public static JSONObject createItemJSON(Item item) {
        JSONObject itemObject = new JSONObject();
        itemObject.put("itemName", item.getItemName());
        itemObject.put("url", item.getItemURL());
        itemObject.put("itemDescription", item.getItemDescription());
        itemObject.put("tags", item.getTags());
        itemObject.put("itemPrice", item.getItemPrice());
        itemObject.put("priceChange", item.getPriceChange());
        itemObject.put("desiredPrice", item.getItemDesiredPrice());
        itemObject.put("dateAdded", item.getItemDateAdded());
        return itemObject;

    }

    /** Creates a wishlist in JSON format
     * @param wishlist wishlist to convert to json format
     * */
    public static JSONObject createWishlistJSON(Wishlist wishlist) {
        JSONObject wishlistObject = new JSONObject();
        wishlistObject.put("name", wishlist.getName());
        wishlistObject.put("dateAdded", wishlist.getDateAdded());

        JSONArray itemObjects = new JSONArray();
        for (Item item : wishlist.getItemList()) {
            itemObjects.add(DataBase.createItemJSON(item));
        }

        JSONArray displayedListObject = new JSONArray();
        for (Item item : wishlist.getDisplayedList()) {
            displayedListObject.add(DataBase.createItemJSON(item));
        }

        JSONArray selectedTagsObject = new JSONArray();
        for (String tag : wishlist.getSelectedTags()) {
            selectedTagsObject.add(tag);
        }
        wishlistObject.put("itemList", itemObjects);
        wishlistObject.put("displayedList", displayedListObject);
        wishlistObject.put("selectedTags", selectedTagsObject);

        return wishlistObject;
    }

    /** Adds a list of wishlists data to a user's database
     * @param listOfWishlists list of wishlists data to add to database
     * @param user user of the data it belongs to
     * */
    public static boolean saveListOfWishlists(ListOfWishlists listOfWishlists, User user) {
        String wishlistPath = DataBase.getWishlistPath(user.getName());
        File file = new File(wishlistPath);

        // If the file directory doesn't exist, create a new file
        if (!file.isFile()) {
            createFile(DataBase.getUserFilePath());
        }

        try {
            FileWriter fileWriter = new FileWriter(wishlistPath);
            JSONObject listOfWishlistsObject = new JSONObject();
            JSONArray wishlistsObjects = new JSONArray();

            for (Wishlist wishlist : listOfWishlists.listWishlist) {
                wishlistsObjects.add(DataBase.createWishlistJSON(wishlist));
            }
            listOfWishlistsObject.put("wishlists", wishlistsObjects);

            fileWriter.write(listOfWishlistsObject.toJSONString());
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
