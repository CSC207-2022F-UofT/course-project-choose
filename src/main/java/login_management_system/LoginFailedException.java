package login_management_system;
public class LoginFailedException extends RuntimeException{
    String error;

    /**
     * Create a exception that is thrown whenever login failed.
     * @param error the error message that occurs when login failed.
     */
    public LoginFailedException(String error){
        super(error);
        this.error = error;
    }

    /**
     * Get this error's message.
     * @return Return the error's message.
     */
    public String getMessage() {
        return this.error;
    }
}
