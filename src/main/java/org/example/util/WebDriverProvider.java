package org.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverProvider {
    public static WebDriver getDriver(String browserName) {
        if (browserName.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-gpu");
//            WebDriverManager.chromedriver().forceDownload().setup();
            return new ChromeDriver(chromeOptions);
        } else if (browserName.equals("firefox")) {
            return new FirefoxDriver(new FirefoxOptions());
        }

        return new ChromeDriver(new ChromeOptions());
    }
}
