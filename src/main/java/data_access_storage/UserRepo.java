package data_access_storage;

import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;
import java.io.*;
import java.util.*;

/**
 * This class provides data access.
 */
public class UserRepo implements UserRepoManager {

    /** This is our data storage where our data is saved to a csv file. */
    private final File csvFile;

    /** headers for our data */
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    /** data */
    private final Map<String, RequestModel> accounts = new HashMap<>();

    /**
     * Create UserRepo for Data Access.
     * @param csvFile:  the csv file where data are stored.
     * @throws IOException
     */
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
                // split the row by , but ignore the commas in any double quotes.
                String[] col = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // retrieve all fields
                String email = String.valueOf(col[headers.get("email")]);
                String password = String.valueOf(col[headers.get("password")]);
                boolean validEmail =  Boolean.parseBoolean(col[headers.get("validEmail")]);
                boolean subStatus =  Boolean.parseBoolean(col[headers.get("subStatus")]);
                int numOfReport = Integer.valueOf(col[headers.get("numOfReport")]);
                String blockedAccountsString = String.valueOf(col[headers.get("blockedAccounts")]);
                List<String> blockedAccounts = new ArrayList<String>(
                        Arrays.asList(blockedAccountsString.split("\\|")));
                int numOfEmailRequest = Integer.valueOf(col[headers.get("numOfEmailRequest")]);
                String name = String.valueOf(col[headers.get("name")]);
                Gender gender = Gender.valueOf(col[headers.get("gender")]);
                int age = Integer.valueOf(col[headers.get("age")]);
                float height = Float.parseFloat(col[headers.get("height")]);
                String programOfStudy = String.valueOf(col[headers.get("programOfStudy")]);
                Hobbies hobbies = Hobbies.valueOf(col[headers.get("hobby")]);
                Gender interestedIn = Gender.valueOf(col[headers.get("interestedIn")]);
                String selfIntro = String.valueOf(col[headers.get("selfIntro")]);
                User user = new User(name, gender, age, height, programOfStudy, hobbies,
                        selfIntro, interestedIn);
                UserAccount userAccount = new UserAccount(email, password, user,validEmail,
                        subStatus,numOfReport,blockedAccounts,numOfEmailRequest);
                RequestModel requestModel = new RequestModel(userAccount);

                // save data in accounts
                accounts.put(email, requestModel);
            }

            reader.close();
        }

    }

    /**
     * Check whether a user with an email address email already exists.
     * @param email user's email address
     * @return return true if a user already exists with the email address email, and false otherwise.
     */
    @Override
    public boolean existsByEmail(String email) {
        return accounts.containsKey(email);
    }

    /**
     * Check whether a user's password matches its recorded password
     * @param email user's email address
     * @param password user's input password
     * @return return true if a user input correct password that matches its password record, and false otherwise.
     */
    @Override
    public Boolean matchingPassword(String email, String password) {
        UserAccount userAccount = accounts.get(email).getUserAccount();
        String password_on_record = userAccount.getPassword();
        return password.equals(password_on_record);
    }

    /**
     * Delete user data
     * Call this method only if requestModel exists in our data.
     * @param requestModel the user data to be deleted.
     */
    @Override
    public void delete(RequestModel requestModel) {
        this.delete(requestModel.getUserAccount().getEmail());
    }

    /**
     * Delete user data whose user email address is email.
     * Call this method only if requestModel exists in our data.
     * @param email the email address of the user data to be deleted.
     */
    public void delete(String email){
        accounts.remove(email);
        this.save();
    }

    /**
     * Save user data
     * @param requestModel the user data to be saved.
     */
    @Override
    public void save(RequestModel requestModel) {
        accounts.put(requestModel.getUserAccount().getEmail(), requestModel);
        this.save();
    }

    /**
     * Update user data whose email address is email.
     * @param email the email address of the user whose account will be updated.
     * @param requestModel update user data to be requestModel
     */
    @Override
    public void update(String email, RequestModel requestModel) {
        this.delete(email);
        this.save(requestModel);
    }

    /**
     * Return user data whose email address is email
     * Call this method only if a user exists with the email address email
     * @param email the email address of a user
     * @return return the user data whose email address is email.
     */
    @Override
    public RequestModel getUserAccount(String email) {
        return accounts.get(email);
    }

    /**
     * Get all users' account information
     * @return all users' account information
     */
    @Override
    public Map<String, RequestModel> getAllUserAccount() {
        return accounts;
    }

    /**
     * Save data to a csv file for data storage.
     */
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

