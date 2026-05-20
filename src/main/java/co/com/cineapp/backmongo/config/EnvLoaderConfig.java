package co.com.cineapp.backmongo.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class EnvLoaderConfig {

    @PostConstruct
    public void loadEnvFile() {
        try {
            Path envPath = Paths.get(".env");
            if (Files.exists(envPath)) {
                Files.lines(envPath)
                        .filter(line -> line.contains("=") && !line.trim().startsWith("#"))
                        .forEach(line -> {
                            String key = line.substring(0, line.indexOf("=")).trim();
                            String value = line.substring(line.indexOf("=") + 1).trim();
                            System.setProperty(key, value);
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}