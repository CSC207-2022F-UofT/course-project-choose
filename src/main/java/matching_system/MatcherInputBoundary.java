package matching_system;


public interface MatcherInputBoundary {
    /** A method to create MatchResponseModel which stores all matched results*/
    MatchResponseModel create(MatchRequestModel requestModel);
}
