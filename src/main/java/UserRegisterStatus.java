public interface UserRegisterStatus {
    /**
     * Interface to display success/failure messages to notify user if user registration was successful or not
     */
    UserRegisterInputs showSuccess(UserRegisterInputs newUser);
    UserRegisterInputs showFailure(String failMessage);
}
