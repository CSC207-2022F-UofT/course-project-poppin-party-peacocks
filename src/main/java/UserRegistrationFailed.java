public class UserRegistrationFailed extends RuntimeException{
    /**
     * Constructs a new runtime exception with message errorMessage
     */
    public UserRegistrationFailed(String errorMessage){
        super(errorMessage);
    }
}
