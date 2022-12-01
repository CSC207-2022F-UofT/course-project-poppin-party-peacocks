import DataBase.*;
import Entities.*;
public class LoginAction {
    private String inputtedUsername;
    private String inputtedPassword;

    public LoginAction(String username, String password){
        this.inputtedUsername = username;
        this.inputtedPassword = password;
    }

    /**
     * Checks whether inputtedUsername exists in DataBase
     * @return True if inputtedUsername exists in DataBase
     */
    public boolean checkUsername() {
        DataBaseController dataBaseController = new DataBaseController();
        User existingUser = dataBaseController.getUser(this.inputtedUsername);
        if (existingUser.getName() == "Default User") {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Uses checkUsername function to check if inputtedUsername exists in DataBase and if it does, checks if
     * inputtedPassword matches the password of existingUser
     * @return True if inputtedUsername exists in DataBase and inputtedPassword matches existingPassword
     */
    public boolean checkUserMatchesPassword(){
        DataBaseController dataBaseController = new DataBaseController();
        if (this.checkUsername()){
            User existingUser = dataBaseController.getUser(this.inputtedUsername);
            String existingPassword = existingUser.getPassword();
            if (existingPassword.equals(this.inputtedPassword)){
                return true;
            }
        }
        return false;
    }
}
