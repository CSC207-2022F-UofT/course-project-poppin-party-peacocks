package Controller;
import UseCases.UserRegister.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;


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
    public UserRegisterInputs create(String username, String password) throws IOException, ParseException {
        UserRegisterInputs userInputs = new UserRegisterInputs(username, password);

        return createUserInputs.create(userInputs);
    }


}
