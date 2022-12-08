package ControllerTest;

import Controller.UserRegisterController;
import DataBase.DataBaseController;
import UseCases.LoginAction.LoginAction;
import UseCases.UserRegister.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegisterControllerTest {
    UserRegisterStatus presenter = new UserRegisterResponseFormatter();
    UserRegisterCreateUser interactor = new UserRegister(presenter);
    UserRegisterController userRegisterController = new UserRegisterController(
            interactor
    );
    DataBaseController dataBaseController = new DataBaseController();

    @Test
    public void testControllerRegisterSuccess() throws IOException, ParseException {
        userRegisterController.create("StarlightUser", "Fuzzy321");
        Assertions.assertEquals("StarlightUser", dataBaseController.getUser("StarlightUser").getName());
        dataBaseController.deleteUser("StarlightUser");
    }

    @Test
    public void testControllerLoginNewUserSuccess() throws IOException, ParseException {
        userRegisterController.create("StarlightUser", "Fuzzy321");
        LoginAction userInput = new LoginAction("StarlightUser", "Fuzzy321");
        Assertions.assertTrue(userInput.checkUserMatchesPassword());
        dataBaseController.deleteUser("StarlightUser");
    }

    @Test
    public void testControllerUserExistsFail() {
        Exception exception = assertThrows(RuntimeException.class, () ->
                userRegisterController.create("Herman1","Fuzzy321"));
        String expectedMessage = "User already exists, pick a new username.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testControllerUsernameTooLongFail(){
        Exception exception = assertThrows(RuntimeException.class, () ->
                userRegisterController.create("Herman10000000000000000000","Fuzzy321"));

        String expectedMessage = "Username is too long. Username must have at most 15 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testControllerUsernameTooShortFail(){
        Exception exception = assertThrows(RuntimeException.class, () ->
                userRegisterController.create("A","Fuzzy321"));

        String expectedMessage = "Username is too short. Username must have at least 3 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPasswordTooShortFail(){
        Exception exception = assertThrows(RuntimeException.class, () ->
                userRegisterController.create("StarlightUser1","1"));

        String expectedMessage = "Password is too short. Password must have at least 3 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
