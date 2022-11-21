public class UserRegisterDataBaseGateway implements UserRegisterCreation{
    private User newUser;
    private String password;
    private String username;
    private LoginAction tempLoginAction;

    public UserRegisterDataBaseGateway(String username, String password){
        this.newUser = new User(username, password);
        this.username = username;
        this.password = password;
        this.tempLoginAction = new LoginAction(username, password);
    }

    public User getNewUser(){
        return this.newUser;
    }

    @Override
    public boolean existingUser(String username) {
        if (this.tempLoginAction.checkUsername() == true){
            return true;
        }
        return false;
    }

    @Override
    public void save() {
        DataBase.addUser(this.newUser, this.password);
    }
}
