public class UserRegister implements UserRegisterCreateUser{
    final UserRegisterResponseFormatter responseFormatter;
    final UserRegisterStatus status;
    private UserRegisterInputs inputs;

    public UserRegister(UserRegisterInputs inputs, UserRegisterResponseFormatter responseFormatter, UserRegisterStatus status){
        this.inputs = inputs;
        this.responseFormatter = responseFormatter;
        this.status = status;
    }

    @Override
    public UserRegisterInputs create(UserRegisterInputs inputs){
        if (this.inputs.checkUserExists()){
            return status.showFailure("User already exists, pick a new username.");
        } else if (!this.inputs.getInputtedPassword().equals(this.inputs.getRepeatedPassword())) {
            return status.showFailure("Passwords don't match.");
        } else if (this.inputs.getInputtedUsername().length() < 3) {
            return status.showFailure("Username is too short. Username must have at least 3 characters.");
        } else if (this.inputs.getInputtedUsername().length() > 8) {
            return status.showFailure("Username is too long. Username must have at most 8 characters.");
        } else if (this.inputs.getInputtedPassword().length() < 3) {
            return status.showFailure("Password is too short. Password must have at least 3 characters.");
        }
        DataBase.addUser(this.inputs.getTempUser(), this.inputs.getInputtedPassword());
        return status.showSuccess(inputs);
    }
}
