package matching_system;


public interface MatcherInputBoundary {
    /**
     * Take the email request from users and decide whether
     * the requesters can see the requested email address.
     * If so, return the requested email address, and empty string otherwise.
     * @param requestModel a data model for the email request
     * @return a data model for showing the requested email or empty string.
     */
    MatchResponseModel create(MatchRequestModel requestModel);
}
