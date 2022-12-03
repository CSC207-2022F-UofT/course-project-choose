package matching_system;

public interface MatchOutputBoundary {
    /** Store MatchResponseModel*/
    void setMatchResponseModel(MatchResponseModel matchResponseModel);
    /** Return MatchResponseModel*/
    MatchResponseModel prepareView();
}
