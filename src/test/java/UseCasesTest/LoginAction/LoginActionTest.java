package UseCasesTest.LoginAction;

import UseCases.LoginAction.LoginAction;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class LoginActionTest {
    /**
     * Test to see if checkUsername returns True if the inputted username exists in DataBase
     */
    @Test
    public void testCheckUsernameSuccess() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("Herman1", "Password");
        Assertions.assertTrue(userInput.checkUsername());
    }

    /**
     * Test to see if checkUsername returns True if the inputted username exists in DataBase, even if the password is
     * different
     */
    @Test
    public void testCheckUsernameSuccessDifferentPassword() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("Herman1", "Password1");
        Assertions.assertTrue(userInput.checkUsername());
    }

    /**
     * Test to see if checkUsername returns False if inputted username does not exist in DataBase
     */
    @Test
    public void testCheckUsernameFail() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("TestingUserDNEName", "Password");
        Assertions.assertFalse(userInput.checkUsername());
    }

    /**
     * Test to see if checkUserMatchesPassword returns True if the inputted username and password match the record of
     * the associated User in DataBase
     */
    @Test
    public void testCheckUserMatchesPasswordSuccess() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("Herman1", "Password");
        Assertions.assertTrue(userInput.checkUserMatchesPassword());
    }

    /**
     * Test to see if checkUserMatchesPassword returns False if the inputted username and password do not match the
     * record of the associated User in DataBase
     */
    @Test
    public void testCheckUserMatchesPasswordWrongPassword() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("Herman1", "password");
        Assertions.assertFalse(userInput.checkUserMatchesPassword());
    }

    /**
     * Test to see if checkUserMatchesPassword returns True if the both inputted username and password match any record
     * on DataBase
     */
    @Test
    public void testCheckUserMatchesPasswordUserDNE() throws FileNotFoundException, ParseException {
        LoginAction userInput = new LoginAction("TestingUserDNEName", "password");
        Assertions.assertFalse(userInput.checkUserMatchesPassword());
    }
}
