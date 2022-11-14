package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Matcher {
//    private HashMap<User, Integer> matchResults = new HashMap<User, Integer>();
    /** The matched result, arranged by matching score from high to low */
    private final ArrayList<UserAccount> matches;

    public Matcher(UserAccount matchee, ArrayList<UserAccount> targets){
        this.matches = match(matchee,targets);
    }

    public ArrayList<UserAccount> getMatches() {
        return matches;
    }

    /** get matched results in a list
      @return ArrayList that stores matched results, sorted by score from high to low
     */
    private ArrayList<UserAccount> match(UserAccount matchee, ArrayList<UserAccount> targets){
        HashMap<UserAccount, Integer> matchResults = new HashMap<UserAccount, Integer>();
        User matchUser = matchee.getUser();
        for(UserAccount target :targets){
            User targetUser = target.getUser();
            int score = 0;
            if(targetUser.getGender().equals(matchUser.getInterestedIn())&&
                    matchUser.getGender().equals(targetUser.getInterestedIn())){
                score +=1;
                if(targetUser.getHobby().equals(matchUser.getHobby())){
                    score +=1;
                }
                if(targetUser.getProgramOfStudy().equals(matchUser.getProgramOfStudy())){
                    score+=1;
                }
            }
            matchResults.put(target,score);
        };
        return sortByScore(matchResults);
    }

    /** Helper method to sort an Arraylist according to score
     * @return Sorted ArrayList
     */
    private ArrayList<UserAccount> sortByScore(HashMap<UserAccount,Integer> matchResults){
        ArrayList<UserAccount> matches = new ArrayList<UserAccount>();
        for(UserAccount key :matchResults.keySet()){
            if(matches.size() == 0){
                matches.add(key);
            } else if (matches.size()>=5) {
                return matches;
            } else{
                boolean added = false;
                for(int i =0; i<matches.size();i++){
                    if(matchResults.get(key)>matchResults.get(matches.get(i))){
                        matches.add(i,key);
                        added = true;
                        break;
                    }
                }
                if(!added) {
                    matches.add(key);
                }
            }
        }
        return matches;
    }
}
