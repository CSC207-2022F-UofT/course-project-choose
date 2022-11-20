package matching_system;

public class MatchUIPresenter implements MatchOutputBoundary{
    /**This is where we store MatchResponseModel*/
    private MatchResponseModel matchResponseModel;
    /** Store MatchResponseModel*/
    @Override
    public void setMatchResponseModel(MatchResponseModel matchResponseModel){
        this.matchResponseModel = matchResponseModel;
    }
    /** Return MatchResponseModel*/
    @Override
    public MatchResponseModel prepareView(){
        return this.matchResponseModel;
    }
}
