package Back.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityUtil {

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";

    // Método para encriptar una contraseña
    public static String encryptPassword(String rawPassword) {
        return PASSWORD_ENCODER.encode(rawPassword);
    }

    // Método para verificar si la contraseña sin encriptar coincide con la encriptada
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        return PASSWORD_ENCODER.matches(rawPassword, encodedPassword);
    }

    // Método para validar la fortaleza de una contraseña
    public static boolean isPasswordStrong(String password) {
        return password != null && password.matches(PASSWORD_PATTERN);
    }
}
