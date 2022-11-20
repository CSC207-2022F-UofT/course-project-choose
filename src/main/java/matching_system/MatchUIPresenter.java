package matching_system;

public class MatchUIPresenter implements MatchOutputBoundary{
    private MatchResponseModel matchResponseModel;
    @Override
    public void setMatchResponseModel(MatchResponseModel matchResponseModel){
        this.matchResponseModel = matchResponseModel;
    }
    @Override
    public MatchResponseModel prepareView(){
        return this.matchResponseModel;
    }
}
