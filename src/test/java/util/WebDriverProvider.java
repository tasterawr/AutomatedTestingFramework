package util;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverProvider {
    public static WebDriver getDriver(String browserName) {
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            return new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            return new FirefoxDriver(new FirefoxOptions());
        }

        return new ChromeDriver(new ChromeOptions());
    }
}
