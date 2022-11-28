package DataBase;

import Entities.ListOfWishlists;
import Entities.User;
import Entities.Wishlist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/** A class that helps fetches user and wishlists from the data */
public class DataBaseController {

    /** Retrieves and returns a list of wishlist object based on name
     * @param userName Unique name of the user
     * @returns list of wishlists
     * */
    public ListOfWishlists getListOfWishlists(String userName) {
        DataBaseParser dataBaseParser = new DataBaseParser();
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
                        wishlists.add(dataBaseParser.parseWishlist(wishlist));
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

    /** Retrieves and returns a Entities.User object based on name
     * @param name Unique name of the user
     * @returns user
     * */
    public User getUser(String name) {
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
                    User newUser = new User(userName, password, currency);
                    DataBase.currentUser = newUser;
                    return newUser;
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

}
