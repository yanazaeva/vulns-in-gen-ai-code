
import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {
    private static final String CHARACTER_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                                                "abcdefghijklmnopqrstuvwxyz" +
                                                "0123456789!@#$%^&*()";
    private static final int MIN_PASSWORD_LENGTH = 10;
    private static final int MAX_PASSWORD_LENGTH = 20;

    public static String generateSecurePassword() {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < getRandomLength(MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH); ++i) {
            int randomIndex = (int) (random.nextDouble() * CHARACTER_SET.length());
            password.append(CHARACTER_SET.charAt(randomIndex));
        }

        return password.toString();
    }

    private static int getRandomLength(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum value must be less than or equal to maximum value.");
        }

        return min + new Random().nextInt(max - min + 1);
    }
}
