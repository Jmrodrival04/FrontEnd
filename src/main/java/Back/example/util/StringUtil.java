package Back.example.util;

public class StringUtil {

    // Método para verificar si una cadena es nula o está vacía
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Método para capitalizar la primera letra de una cadena
    public static String capitalize(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    // Método para convertir una cadena en formato de título (cada palabra capitalizada)
    public static String toTitleCase(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        String[] words = str.split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            titleCase.append(capitalize(word)).append(" ");
        }
        return titleCase.toString().trim();
    }
}
