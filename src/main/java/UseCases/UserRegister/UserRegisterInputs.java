package UseCases.UserRegister;
import DataBase.DataBaseController;
import Entities.User;
public class UserRegisterInputs {
    private String username;
    private String password;
    private User tempUser;

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
    public boolean checkUserExists(){
        DataBaseController dataBaseController = new DataBaseController();
        User existingUser = dataBaseController.getUser(this.getInputtedUsername());
        if (existingUser.getName() == "Default User") {
            return false;
        }
        else {
            return true;
        }
    }
}