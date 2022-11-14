public class LoginAction {
    private DataBase wishlistDatabase;
//    private String username;
//    private String password;

    public LoginAction(DataBase wishlistDatabase){
        this.wishlistDatabase = wishlistDatabase;
//        this.username = username;
//        this.password = password;
    }

    // check if the user exists in wishlist DataBase

    public boolean checkUsername(String username) {
        User user = this.wishlistDatabase.getUser(username);
        if (user.getName() == "Default User") {
            return false;
        }
        else {
            return true;
        }
    }

    // check if password inputted
    public boolean checkUserMatchesPassword(String username, String password){
        if (checkUsername(username)){
            User user = this.wishlistDatabase.getUser(username);
            if (user.getPassword() == password){
                return true;
            }
        }
        return false;
    }
}
