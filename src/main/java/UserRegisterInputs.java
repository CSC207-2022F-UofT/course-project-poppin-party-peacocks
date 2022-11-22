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

    public String getInputtedUsername(){
        return this.username;
    }

    public String getInputtedPassword(){
        return this.password;
    }

    public String getRepeatedPassword(){
        return this.repeatedPassword;
    }

    public User getTempUser(){
        return this.tempUser;
    }

    public boolean checkUserExists(){
        LoginAction tempLogin = new LoginAction(this.username, this.password);
        return tempLogin.checkUsername();
    }
}
