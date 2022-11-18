package matching_system;

public class MatchUIPresenter implements MatchOutputBoundary{
    @Override
    public MatchResponseModel prepareView(MatchResponseModel matchResponseModel){
        return matchResponseModel;
    }
}
