package userReg;
/**
 * This class is the abstraction that allows UserRegUIInteractor to pass
 * the compared email address to UserRegUIPresenter without violating Dependency Rules
 * of clean architecture.
 * Layer: Use Case Layer
 */
interface  UserRegUIOutputBoundary {
    /**
     * Prepare the returned requested email address for viewing
     * @param regMessage the requested email address
     */
    UserRegUIResponseModel prepareView(UserRegUIResponseModel regMessage);

}
