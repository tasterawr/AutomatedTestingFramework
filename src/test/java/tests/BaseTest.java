package tests;

import org.testng.ITestContext;
import util.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void startBrowser(String browser, ITestContext context) {
        this.driver = WebDriverProvider.getDriver(browser);
        context.setAttribute("WebDriver", driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void stopBrowser() {
        driver.quit();
    }
}
