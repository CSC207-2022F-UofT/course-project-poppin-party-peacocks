package DataBase;
import Entities.*;

import Entities.Item;
import Entities.ListOfWishlists;
import Entities.Wishlist;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import java.util.Objects.*;

public class DataBase {

    public static User currentUser;
    public static String getUserFilePath() {
        return "src/main/database/users.txt";
    }
    public static String getTempUserFilePath() {
        return "src/main/database/tempusers.txt";
    }
    public static String getWishlistPath(String userName) {
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
     * @returns whether user was successfully saved
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public static boolean addUser(User user) {
        File file = new File(DataBase.getUserFilePath());

        // If the file directory doesn't exist, create a new file
        if (!file.isFile()) {
            createFile(DataBase.getUserFilePath());
        }

        try {
            FileWriter fileWriter = new FileWriter(DataBase.getUserFilePath(), true);
            JSONObject userObject = new JSONObject();
            userObject.put("user", user.getName());
            userObject.put("password", user.getPassword());
            userObject.put("currency", user.getCurrency());
            fileWriter.write(userObject.toJSONString() + '\n');
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /** Deletes user from the database
     * @param userName username to delete from the database
     * @returns whether user was successfully deleted
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public static boolean deleteUser(String userName) {
        File tempUserFile = new File(getTempUserFilePath());

        // If the tempUserFile directory doesn't exist, create a new tempUserFile
        if (!tempUserFile.isFile()) {
            createFile(DataBase.getTempUserFilePath());
        }

        try {
            File userFile = new File(DataBase.getUserFilePath());
            FileWriter tempUserWriter = new FileWriter(DataBase.getTempUserFilePath(), true);
            Scanner userReader = new Scanner(userFile);
            // Find the first user with the correct name
            while (userReader.hasNextLine()) {
                String data = userReader.nextLine();
                JSONParser jsonParser = new JSONParser();
                JSONObject parsedData = (JSONObject) jsonParser.parse(data);
                if (!(Objects.equals(parsedData.get("user").toString(), userName))) {
                    tempUserWriter.write(parsedData.toJSONString());
                }
            }
            userReader.close();
            tempUserWriter.close();
            userFile.delete();
            return tempUserFile.renameTo(userFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    /** Retrieves and returns a Entities.User object based on name
     * @param name Unique name of the user
     * @returns user
     * */
    public static User getUser(String name) {
        try {
            File userFile = new File(DataBase.getUserFilePath());
            Scanner userReader = new Scanner(userFile);
            // Find the first user with the correct name
            while (userReader.hasNextLine()) {
                String data = userReader.nextLine();
                JSONParser jsonParser = new JSONParser();
                JSONObject parsedData = (JSONObject) jsonParser.parse(data);
                if (Objects.equals(parsedData.get("user").toString(), name)) {
                    String userName = (String) parsedData.get("user");
                    String password = (String) parsedData.get("password");
                    String currency = (String) parsedData.get("currency");
                    User newUser = new User(userName, password, currency);
                    currentUser = newUser;
                    return newUser;
                }
            }
            userReader.close();
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
     * @returns item in json format
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public static JSONObject createItemJSON(Item item) {
        JSONObject itemObject = new JSONObject();
        itemObject.put("itemName", item.getItemName());
        itemObject.put("url", item.getItemURL());
        itemObject.put("itemDescription", item.getItemDescription());
        JSONArray tagsObject = new JSONArray();
        tagsObject.addAll(Arrays.asList(item.getTags()));
        itemObject.put("tags", tagsObject);
        itemObject.put("itemPrice", item.getItemPrice());
        itemObject.put("priceChange", item.getPriceChange());
        itemObject.put("desiredPrice", item.getItemDesiredPrice());
        itemObject.put("dateAdded", item.getItemDateAdded().toString());
        itemObject.put("reviewStars", item.getReviewStars());
        itemObject.put("reviewCount", item.getReviewCount());
        itemObject.put("imageURL", item.getItemImageURL());

        JSONArray historyDateObject = new JSONArray();
        for (Date date : item.getPriceHistoryDates()) {
            historyDateObject.add(date.toString());
        }
        JSONArray historyDataObject = new JSONArray();
        tagsObject.addAll(Arrays.asList(item.getPriceHistoryData()));

        itemObject.put("historyDate", historyDateObject);
        itemObject.put("historyData", historyDataObject);
        itemObject.put("currency", item.getItemCurrency());

        return itemObject;

    }

    /** Creates a wishlist in JSON format
     * @param wishlist wishlist to convert to json format
     * @returns wishlist in json format
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public static JSONObject createWishlistJSON(Wishlist wishlist) {
        JSONObject wishlistObject = new JSONObject();
        wishlistObject.put("name", wishlist.getName());
        wishlistObject.put("dateAdded", wishlist.getDateAdded().toString());

        JSONArray itemObjects = new JSONArray();
        for (Item item : wishlist.getItemList()) {
            itemObjects.add(DataBase.createItemJSON(item));
        }

        JSONArray displayedListObject = new JSONArray();
        for (Item item : wishlist.getDisplayedList()) {
            displayedListObject.add(DataBase.createItemJSON(item));
        }

        JSONArray selectedTagsObject = new JSONArray();
        selectedTagsObject.addAll(wishlist.getSelectedTags());
        wishlistObject.put("itemList", itemObjects);
        wishlistObject.put("displayedList", displayedListObject);
        wishlistObject.put("selectedTags", selectedTagsObject);

        return wishlistObject;
    }

    /** Adds a list of wishlists data to a user's database
     * @param listOfWishlists list of wishlists data to add to database
     * @param user user of the data it belongs to
     * @returns whether wishlist was successfully saved
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
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

            for (Wishlist wishlist : listOfWishlists.getListOfWishlist()) {
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


    /** Retrieves and returns a list of wishlist object based on name
     * @param userName Unique name of the user
     * @returns list of wishlists
     * */
    public static ListOfWishlists getListOfWishlists(String userName) {
        try {
            File myObj = new File(DataBase.getWishlistPath(userName));
            Scanner myReader = new Scanner(myObj);
            // Find the first user with the correct name
            if (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                JSONParser jsonParser = new JSONParser();
                JSONObject parsedData = (JSONObject) jsonParser.parse(data);
                JSONArray wishlistsObject = (JSONArray) parsedData.get("wishlists");
                ArrayList<Wishlist> wishlists = new ArrayList<>();

                if (!Objects.isNull(wishlistsObject)) {
                    for (Object wishlist : wishlistsObject) {
                        wishlists.add(DataBase.parseWishlist(wishlist));
                    }
                }
                return new ListOfWishlists(wishlists);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred file not found.");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("An error occurred failed to parse user data." + e);
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
        // Return a default wishlist if wishlist does not exist
        return new ListOfWishlists();
    }

    /** Parses a wishlist in JSON format
     * @param wishlistObject wishlist to convert to wish list object
     * @return wishlist object
     * */
    public static Wishlist parseWishlist(Object wishlistObject) throws java.text.ParseException {
        JSONObject wishlistData = (JSONObject) wishlistObject;

        String name = (String) wishlistData.get("name");

        Date dateAdded = new Date(wishlistData.get("dateAdded").toString());

        ArrayList<Item> items = new ArrayList<>();
        JSONArray itemsObjects = (JSONArray) wishlistData.get("itemList");
        if (!Objects.isNull(itemsObjects)) {
            for (Object itemObject : itemsObjects) {
                items.add(DataBase.parseItem(itemObject));
            }
        }

        ArrayList<Item> displayedItems = new ArrayList<>();
        JSONArray itemObjects = (JSONArray) wishlistData.get("displayedList");
        if (!Objects.isNull(itemObjects)) {
            for (Object itemObject : (JSONArray) wishlistData.get("displayedList")) {
                displayedItems.add(DataBase.parseItem(itemObject));
            }
        }

        ArrayList<String> tags = new ArrayList<>();
        JSONArray tagObjects = (JSONArray) wishlistData.get("selectedTags");
        if (!Objects.isNull(tagObjects)) {
            for (Object tagObject : tagObjects) {
                tags.add(tagObject.toString());
            }
        }

        return new Wishlist(name, items, displayedItems, dateAdded, tags);
    }

    /** Parses an item in JSON format
     * @param itemObject item to parse
     * @returns item object
     * */
    public static Item parseItem(Object itemObject) throws java.text.ParseException {
        JSONObject itemData = (JSONObject) itemObject;
        String itemName = (String) itemData.get("itemName");
        String url = (String) itemData.get("url");
        String itemDescription = (String) itemData.get("itemDescription");

        Double itemPrice = (Double) itemData.get("itemPrice");
        Double priceChange = (Double) itemData.get("priceChange");
        Double desiredPrice = (Double) itemData.get("desiredPrice");

        Date dateAdded = new Date(itemData.get("dateAdded").toString());

        ArrayList<String> tags = new ArrayList<>();
        JSONArray tagsObject = (JSONArray) itemData.get("tags");
        if (!Objects.isNull(tagsObject)) {
            for (Object tag : tagsObject) {
                tags.add(tag.toString());
            }
        }

        String[] tagsArray = new String[tags.size()];
        for (int i = 0; i < tags.size(); i++) {
            tagsArray[i] = tags.get(i);
        }
        Double reviewStars = (Double) itemData.get("reviewStars");
        int reviewCount = Integer.parseInt(itemData.get("reviewCount").toString());
        String imageURL = (String) itemData.get("imageURL");

        ArrayList<Date> historyDates = new ArrayList<>();

        JSONArray historyDatesObject = (JSONArray) itemData.get("historyDate");
        if (!Objects.isNull(historyDatesObject)) {
            for (Object date : historyDatesObject) {
                historyDates.add(new Date(date.toString()));
            }
        }

        ArrayList<Double> historyData = new ArrayList<>();
        JSONArray historyDataObject = (JSONArray) itemData.get("historyData");
        if (!Objects.isNull(historyDataObject)) {
            for (Object price : historyDataObject) {
                historyData.add(Double.parseDouble(price.toString()));
            }
        }

        String currency = (String) itemData.get("currency");

        return new Item(itemName, itemPrice, desiredPrice, url, itemDescription, tagsArray, priceChange, dateAdded, reviewCount, reviewStars, imageURL, currency, historyData, historyDates);
    }
}