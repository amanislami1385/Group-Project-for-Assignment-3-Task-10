package Packageedu.aitu.oop3.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigProperties.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find db.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}