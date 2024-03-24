package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FavouritesPage extends BasePage {
    @FindBy(css = ".ssize")
    WebElement firstElementHeader;

    public FavouritesPage(WebDriver driver) {
        super(driver);
    }

    public FavouritesPage checkFirstElementHeader(String text) {
        waitForElementVisible(firstElementHeader);
        Assert.assertEquals(firstElementHeader.getText().replace("\n", " "), text.replace("\n", " "));
        return this;
    }
}
