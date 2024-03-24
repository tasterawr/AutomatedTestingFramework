package org.example.tests;

import org.example.pages.CataloguePage;
import org.example.pages.MainPage;
import org.example.pages.PaintingsByTypePage;
import org.example.util.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void startBrowser(String browser) {
        this.driver = WebDriverProvider.getDriver(browser);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void stopBrowser() {
        driver.quit();
    }
}
