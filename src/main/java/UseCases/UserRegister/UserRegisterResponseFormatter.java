package UseCases.UserRegister;

import ExternalInterface.UserRegistrationFailed;

/**
 * A use case class that implements the UserRegisterStatus interface to format UserRegisterInputs into a new user in
 * the system if it meets the requirements
 */
public class UserRegisterResponseFormatter implements UserRegisterStatus {

    /**
     * Returns the inputs made by the user in order to add user into DataBase
     * @param newUser input information made by the user
     * @return newUser
     */
    @Override
    public UserRegisterInputs showSuccess(UserRegisterInputs newUser) {
        return newUser;
    }

    /**
     * Shows fail message by calling ExternalInterface.UserRegistrationFailed
     * @param failMessage String describing fail message
     * @throws ExternalInterface.UserRegistrationFailed in order to construct an error message with String failMessage
     */
    @Override
    public UserRegisterInputs showFailure(String failMessage) {
        throw new UserRegistrationFailed(failMessage);
    }
}
