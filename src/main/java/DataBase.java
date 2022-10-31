import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataBase {
    public static String getUserFilePath() {
        return "src/main/database/users.txt";
    }
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
        File file = new File(DataBase.getUserFilePath());

        if (!file.isFile()) {
           createFile(DataBase.getUserFilePath());
        }

        try {
            FileWriter myWriter = new FileWriter(DataBase.getUserFilePath(), true);
            String data = "user=" + user.getName() + ',' + "password=" + password;
            myWriter.write(data + '\n');
            myWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUser(String name) {
        try {
            File myObj = new File(DataBase.getUserFilePath());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("user=" + name)) {
                    String userName = data.split(",")[0].split("=")[1];
                    String password = data.split(",")[1].split("=")[1];
                    return new User(userName, password);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
