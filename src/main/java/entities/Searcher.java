package entities;

import java.util.ArrayList;
import java.util.List;

public class Searcher {
    /** The search result */
    private final ArrayList<UserAccount> searches;

    public Searcher(String keyword, List<UserAccount> searches) {

        ArrayList<UserAccount> searchResult = new ArrayList<>();
        for (UserAccount user: searches){
            if (user.getUser().getName().contains(keyword)) {
                searchResult.add(user);
            }
            else if (user.getUser().getSelfIntro().contains(keyword)) {
                searchResult.add(user);
            }
        }
        this.searches = searchResult;

    }

    public ArrayList<UserAccount> getSearches() {
        return searches;
    }

//    public List<UserAccount> doSearch(String keyword, ArrayList<UserAccount> pool){
//        List<UserAccount> searchResult = new ArrayList<>();
//        for (UserAccount user: pool){
//            if (user.getUser().getName().contains(keyword)) {
//                searchResult.add(user);
//            }
//            else if (user.getUser().getSelfIntro().contains(keyword)) {
//                searchResult.add(user);
//            }
//        }
//        return searchResult;
//
//    }

}
