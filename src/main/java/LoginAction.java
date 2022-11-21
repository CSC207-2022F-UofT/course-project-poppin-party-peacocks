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
        User existingUser = DataBase.getUser(this.inputtedUsername);
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
        if (this.checkUsername()){
            User existingUser = DataBase.getUser(this.inputtedUsername);
            String existingPassword = existingUser.getPassword();
            if (existingPassword.equals(this.inputtedPassword)){
                return true;
            }
        }
        return false;
    }
}
