package UseCases.UserRegister;

import ExternalInterface.UserRegistrationFailed;

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
     * @throws new ExternalInterface.UserRegistrationFailed(failMessage) in order to construct an error message with String failMessage
     */
    @Override
    public UserRegisterInputs showFailure(String failMessage) {
        throw new UserRegistrationFailed(failMessage);
    }
}
