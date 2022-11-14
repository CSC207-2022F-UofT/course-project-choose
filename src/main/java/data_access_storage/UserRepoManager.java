package data_access_storage;
// use case layer
import email_request.ConnViaEmailRequestModel;
import email_request.RequestModel;
import entities.UserAccount;

public interface UserRepoManager {
    boolean existsByEmail(String email);

    void delete(RequestModel requestModel);

    void save(RequestModel requestModel);

    RequestModel getUserAccount(String email);

}