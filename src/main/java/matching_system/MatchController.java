package matching_system;
/**
 * This class is responsible to react to the match button clicks on
 * HomeUI
 * Layer: Interface Adapters
 */
public class MatchController {

    final MatchInputBoundary userInput;

    /**
     * Create a controller that responses to the match button click on HomeUI.
     * @param matchInputBoundary The abstraction layer between MatchController and MatchManager
     */
    public MatchController(MatchInputBoundary matchInputBoundary) {
        this.userInput = matchInputBoundary;
    }

    /**
     * Return a data structure that contains the match results.
     * @param requesterEmail  the email address of the user who requests to see the match results
     * @return a data model containing the match results.
     */
    public MatchResponseModel create(String requesterEmail){
        MatchRequestModel matchRequestModel = new MatchRequestModel(requesterEmail);
        return userInput.create(matchRequestModel);
    }

}
