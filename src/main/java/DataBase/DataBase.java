package DataBase;
import Entities.User;

import java.io.*;

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
    public static void createFile(String fileDirectory) throws IOException {
        File file = new File(fileDirectory);

        if (file.createNewFile()) {
                System.out.println("File created!");
        }

    }
}