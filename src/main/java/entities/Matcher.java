package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Matcher {
    /** The matched result, arranged by matching score from high to low */
    private final UserAccount[] matches;

    public Matcher(UserAccount matchee, ArrayList<UserAccount> targets){
        this.matches = match(matchee,targets);
    }

    public int getScore(User matchUser, User targetUser){
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
        return score;
    }

    public UserAccount[] getMatches() {
        return matches;
    }

    /** get matched results in a list
      @return Array that stores matched results in form of UserData, sorted by score from high to low
     */
    private UserAccount[] match(UserAccount matchee, ArrayList<UserAccount> targets){
        HashMap<UserAccount, Integer> matchResults = new HashMap<UserAccount, Integer>();
        User matchUser = matchee.getUser();
        for(UserAccount target :targets){
            if(target.getEmail().equals(matchee.getEmail())){
                continue;
            }
            User targetUser = target.getUser();
            int score = getScore(matchUser,targetUser);
            System.out.println(target.getUser().getName() + score);
            matchResults.put(target,score);
        };
        return sortByScore(matchResults);
    }

    /** Helper method to sort an Arraylist according to score
     * @return Sorted ArrayList
     */
    private UserAccount[] sortByScore(HashMap<UserAccount,Integer> matchResults){
        ArrayList<UserAccount> matches = new ArrayList<UserAccount>();
        for(UserAccount key :matchResults.keySet()){
            if(matches.size() == 0){
                matches.add(key);
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
        if(matches.size()<=5){
            UserAccount[] toReturn = new UserAccount[matches.size()];
            toReturn = matches.toArray(toReturn);
            return toReturn;
        }
        else{
            UserAccount[] toReturn = new UserAccount[5];
            toReturn = matches.subList(0,5).toArray(toReturn);
            return toReturn;
        }
    }
}
