import javax.xml.crypto.Data;

public class UserRegisterInteractor implements UserRegisterDatabaseInput{

//    private UserRegisterInput inputs;
    private String username;
    private String password;
    private String repeatedPassword;
    private UserRegisterDataBaseGateway dataBaseGateway;

    public UserRegisterInteractor(String username, String password, String repeatedPassword) {
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.dataBaseGateway = new UserRegisterDataBaseGateway(username, password);
    }


    @Override
    public boolean create(UserRegisterDataBaseGateway inputUser) {
        if (!this.password.equals(this.repeatedPassword)){
            return false;
        }
        if (this.dataBaseGateway.existingUser(this.username) == true){
            return false;
        }

        this.dataBaseGateway.save();
        return true;
    }
}
