package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FavouritesPage extends BasePage {
    @FindBy(css = ".post")
    WebElement firstProduct;

    @FindBy(css = ".ssize")
    WebElement firstProductHeader;

    public FavouritesPage(WebDriver driver) {
        super(driver);
    }

    public FavouritesPage checkFirstElementHeader(String text) {
        waitForElementVisible(firstProductHeader);
        Assert.assertEquals(firstProductHeader.getText().replace("\n", " "), text.replace("\n", " "));
        return this;
    }

    public FavouritesPage checkFirstProductPriceMatches(String expectedPrice) {
        String actualPrice = firstProduct.findElement(By.className("price")).getText();
        Assert.assertEquals(actualPrice, expectedPrice);
        return this;
    }
}
