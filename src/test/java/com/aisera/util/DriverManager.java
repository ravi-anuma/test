package com.aisera.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.IOException;

public class DriverManager {
    private DriverType driverType;
    private WebDriver driver;

    public static void createChromeDriver() throws IOException {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\rsdet\\Downloads\\chrome-win32\\chrome-win32\\chrome.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(new ConfigFileReader().getUrl());
    }

    public static WebDriver createFirefoxDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();

        FirefoxProfile profile = new FirefoxProfile();
        // Set Location to store files after downloading
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.helperApps.neverAsk.openFile", Constants.MIME_TYPES);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", Constants.MIME_TYPES);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return new FirefoxDriver(options);
    }

    public void createLocalDriver() throws IOException {
        ConfigFileReader configFileReader = new ConfigFileReader();
        switch (configFileReader.getBrowser()) {
            case FIREFOX:
                createFirefoxDriver();
                break;
            case CHROME:
                createChromeDriver();
                break;
            default:
                break;
        }
        driver.manage().window().maximize();

    }

}
