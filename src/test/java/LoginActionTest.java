import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginActionTest {
    @Test
    public void testCheckUsernameSuccess(){
        LoginAction userInput = new LoginAction("Herman1", "Password");
        Assertions.assertTrue(userInput.checkUsername());
    }

    @Test
    public void testCheckUsernameSuccessDifferentPassword(){
        LoginAction userInput = new LoginAction("Herman1", "Password1");
        Assertions.assertTrue(userInput.checkUsername());
    }

    @Test
    public void testCheckUsernameFail(){
        LoginAction userInput = new LoginAction("TestingUserDNEName", "Password");
        Assertions.assertFalse(userInput.checkUsername());
    }

    @Test
    public void testCheckUserMatchesPasswordSuccess(){
        LoginAction userInput = new LoginAction("Herman1", "Password");
        Assertions.assertTrue(userInput.checkUserMatchesPassword());
    }

    @Test
    public void testCheckUserMatchesPasswordWrongPassword(){
        LoginAction userInput = new LoginAction("Herman1", "password");
        Assertions.assertFalse(userInput.checkUserMatchesPassword());
    }

    @Test
    public void testCheckUserMatchesPasswordUserDNE(){
        LoginAction userInput = new LoginAction("TestingUserDNEName", "password");
        Assertions.assertFalse(userInput.checkUserMatchesPassword());
    }
}
