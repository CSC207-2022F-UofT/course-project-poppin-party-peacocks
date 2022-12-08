package UseCasesTest.UserRegister;

import DataBase.*;
import UseCases.LoginAction.LoginAction;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;


import java.io.IOException;
import UseCases.UserRegister.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
class UserRegisterTest {
    /**
     * Test to see if UserRegister successfully creates a User into Database
     */
    @Test
    public void testCreateUserSuccess() throws IOException, ParseException {
        DataBaseController dataBaseController = new DataBaseController();
        UserRegisterInputs inputs = new UserRegisterInputs("StarlightUser","Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);
        register.create(inputs);
        Assertions.assertEquals(inputs.getTempUser().getName(), dataBaseController.getUser("StarlightUser").getName());
        dataBaseController.deleteUser("StarlightUser");
    }

    /**
     * Test to see if the new User created with UserRegister UseCase is able to log in
     */
    @Test
    public void testLoginNewUserSuccess() throws IOException, ParseException {
        DataBaseController dataBaseController = new DataBaseController();
        UserRegisterInputs inputs = new UserRegisterInputs("StarlightUser","Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);
        register.create(inputs);
        LoginAction userInput = new LoginAction("StarlightUser", "Fuzzy321");
        Assertions.assertTrue(userInput.checkUserMatchesPassword());
        dataBaseController.deleteUser("StarlightUser");
    }

    /**
     * Test to see if the user attempts to create a User with an existing user's username, the system returns the
     * appropriate message
     */
    @Test
    public void testUserExistsFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("Herman1","Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> register.create(inputs));

        String expectedMessage = "User already exists, pick a new username.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test to see if the user attempts to create a User with a username over 15 characters, the system returns the
     * appropriate message
     */
    @Test
    public void testUsernameTooLongFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("Herman10000000000000000000","Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> register.create(inputs));

        String expectedMessage = "Username is too long. Username must have at most 15 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test to see if the user attempts to create a User with a username that is under 3 characters, the system returns
     * the appropriate message
     */
    @Test
    public void testUsernameTooShortFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("A","Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> register.create(inputs));

        String expectedMessage = "Username is too short. Username must have at least 3 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test to see if the user attempts to create a password that is under 3 characters, the system returns the
     * appropriate message
     */
    @Test
    public void testPasswordTooShortFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("StarlightUser1","1");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> register.create(inputs));

        String expectedMessage = "Password is too short. Password must have at least 3 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
