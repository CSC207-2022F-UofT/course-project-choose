package entities;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.*;
import matching_system.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Matcher {
//    private HashMap<User, Integer> matchResults = new HashMap<User, Integer>();
    /** The matched result, arranged by matching score from high to low */
    private final UserAccount[] matches;

    public Matcher(UserAccount matchee, ArrayList<UserAccount> targets){
        this.matches = match(matchee,targets);
    }

    public UserAccount[] getMatches() {
        return matches;
    }

    /** get matched results in a list
      @return ArrayList that stores matched results, sorted by score from high to low
     */
    private UserAccount[] match(UserAccount matchee, ArrayList<UserAccount> targets){
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
            System.out.println(target.getUser().getName() + score);
            matchResults.put(target,score);
        };
        return sortByScore(matchResults,5);
    }

    /** Helper method to sort an Arraylist according to score
     * @return Sorted ArrayList
     */
    private UserAccount[] sortByScore(HashMap<UserAccount,Integer> matchResults, int len){
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
        if(matches.size()<=len){
            UserAccount[] toReturn = new UserAccount[matches.size()];
            toReturn = matches.toArray(toReturn);
            return toReturn;
        }
        else{
            UserAccount[] toReturn = new UserAccount[len];
            toReturn = matches.subList(0,len).toArray(toReturn);
            return toReturn;
        }
    }
    public static void main(String[] args) {

        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/matchingSystemTest.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        MatchRequestModel matchRequestModel = new MatchRequestModel("a@mail.utoronto.ca");
        MatchOutputBoundary presenter = new MatchUIPresenter();
        MatchManager matchManager = new MatchManager(matchRequestModel, users);
        UserData[] results = matchManager.create(matchRequestModel).getMatchedData();
        for (UserData result: results){
            System.out.println(result.name);
        }
//        System.out.println(results);
    }
}
