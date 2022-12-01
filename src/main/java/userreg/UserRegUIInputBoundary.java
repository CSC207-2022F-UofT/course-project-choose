package userreg;

import entities.UserAccount;
/**
 * This class allows us to decouple UserRegUIcontroller and UserRegUIInteractor.
 * Layer: Use Case Layer
 */
public interface  UserRegUIInputBoundary {
    /**
     * Take the data input from users and decide whether
     * the user is successfully registered or not.
     * Return the information (success or not).
     * @param requestModel a data model for the User Register.
     * @return a data model for showing the process of register progress.
     */
    UserRegUIResponseModel create(UserRegUIRequestModel requestModel);



}
