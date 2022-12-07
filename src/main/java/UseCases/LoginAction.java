package UseCases;

import DataBase.*;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import Entities.*;
import java.util.Objects;

public class LoginAction {
    private final String inputtedUsername;
    private final String inputtedPassword;

    public LoginAction(String username, String password) {
        this.inputtedUsername = username;
        this.inputtedPassword = password;
    }

    /**
     * Checks whether inputtedUsername exists in DataBase
     *
     * @return True if inputtedUsername exists in DataBase
     */
    public boolean checkUsername() throws FileNotFoundException, ParseException {
        DataBaseController dataBaseController = new DataBaseController();
        User existingUser = dataBaseController.getUser(this.inputtedUsername);
        if (existingUser.getName() == "Default User") {
            return false;
        }
        return true;
    }

    /**
     * Uses checkUsername function to check if inputtedUsername exists in DataBase and if it does, checks if
     * inputtedPassword matches the password of existingUser
     *
     * @return True if inputtedUsername exists in DataBase and inputtedPassword matches existingPassword
     */
    public boolean checkUserMatchesPassword() throws FileNotFoundException, ParseException {
        DataBaseController dataBaseController = new DataBaseController();
        if (this.checkUsername()) {
            User existingUser = dataBaseController.getUser(this.inputtedUsername);
            String existingPassword = existingUser.getPassword();
            return existingPassword.equals(this.inputtedPassword);
        }
        return false;
    }
}
