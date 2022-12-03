package matching_system;


public interface MatchInputBoundary {
    /** A method to create MatchResponseModel which stores all matched results
     * @param requestModel The requestModel that includes requester information
     * @return MatchResponseModel that includes the information of users who are matched
     * */
    MatchResponseModel create(MatchRequestModel requestModel);
}
