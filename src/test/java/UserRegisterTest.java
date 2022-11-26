import DataBase.DataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
class UserRegisterTest {

    @Test
    public void testCreateUserSuccess() {
        UserRegisterInputs inputs = new UserRegisterInputs("StarlightUser","Fuzzy321", "Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(inputs, formatter);
        register.create(inputs);
        Assertions.assertEquals(inputs.getTempUser().getName(), DataBase.getUser("StarlightUser").getName());
        DataBase.deleteUser("StarlightUser");
    }

    @Test
    public void testLoginNewUserSuccess() {
        UserRegisterInputs inputs = new UserRegisterInputs("StarlightUser","Fuzzy321", "Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(inputs, formatter);
        register.create(inputs);
        LoginAction userInput = new LoginAction("StarlightUser", "Fuzzy321");
        Assertions.assertTrue(userInput.checkUserMatchesPassword());
        DataBase.deleteUser("StarlightUser");
    }

    @Test
    public void testUserExistsFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("Herman1","Fuzzy321", "Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(inputs, formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "User already exists, pick a new username.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testUsernameTooLongFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("Herman10000000000000000000","Fuzzy321", "Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(inputs, formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "Username is too long. Username must have at most 15 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testUsernameTooShortFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("A","Fuzzy321", "Fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(inputs, formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "Username is too short. Username must have at least 3 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPasswordTooShortFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("StarlightUser1","1", "1");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(inputs, formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "Password is too short. Password must have at least 3 characters.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPasswordsDontMatchFail(){
        UserRegisterInputs inputs = new UserRegisterInputs("StarlightUser3","Fuzzy321", "fuzzy321");
        UserRegisterResponseFormatter formatter = new UserRegisterResponseFormatter();
        UserRegister register = new UserRegister(inputs, formatter);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            register.create(inputs);
        });

        String expectedMessage = "Passwords don't match.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }



}
