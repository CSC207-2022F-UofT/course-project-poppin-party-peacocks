package UseCases;

import UseCases.UserRegisterInputs;

public interface UserRegisterStatus {
    UserRegisterInputs showSuccess(UserRegisterInputs newUser);
    UserRegisterInputs showFailure(String failMessage);
}
