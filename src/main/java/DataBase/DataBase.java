package DataBase;
import Entities.*;

import Entities.ListOfWishlists;
import Entities.Wishlist;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

/** A class that manages user and wishlist read and write to files */
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


    /** Deletes user from the database
     * @param userName username to delete from the database
     * @returns whether user was successfully deleted
     * */
    // JSONArray's library has errors, can ignore
    @SuppressWarnings("unchecked")
    public static boolean deleteUser(String userName) throws IOException {
        File tempUserFile = new File(getTempUserFilePath());
        File userFile = new File(getUserFilePath());
        // If the tempUserFile directory doesn't exist, create a new tempUserFile
        if (!tempUserFile.isFile()) {
            createFile(DataBase.getTempUserFilePath());
        }

        if (!userFile.isFile()) {
            createFile(DataBase.getUserFilePath());
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
            userFile.delete();
            return tempUserFile.renameTo(userFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}