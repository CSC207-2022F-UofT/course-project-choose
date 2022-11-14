package usecases;

import entities.User;

import java.util.ArrayList;

public class MatchResponseModel {
    ArrayList<String> matchedNames;

    public MatchResponseModel(ArrayList<String> matchedNames){
        this.matchedNames = matchedNames;
    }
}
