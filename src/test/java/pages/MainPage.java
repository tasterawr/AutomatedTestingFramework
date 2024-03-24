package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@href=\"//artnow.ru/ru/gallery.html\"]")
    WebElement catalogueBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get("https://artnow.ru/");
        timeSleep();
        return this;
    }

    public MainPage clickCatalogueBtn() {
        waitForElementVisible(catalogueBtn);
        catalogueBtn.click();
        return this;
    }
}
