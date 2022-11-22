public class UserCreationFailed extends RuntimeException{
    public UserCreationFailed(String errorMessage){
        super(errorMessage);
    }
}
