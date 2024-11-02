package Back.example.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    // Método para formatear una fecha a una cadena legible
    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    // Método para calcular la diferencia en días entre dos fechas
    public static long daysBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    // Método para calcular la diferencia en horas entre dos fechas
    public static long hoursBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.HOURS.between(start, end);
    }

    // Método para calcular la diferencia en minutos entre dos fechas
    public static long minutesBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.MINUTES.between(start, end);
    }
}
