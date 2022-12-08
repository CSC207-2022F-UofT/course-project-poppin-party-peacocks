package DataBase;
import Entities.User;

import java.io.*;

/** A class that file paths and management  */
public class DataBase {
    /** Field containing the current user of the program */
    public static User currentUser;

    /** A function that returns the user file path
     * @returns user file path
     * */
    public static String getUserFilePath() {
        return "src/main/database/users.txt";
    }

    /** A function that returns the temp user file path
     * @returns temp user file path
     * */
    public static String getTempUserFilePath() {
        return "src/main/database/tempusers.txt";
    }

    /** A function that returns the wishlist file path
     * @returns wishlist file path
     * */
    public static String getWishlistPath(String userName) {
        return "src/main/database/" + userName + ".txt";
    }

    /** Creates a new file at the specified directory
     * @param fileDirectory File directory to create a new file at
     * */
    public static void createFile(String fileDirectory) throws IOException {
        File file = new File(fileDirectory);

        if (file.createNewFile()) {
                System.out.println("File created!");
        }
    }
}
