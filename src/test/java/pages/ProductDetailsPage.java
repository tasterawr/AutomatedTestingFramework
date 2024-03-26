package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDetailsPage extends BasePage{
    @FindBy(xpath = "//span[contains(., 'Стиль')]/parent::div/a")
    WebElement styleLink;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка, что стиль продукта соответствует указанному стилю")
    public ProductDetailsPage checkStyle(String style) {
        timeSleep();
        waitForElementVisible(styleLink);
        String linkText = styleLink.getText();
        Assert.assertEquals(linkText, style);
        return this;
    }
}
