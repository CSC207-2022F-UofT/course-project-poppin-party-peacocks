package ControllerTest;

import DataBase.*;
import UseCases.LoginAction.LoginAction;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import UseCases.UserRegister.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
class UserRegisterTest {

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

    @Test
    public void testUserExistsFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("Herman1","Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "User already exists, pick a new username.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testUsernameTooLongFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("Herman10000000000000000000","Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "Username is too long. Username must have at most 15 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testUsernameTooShortFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("A","Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "Username is too short. Username must have at least 3 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPasswordTooShortFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("StarlightUser1","1");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "Password is too short. Password must have at least 3 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
