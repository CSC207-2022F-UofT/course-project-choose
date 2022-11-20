package matching_system;

import email_request.MatcherUIResponseModel;

public interface MatchOutputBoundary {
    /** Store MatchResponseModel*/
    void setMatchResponseModel(MatchResponseModel matchResponseModel);
    /** Return MatchResponseModel*/
    MatchResponseModel prepareView();
}
