package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String getTimestamp() {
        return LocalDateTime.now().format(formatter);
    }

    public static void info(String message) {
        System.out.println(getTimestamp() + " [INFO] " + message);
    }

    public static void error(String message) {
        System.out.println(getTimestamp() + " [ERROR] " + message);
    }

    public static void warn(String message) {
        System.out.println(getTimestamp() + " [WARN] " + message);
    }

    public static void debug(String message) {
        System.out.println(getTimestamp() + " [DEBUG] " + message);
    }
}