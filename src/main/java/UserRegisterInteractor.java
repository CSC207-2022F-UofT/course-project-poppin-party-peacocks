public class UserRegisterInteractor implements UserRegistry {
    private String inputtedUsername;
    private String inputtedPassword;

    public UserRegisterInteractor(){

    }

    @Override
    public UserRegisterObtainInputs create(UserRegisterObtainInputs responses) {
        // Check if inputted username already exists in DataBase
        return responses;
    }
}
