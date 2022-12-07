package UseCases.UserRegister;

import DataBase.DataBaseController;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * A use case class that implements the UserRegisterCreateUser interface to create a new User in DataBase by calling
 * upon UserRegisterStatus interface
 */
public class UserRegister implements UserRegisterCreateUser {
    final UserRegisterStatus status;

    public UserRegister(UserRegisterStatus status){
        this.status = status;
    }

    /**
     * Checks whether inputtedUsername exists in DataBase
     * @param inputs desired information inputted for new user submitted by user
     * @return UseCases.UserRegisterStatus status with status failure or success, depending on if the User could be created
     */
    @Override
    public UserRegisterInputs create(UserRegisterInputs inputs) throws IOException, ParseException {
        DataBaseController dataBaseController = new DataBaseController();
        if (inputs.checkUserExists()){
            return status.showFailure("User already exists, pick a new username.");
        } else if (inputs.getInputtedUsername().length() < 3) {
            return status.showFailure("Username is too short. Username must have at least 3 characters.");
        } else if (inputs.getInputtedUsername().length() > 15) {
            return status.showFailure("Username is too long. Username must have at most 15 characters.");
        } else if (inputs.getInputtedPassword().length() < 3) {
            return status.showFailure("Password is too short. Password must have at least 3 characters.");
        }
        dataBaseController.addUser(inputs.getTempUser());
        return status.showSuccess(inputs);
    }
}
