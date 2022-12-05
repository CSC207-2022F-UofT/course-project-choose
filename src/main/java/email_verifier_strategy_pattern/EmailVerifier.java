package email_verifier_strategy_pattern;

public interface EmailVerifier {

    /**
     *  Verify whether the email address email has a valid email format.
     * @return return true if email is valid, and false otherwise.
     */
    boolean verify(String email);
}
