
import java.util.Random;

public class Contraseña {

    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%&*()_-+={[}];:<>,.?/~`";

    public static void main(String[] args) {
        System.out.println(generatePassword());
    }

    public static String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Añadimos 1 caracter de cada tipo a la contraseña
        for (int i = 0; i < 4; i++) {
            int type = random.nextInt(4);
            switch (type) {
                case 0:
                    password.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
                    break;
                case 1:
                    password.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));
                    break;
                case 2:
                    password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
                    break;
                case 3:
                    password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
                    break;
            }
        }

        // Añadimos los caracteres restantes de manera aleatoria para completar la contraseña
        for (int i = 4; i < 10; i++) {
            int type = random.nextInt(4);
            password.append(getTypeChar(type));
        }

        return password.toString();
    }

    private static char getTypeChar(int type) {
        switch (type) {
            case 0:
                return LOWER_CASE.charAt(new Random().nextInt(LOWER_CASE.length()));
            case 1:
                return UPPER_CASE.charAt(new Random().nextInt(UPPER_CASE.length()));
            case 2:
                return DIGITS.charAt(new Random().nextInt(DIGITS.length()));
            case 3:
                return SPECIAL_CHARS.charAt(new Random().nextInt(SPECIAL_CHARS.length()));
        }
        return '\u0000'; // Caracter no válido, nunca se debería llegar a ejecutar este caso
    }
}
