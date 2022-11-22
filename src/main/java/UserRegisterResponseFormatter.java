public class UserRegisterResponseFormatter implements UserRegisterStatus{


    @Override
    public UserRegisterInputs showSuccess(UserRegisterInputs newUser) {
        return newUser;
    }

    @Override
    public UserRegisterInputs showFailure(String failMessage) {
        throw new UserCreationFailed(failMessage);
    }
}
