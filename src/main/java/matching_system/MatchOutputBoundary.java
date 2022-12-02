package matching_system;

import email_request.MatcherUIResponseModel;

public interface MatchOutputBoundary {
    MatchResponseModel prepareView(MatchResponseModel matchResponseModel);
}
