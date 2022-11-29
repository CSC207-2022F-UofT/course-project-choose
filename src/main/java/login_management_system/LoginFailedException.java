package login_management_system;

public class LoginFailedException extends RuntimeException{
    String error;
    public LoginFailedException(String error){
        super(error);
        this.error = error;
    }

    public String getmessage() {
        return this.error;
    }
}
