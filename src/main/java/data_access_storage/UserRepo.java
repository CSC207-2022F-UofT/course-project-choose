package data_access_storage;

import email_request.ConnViaEmailRequestModel;
import email_request.RequestModel;
import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;


import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class UserRepo implements UserRepoManager {

    /** This is our data storage where our data is saved to a csv file. */
    private final File csvFile;

    /** headers for our data */
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    /** data */
    private final Map<String, RequestModel> accounts = new HashMap<>();

    public UserRepo(File csvFile) throws IOException {
        this.csvFile = csvFile;
        headers.put("email", 0);
        headers.put("password", 1);
        headers.put("validEmail", 2);
        headers.put("subStatus", 3);
        headers.put("numOfReport", 4);
        headers.put("blockedAccounts", 5);
        headers.put("numOfEmailRequest", 6);
        headers.put("name", 7);
        headers.put("gender", 8);
        headers.put("age", 9);
        headers.put("height", 10);
        headers.put("programOfStudy", 11);
        headers.put("hobby", 12);
        headers.put("selfIntro", 13);
        headers.put("interestedIn", 14);

        if(csvFile.length() == 0){
            save();
        }else{
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                String email = String.valueOf(col[headers.get("email")]);
                String password = String.valueOf(col[headers.get("password")]);
                boolean validEmail =  Boolean. parseBoolean(String.valueOf(col[headers.get("validEmail")]));
                boolean subStatus =  Boolean. parseBoolean(String.valueOf(col[headers.get("subStatus")]));
                int numOfReport = Integer.valueOf(headers.get("numOfReport"));
                String blockedAccountsString = String.valueOf(col[headers.get("blockedAccounts")]);
                List<String> blockedAccounts = new ArrayList<String>(
                        Arrays.asList(blockedAccountsString.split("\\|")));
                int numOfEmailRequest = Integer.valueOf(headers.get("numOfEmailRequest"));
                String name = String.valueOf(col[headers.get("name")]);
                Gender gender = Gender.valueOf(col[headers.get("gender")]);
                int age = Integer.valueOf(headers.get("age"));
                float height = Float.parseFloat(String.valueOf(headers.get("height")));
                String programOfStudy = String.valueOf(col[headers.get("programOfStudy")]);
                Hobbies hobbies = Hobbies.valueOf(col[headers.get("hobby")]);
                Gender interestedIn = Gender.valueOf(col[headers.get("interestedIn")]);
                String selfIntro = String.valueOf(col[headers.get("selfIntro")]);
                User user = new User(name, gender, age, height, programOfStudy, hobbies,
                         selfIntro, interestedIn);
                UserAccount userAccount = new UserAccount(name, email, user);
                RequestModel requestModel = new RequestModel(userAccount);
                accounts.put(email, requestModel);
            }

            reader.close();
        }

    }

    @Override
    public boolean existsByEmail(String email) {
        return accounts.containsKey(email);
    }

    @Override
    public void delete(RequestModel requestModel) {
        accounts.remove(requestModel.getUserAccount().getEmail());
        this.save();
    }

    @Override
    public void save(RequestModel requestModel) {
        accounts.put(requestModel.getUserAccount().getEmail(), requestModel);
        this.save();
    }

    @Override
    public RequestModel getUserAccount(String email) {
        return accounts.get(email);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (RequestModel rm : accounts.values()) {
                UserAccount userAccount = rm.getUserAccount();
                User user = userAccount.getUser();
                // a list of email address of blocked users.
                List<String> blocks = userAccount.getBlockedAccounts();
                String blocksString = String.join("|", blocks);
                String line = String.join(",", userAccount.getEmail(),
                        userAccount.getPassword(), String.valueOf(userAccount.getValidEmail()),
                        String.valueOf(userAccount.getSubStatus()), String.valueOf(userAccount.getNumOfReport()),
                        blocksString, String.valueOf(userAccount.getNumOfEmailRequest()),
                        user.getName(), String.valueOf(user.getGender()),
                        String.valueOf(user.getAge()), String.valueOf(user.getHeight()),
                        user.getProgramOfStudy(), String.valueOf(user.getHobby()),
                        String.valueOf(user.getSelfIntro()),
                        String.valueOf(user.getInterestedIn()));
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
