package Back.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityUtil {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Método para encriptar una contraseña
    public static String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // Método para verificar si la contraseña sin encriptar coincide con la encriptada
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    // Método para validar la fortaleza de una contraseña
    public static boolean isPasswordStrong(String password) {
        // Al menos 8 caracteres, una letra mayúscula, una minúscula, un número y un símbolo especial
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        return password.matches(passwordPattern);
    }
}
