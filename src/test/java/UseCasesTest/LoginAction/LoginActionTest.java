package UseCasesTest.LoginAction;

import UseCases.LoginAction.LoginAction;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class LoginActionTest {
    @Test
    public void testCheckUsernameSuccess() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("Herman1", "Password");
        Assertions.assertTrue(userInput.checkUsername());
    }

    @Test
    public void testCheckUsernameSuccessDifferentPassword() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("Herman1", "Password1");
        Assertions.assertTrue(userInput.checkUsername());
    }

    @Test
    public void testCheckUsernameFail() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("TestingUserDNEName", "Password");
        Assertions.assertFalse(userInput.checkUsername());
    }

    @Test
    public void testCheckUserMatchesPasswordSuccess() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("Herman1", "Password");
        Assertions.assertTrue(userInput.checkUserMatchesPassword());
    }

    @Test
    public void testCheckUserMatchesPasswordWrongPassword() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("Herman1", "password");
        Assertions.assertFalse(userInput.checkUserMatchesPassword());
    }

    @Test
    public void testCheckUserMatchesPasswordUserDNE() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("TestingUserDNEName", "password");
        Assertions.assertFalse(userInput.checkUserMatchesPassword());
    }
}
