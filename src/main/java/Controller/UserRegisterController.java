package Controller;
import UseCases.UserRegister.*;

/**
 * An interface adapter class that receives the request to create a user and adapts the user's inputs in order to
 * create a new user in the system
 */

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
