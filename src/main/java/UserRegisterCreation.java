public interface UserRegisterCreation {
    boolean existingUser(String username);

    void save();
}
