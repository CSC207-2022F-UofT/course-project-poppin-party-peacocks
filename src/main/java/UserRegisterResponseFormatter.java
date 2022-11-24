public class UserRegisterResponseFormatter implements UserRegisterStatus{


    @Override
    public UserRegisterInputs showSuccess(UserRegisterInputs newUser) {
        return newUser;
    }

    /**
     * Shows fail message by calling UserRegistrationFailed
     */
    @Override
    public UserRegisterInputs showFailure(String failMessage) {
        throw new UserRegistrationFailed(failMessage);
    }
}
