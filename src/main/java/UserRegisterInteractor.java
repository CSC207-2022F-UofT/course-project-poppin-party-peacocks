public class UserRegisterInteractor{
    private String username;
    private String password;
    private String repeatedPassword;
    private LoginAction tempLogin;
    private User newUser;

    public UserRegisterInteractor(String username, String password, String repeatedPassword) {
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.tempLogin = new LoginAction(username, password);
        this.newUser = new User(username, password);
    }

    public boolean create(User newLogin) {
        if (!this.password.equals(this.repeatedPassword)){
            return false;
        }

        else if (this.tempLogin.checkUsername() == true){
            return false;
        }

        else if (this.username.length() < 3){
            return false;
        }

        else if (this.password.length() < 3){
            return false;
        }

        DataBase.addUser(this.newUser, this.password);
        return true;
    }
}
