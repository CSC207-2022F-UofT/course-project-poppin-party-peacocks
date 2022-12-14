package UseCases.UserRegister;
import DataBase.DataBaseController;
import Entities.User;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.util.Objects;

/**
 * A use case class to receive the inputted username and password from the new user
 */
public class UserRegisterInputs {
    private final String username;
    private final String password;
    private final User tempUser;

    public UserRegisterInputs(String username, String password) {
        this.username = username;
        this.password = password;
        this.tempUser = new User(username, password);
    }

    /**
     * @return Inputted username of user
     */
    public String getInputtedUsername(){
        return this.username;
    }

    /**
     * @return Inputted password of user
     */
    public String getInputtedPassword(){
        return this.password;
    }

    /**
     * @return The registration information of user as object User
     */
    public User getTempUser(){
        return this.tempUser;
    }

    /**
     * Check if tempUser exists in DataBase.
     * @return True if tempUser exists in DataBase
     */
    public boolean checkUserExists() throws FileNotFoundException, ParseException {
        DataBaseController dataBaseController = new DataBaseController();
        User existingUser = dataBaseController.getUser(this.getInputtedUsername());
        return !Objects.equals(existingUser.getName(), "Default User");
    }
}
