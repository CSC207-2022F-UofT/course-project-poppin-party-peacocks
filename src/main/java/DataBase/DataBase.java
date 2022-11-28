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
        File userFile = new File(getUserFilePath());
        // If the tempUserFile directory doesn't exist, create a new tempUserFile
        if (!tempUserFile.isFile()) {
            createFile(DataBase.getTempUserFilePath());
        }

        try {
            FileWriter tempUserWriter = new FileWriter(DataBase.getTempUserFilePath(), true);
            Scanner userReader = new Scanner(userFile);
            // Find the first user with the correct name
            while (userReader.hasNextLine()) {
                String data = userReader.nextLine();
                JSONParser jsonParser = new JSONParser();
                JSONObject parsedData = (JSONObject) jsonParser.parse(data);
                if (!(Objects.equals(parsedData.get("user").toString(), userName))) {
                    tempUserWriter.write(parsedData.toJSONString()+ '\n');
                }
            }
            userReader.close();
            tempUserWriter.close();
            userFile.delete();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /** Adds a list of wishlists data to a user's database
     * @param listOfWishlists list of wishlists data to add to database
     * @param user user of the data it belongs to
     * @returns whether wishlist was successfully saved
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public static boolean saveListOfWishlists(ListOfWishlists listOfWishlists, User user) {
        DataBaseFormatter dataBaseFormatter = new DataBaseFormatter();
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
                wishlistsObjects.add(dataBaseFormatter.createWishlistJSON(wishlist));
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