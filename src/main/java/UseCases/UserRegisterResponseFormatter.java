package UseCases;
import Presenters.UserRegistrationFailed;

public class UserRegisterResponseFormatter implements UserRegisterStatus {

    /**
     * Returns the inputs made by the user in order to add user into DataBase
     * screens layer of clean architecture
     * @param newUser input information made by the user
     * @return newUser
     */
    @Override
    public UserRegisterInputs showSuccess(UserRegisterInputs newUser) {
        return newUser;
    }

    /**
     * Shows fail message by calling Presenters.UserRegistrationFailed
     * @param failMessage String describing fail message
     * @throws new Presenters.UserRegistrationFailed(failMessage) in order to construct an error message with String failMessage
     */
    @Override
    public UserRegisterInputs showFailure(String failMessage) {
        throw new UserRegistrationFailed(failMessage);
    }
}
