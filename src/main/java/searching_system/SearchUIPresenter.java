package searching_system;

public class SearchUIPresenter implements SearcherOutputBoundary{
    @Override
    public SearchResponseModel prepareView(SearchResponseModel searchResponseModel) {
        return searchResponseModel;
    }
}
