package entities;

public interface EmailVerifier {

    /**
     *  Verify whether email is a valid email format.
     * @return return true if email is valid, and false otherwise.
     */
    boolean verify(String email);
}
