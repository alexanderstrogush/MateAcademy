package hw07.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PropertiesLoader {

    public static String getProperty(String name) throws IOException {
        Path propertyPath = Paths.get("app.properties");
        String propertyString = new String(Files.readAllBytes(propertyPath));
        return propertyString.split("=")[1];
    }
}
