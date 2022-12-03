package data_access_storage;
import java.util.Map;

/**
 * This class decides how to interact with the database.
 * Layer:  use case
 */
public interface UserRepoManager {

    /**
     * Check whether a user with an email address email already exists.
     * @param email user's email address
     * @return return true if a user already exists with the email address email, and false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * Delete user data.
     * Call this method only if requestModel exists in our data.
     * @param requestModel the user data to be deleted.
     */
    void delete(RequestModel requestModel);

    /**
     * Delete user data whose user email address is email.
     * Call this method only if requestModel exists in our data.
     * @param email the email address of the user data to be deleted.
     */
    void delete(String email);

    /**
     * Save user data
     * @param requestModel the user data to be saved.
     */
    void save(RequestModel requestModel);

    /**
     * Update user data whose email address is email.
     * @param email the email address of the user whose account will be updated.
     * @param requestModel update user data to be requestModel
     */
    void update(String email, RequestModel requestModel);

    /**
     * Return user data whose email address is email
     * Call this method only if a user exists with the email address email
     * @param email the email address of a user
     * @return return the user data whose email address is email.
     */
    RequestModel getUserAccount(String email);

    /**
     * Get all users' account information
     * @return all users' account information
     */
    Map<String, RequestModel> getAllUserAccount();

    boolean matchingPassword(String email, String password);

}
