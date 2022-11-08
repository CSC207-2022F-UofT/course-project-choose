package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Matcher {
//    /** This user who requested the match. */
//    private User matchee;
//    /** This a list of possible users to be matched with. */
//    private ArrayList<User> targets;
////    private HashMap<User, Integer> matchResults = new HashMap<User, Integer>();
    /** The matched result, arranged by matching score from high to low */
    private ArrayList<User> matches;

    public Matcher(User matchee, ArrayList<User> targets){
        this.matches = match(matchee,targets);
    }

    public ArrayList<User> getMatches() {
        return matches;
    }

    /** get matched results in a list
      @return ArrayList that stores matched results, sorted by score from high to low
     */
    private ArrayList<User> match(User matchee, ArrayList<User> targets){
        HashMap<User, Integer> matchResults = new HashMap<User, Integer>();
        for(User target :targets){
            int score = 0;
            if(target.getGender().equals(matchee.getInterestedIn())&&
                    matchee.getGender().equals(target.getInterestedIn())){
                score +=1;
                if(target.getHobby().equals(matchee.getHobby())){
                    score +=1;
                }
                if(target.getProgramOfStudy().equals(matchee.getProgramOfStudy())){
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
    private ArrayList<User> sortByScore(HashMap<User,Integer> matchResults){
        ArrayList<User> matches = new ArrayList<User>();
        for(User key :matchResults.keySet()){
            if(matches.size() == 0){
                matches.add(key);
            }
            else{
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
