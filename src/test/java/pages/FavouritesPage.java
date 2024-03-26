package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FavouritesPage extends BasePage {
    @FindBy(css = ".post")
    private WebElement firstProduct;

    @FindBy(css = ".ssize")
    private WebElement firstProductHeader;

    public FavouritesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка, что заголовок первого продукта соответствует указанной строке")
    public FavouritesPage checkFirstProductHeader(String text) {
        waitForElementVisible(firstProductHeader);
        Assert.assertEquals(firstProductHeader.getText().replace("\n", " "), text.replace("\n", " "));
        return this;
    }

    @Step("Проверка, что цена первого продукта соответствует указанной цене")
    public FavouritesPage checkFirstProductPriceMatches(String expectedPrice) {
        String actualPrice = firstProduct.findElement(By.className("price")).getText();
        Assert.assertEquals(actualPrice, expectedPrice);
        return this;
    }
}
