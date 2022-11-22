//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//class UserRegisterTest {
//    @Test
//    public void testCreateUserSuccess() {
//        UserRegister newUser = new UserRegister("StarlightUser", "Fuzzy321", "Fuzzy321");
//        Assertions.assertTrue(newUser.create());
//    }
//
//    @Test
//    public void testCreateUserAlreadyExists(){
//        UserRegister newUser = new UserRegister("Herman1", "Fuzzy321", "Fuzzy321");
//        Assertions.assertFalse(newUser.create());
//    }
//
//    @Test
//    public void testCreatePasswordsDontMatch(){
//        UserRegister newUser = new UserRegister("Herman1", "Fuzzy321", "Fuzzy321");
//    }
//
//    @Test
//    public void testCreatePasswordTooShort(){
//
//    }
//
//    @Test
//    public void testCreateUsernameTooShort(){
//
//    }
//
//    @Test
//    public void testCreateUsernameTooLong(){
//
//    }
//
//}