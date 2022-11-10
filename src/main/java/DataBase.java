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

    public static User getUser(String name) {
        try {
            File myObj = new File(DataBase.getUserFilePath());
            Scanner myReader = new Scanner(myObj);
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
        return new User("Default User", "Password");
    }
}
