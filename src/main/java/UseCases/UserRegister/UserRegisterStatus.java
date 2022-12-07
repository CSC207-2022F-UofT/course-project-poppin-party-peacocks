package UseCases.UserRegister;

/**
 * An interface to define the functionality of successes and failures of creating a new user
 */
public interface UserRegisterStatus {
    UserRegisterInputs showSuccess(UserRegisterInputs newUser);
    UserRegisterInputs showFailure(String failMessage);
}
