package upgrade;

/**
 * This class is Output Data. Presenter will use it to prepare View.
 * Use Case Layer
 */
public class UpgradeResponseModel {
    /** the email of the user who requests upgrade */
    private String email;

    public UpgradeResponseModel(String email) {
        this.email = email;
    }

    /**
     * Return the email of the user who requests upgrade
     * @return Return the email of the user who requests upgrade
     */
    public String getEmail() {
        return email;
    }
}
