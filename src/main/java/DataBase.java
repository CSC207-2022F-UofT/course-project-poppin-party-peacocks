import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class DataBase {
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);

            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred creating file.");
            e.printStackTrace();
        }
    }

    public static boolean addUser(User user, String password) {
        String userFilePath = "src/main/database/users.txt";
        File file = new File(userFilePath);

        if (!file.isFile()) {
           createFile(userFilePath);
        }

        try {
            FileWriter myWriter = new FileWriter(userFilePath, true);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("user", user.getName());
            hashMap.put("password", password);
            myWriter.write(hashMap.toString() + '\n');
            myWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
