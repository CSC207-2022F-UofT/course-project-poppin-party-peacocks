public class UserRegisterObtainInputs {

    private String inputtedUsername;
    private String inputtedPassword;
    private User newUser;

    public UserRegisterObtainInputs(String username, String password){
        this.inputtedPassword = password;
        this.inputtedUsername = username;
        this.newUser = new User(this.inputtedUsername, this.inputtedPassword);
    }

    public User getTempUser(){
        return this.newUser;
    }

    public String getInputtedUsername(){
        return this.inputtedUsername;
    }

    public String getInputtedPassword(){
        return this.inputtedPassword;
    }
}
