package email_request;

/**
 * This class allows us to decouple MatcherUIcontroller and MactherUIInteractor.
 * Layer: Use Case Layer
 */
public interface MatcherUIInputBoundary {
    /**  */
    MatcherUIResponseModel create(MatcherUIRequestModel requestModel);
}
