package email_request;

public class ConnViaEmailPresenter implements ConnViaEmailOutputBoundary{

    @Override
    public ConnViaEmailResponseModel prepareView(ConnViaEmailResponseModel user) {
        return user;
    }
}
