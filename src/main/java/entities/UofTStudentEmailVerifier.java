package entities;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UofTStudentEmailVerifier implements EmailVerifier {

    /**
     * The email address satisfies the following conditions is valid:
     * 1. The mail ends with @mail.utoronto.ca
     * 2. We allow upper and lower letters, numbers from 0 to 9, and . before the @ sign.
     */
    private static String regex = "^[A-Za-z0-9+.]+@mail.utoronto.ca$";

    @Override
    /**
     * Verify whether email is a @mail.utoronto.ca email account for U of T students.
     * @return Return true if email is a U of T student email account, and false otherwise.
     */
    public boolean verify(String email) {
        Pattern pattern = Pattern.compile(UofTStudentEmailVerifier.regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
