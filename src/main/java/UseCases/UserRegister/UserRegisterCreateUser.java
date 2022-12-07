package UseCases.UserRegister;

import org.json.simple.parser.ParseException;
import java.io.IOException;

/**
 * An interface to define a "create" functionality for classes to create a UserRegisterInputs
 */
public interface UserRegisterCreateUser {
    UserRegisterInputs create(UserRegisterInputs inputs) throws IOException, ParseException;
}
