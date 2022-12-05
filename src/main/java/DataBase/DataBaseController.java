package DataBase;

import Entities.ListOfWishlists;
import Entities.User;
import Entities.Wishlist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
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

    /** Adds a list of wishlists data to a user's database
     * @param listOfWishlists list of wishlists data to add to database
     * @param user user of the data it belongs to
     * @returns whether wishlist was successfully saved
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public boolean saveListOfWishlists(ListOfWishlists listOfWishlists, User user) {
        DataBaseFormatter dataBaseFormatter = new DataBaseFormatter();
        String wishlistPath = DataBase.getWishlistPath(user.getName());
        File file = new File(wishlistPath);

        // If the file directory doesn't exist, create a new file
        if (!file.isFile()) {
            DataBase.createFile(DataBase.getUserFilePath());
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

    /** Adds a new user to the database in JSON format
     * @param user user to add to the database
     * @returns whether user was successfully saved
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public boolean addUser(User user) {
        File file = new File(DataBase.getUserFilePath());

        // If the file directory doesn't exist, create a new file
        if (!file.isFile()) {
            DataBase.createFile(DataBase.getUserFilePath());
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
    public boolean deleteUser(String userName) throws IOException {
        File tempUserFile = new File(DataBase.getTempUserFilePath());
        File userFile = new File(DataBase.getUserFilePath());
        // If the tempUserFile directory doesn't exist, create a new tempUserFile
        if (!tempUserFile.isFile()) {
            DataBase.createFile(DataBase.getTempUserFilePath());
        }

        if (!userFile.isFile()) {
            DataBase.createFile(DataBase.getUserFilePath());
        }

        BufferedReader reader = new BufferedReader(new FileReader(userFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempUserFile));
        String currentLine;
        try {
            while((currentLine = reader.readLine()) != null) {
                JSONParser jsonParser = new JSONParser();
                JSONObject parsedData = (JSONObject) jsonParser.parse(currentLine);
                if (!(Objects.equals(parsedData.get("user").toString(), userName))) {
                    writer.write(parsedData.toJSONString()+ '\n');
                }

            }
            reader.close();
            writer.close();

            if (userFile.delete()) {
                System.out.println("File deleted!");
            }

            return tempUserFile.renameTo(userFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /** Retrieves the current active user
     * @returns user
     * */
    public User getCurrentUser() {
        return DataBase.currentUser;
    }
}
