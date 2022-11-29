package upgrade;

/**
 * Layer: Use Case Layer
 */
public class UpgradeRequestModel {
    /** The email address of the user who requests upgrade */
    private String email;

    public UpgradeRequestModel(String email) {
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
