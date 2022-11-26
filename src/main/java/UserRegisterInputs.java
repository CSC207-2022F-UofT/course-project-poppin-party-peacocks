import Entities.User;
public class UserRegisterInputs {
    private String username;
    private String password;
    private String repeatedPassword;
    private User tempUser;

    public UserRegisterInputs(String username, String password, String repeatedPassword) {
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
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
     * @return Inputted repeatedPassword of user
     */
    public String getRepeatedPassword(){
        return this.repeatedPassword;
    }

    /**
     * @return The registration information of user as object User
     */
    public User getTempUser(){
        return this.tempUser;
    }

    /**
     * Utilizes LoginAction's checkUsername function to check if tempUser exists in DataBase.
     * @return True if tempUser exists in DataBase
     */
    public boolean checkUserExists(){
        LoginAction tempLogin = new LoginAction(this.username, this.password);
        return tempLogin.checkUsername();
    }
}
