package UseCases.UserRegister;

import UseCases.UserRegister.UserRegisterInputs;

public interface UserRegisterStatus {
    UserRegisterInputs showSuccess(UserRegisterInputs newUser);
    UserRegisterInputs showFailure(String failMessage);
}
