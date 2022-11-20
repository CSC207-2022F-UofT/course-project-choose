package matching_system;

import email_request.MatcherUIResponseModel;

public interface MatchOutputBoundary {
    void setMatchResponseModel(MatchResponseModel matchResponseModel);
    MatchResponseModel prepareView();
}
