package pages;

import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.util.List;

public class MainPage extends BasePage {
    @FindBy(css = ".menu-group.gids")
    WebElement showMoreDirectionsBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        this.driver.get("https://artnow.ru/");
        timeSleep();
        return this;
    }

    public MainPage clickCatalogueBtn() {
        waitForElementVisible(catalogueBtn);
        catalogueBtn.click();
        return this;
    }

    public MainPage clickShowMoreDirectionsBtn() {
        waitForElementVisible(showMoreDirectionsBtn);
        showMoreDirectionsBtn.click();
        return this;
    }

    public MainPage clickDirection(String directionName) {
        driver.findElement(By.xpath("//a[contains(.,'"+ directionName + "')]")).click();
        return this;
    }

    public MainPage fillSearchInputAndSearch(String searchRequest) {
        waitForElementEnable(searchInput);
        searchInput.sendKeys(searchRequest);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage checkFirstElementNameContainsString(String str) {
        timeSleep();
        WebElement firstPost = driver.findElement(By.className("post"));
        List<WebElement> elements = firstPost.findElements(By.xpath("//a/div[contains(., '" + str + "')]"));
        Assert.assertFalse(elements.isEmpty());
        return this;
    }
}
