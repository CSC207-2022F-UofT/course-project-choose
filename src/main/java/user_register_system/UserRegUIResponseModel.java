package user_register_system;

public class UserRegUIResponseModel {
    /**
     * This class is Output Data. Presenter will use it to prepare View.
     * Use Case Layer
     */
    String RegMessage;

    public UserRegUIResponseModel(String regMessage){
        this.RegMessage=regMessage;
    }

    public String getRegMessage() {
        return RegMessage;
    }
}
