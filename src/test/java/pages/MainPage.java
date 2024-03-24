package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

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
}
