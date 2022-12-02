package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

// TODO: 2022/11/20 Filter with block list 
// TODO: 2022/11/20 add randomization
public class Matcher {
    /** The matched result, arranged by matching score from high to low */
    private final UserAccount[] matches;

    public Matcher(UserAccount matchee, ArrayList<UserAccount> targets){
        this.matches = match(matchee,targets);
    }

    /** A helper method to get matching score between matchUser and targetUser
     * @param matchUser the user who requested the match
     * @param targetUser the user to compare to
     * @return An int value score
     */
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
     * @param matchee the UserAccount of the match requester
     * @param targets an ArrayList of all the users to be matched
     * @return Array that stores matched results in form of UserData, sorted by score from high to low
     */
    private UserAccount[] match(UserAccount matchee, ArrayList<UserAccount> targets){
        HashMap<Integer, ArrayList<UserAccount>> matchResults = new HashMap<Integer, ArrayList<UserAccount>>();
        for(int i =0;i<4;i++){
            matchResults.put(i,new ArrayList<>());
        }
        User matchUser = matchee.getUser();
        for(UserAccount target :targets){
            if(target.getEmail().equals(matchee.getEmail())
                    || matchee.getBlockedAccounts().contains(target.getEmail())){
                continue;
            }
            User targetUser = target.getUser();
            int score = getScore(matchUser,targetUser);
            matchResults.get(score).add(target);
        };
        return sortByScore(matchResults);
    }

    /** Helper method to sort an Arraylist according to score
     * @param matchResults a HashMap that map score as key and list of UserAccount that have the correspounding score
     * @return Sorted Array
     */
    private UserAccount[] sortByScore(HashMap<Integer, ArrayList<UserAccount>> matchResults){
        ArrayList<UserAccount> matches = new ArrayList<UserAccount>();
        for(int i =3;i>=0;i--){
            Collections.shuffle(matchResults.get(i));
            matches.addAll(matchResults.get(i));
        }
        if(matches.size()>=5){
            UserAccount[] toReturn = new UserAccount[5];
            toReturn = matches.subList(0,5).toArray(toReturn);
            return toReturn;
        }
        else {
            UserAccount[] toReturn = new UserAccount[matches.size()];
            toReturn = matches.toArray(toReturn);
            return toReturn;
        }
    }
}
