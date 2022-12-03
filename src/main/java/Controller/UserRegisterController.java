package Controller;
import UseCases.UserRegister.*;


// role : receive the request and send the response to the user
public class UserRegisterController {
    final UserRegisterCreateUser createUserInputs;

    public UserRegisterController(UserRegisterCreateUser createUserGateway) {
        this.createUserInputs = createUserGateway;
    }

    /**
     *
     * @param username String for desired username of new user
     * @param password String for desired password of new user
     * @return UseCases.UseCases.UseCases.UserRegister.UserRegister.UserRegisterCreateUser
     */
    public UserRegisterInputs create(String username, String password){
        UserRegisterInputs userInputs = new UserRegisterInputs(username, password);

        return createUserInputs.create(userInputs);
    }


}
