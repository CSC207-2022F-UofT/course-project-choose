package data_access_storage;
// use case layer

import email_request.RequestModel;
import java.util.Map;

public interface UserRepoManager {
    boolean existsByEmail(String email);

    void delete(RequestModel requestModel);

    void save(RequestModel requestModel);

    RequestModel getUserAccount(String email);

    Map<String, RequestModel> getAllUserAccount();

}