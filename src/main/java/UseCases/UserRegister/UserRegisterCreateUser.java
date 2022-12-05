package UseCases.UserRegister;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface UserRegisterCreateUser {
    UserRegisterInputs create(UserRegisterInputs inputs) throws IOException, ParseException;
}
