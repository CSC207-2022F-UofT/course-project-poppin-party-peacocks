public interface UserRegisterStatus {
    UserRegisterInputs showSuccess(UserRegisterInputs newUser);
    UserRegisterInputs showFailure(String failMessage);
}
