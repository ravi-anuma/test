package com.aisera.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private static final String PROPERTY_FILE_PATH = "resources\\configs\\config.properties";

    public ConfigFileReader() throws IOException {
        try (FileReader fileReader = new FileReader(PROPERTY_FILE_PATH)) {
            try (BufferedReader reader = new BufferedReader(fileReader)) {
                loadProperties(reader);
            }
        } catch (FileNotFoundException e) {
        }
    }

    public ConfigFileReader(String configFilePath) throws IOException {
        try (FileReader fileReader = new FileReader(configFilePath)) {
            try (BufferedReader reader = new BufferedReader(fileReader)) {
                loadProperties(reader);
            }
        } catch (FileNotFoundException e) {
        }
    }

    private void loadProperties(BufferedReader reader) {
        properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        String username = System.getProperty("username");
        if (username == null) {
            username = properties.getProperty("username");
        }
        if (username == null) {
            throw new RuntimeException("password not specified in the config.properties file.");
        }
        return username;
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        return url;
    }

    public DriverType getBrowser() {

        String browserName = properties.getProperty("browser");

        if (browserName == null) {
            throw new RuntimeException("browserName not specified in the config.properties file.");
        }
        return getDriverType(browserName);
    }

    private static DriverType getDriverType(String browserName) {
        DriverType browserDriverType = null;
        switch (browserName.toLowerCase(Locale.getDefault())) {
            case "firefox":
                browserDriverType = DriverType.FIREFOX;
                break;
            default:
                browserDriverType = DriverType.CHROME;
                break;
        }
        return browserDriverType;
    }

    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null) {
            return Boolean.valueOf(windowSize);
        }
        return true;
    }
}
