package Presenters;

public class UserRegistrationFailed extends RuntimeException{
    /**
     * Constructs a new runtime exception with message errorMessage
     * @param errorMessage String to display if the user was not able to be created
     */
    public UserRegistrationFailed(String errorMessage){
        super(errorMessage);
    }
}
