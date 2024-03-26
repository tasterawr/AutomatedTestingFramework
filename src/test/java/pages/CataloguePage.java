package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CataloguePage extends BasePage {

    @FindBy(xpath = "//a[@href=\"//artnow.ru/vyshitye-kartiny-kupit.html\"]/div")
    WebElement embroideredPaintingsBtn;

    @FindBy(xpath = "//a[@href=\"//artnow.ru/batik-kartiny-kupit.html\"]/div")
    WebElement batikPaintingsBtn;

    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход в раздел 'Вышитые картины'")
    public CataloguePage goToEmbroideredPaintings() {
        waitForElementVisible(embroideredPaintingsBtn);
        embroideredPaintingsBtn.click();
        return this;
    }

    @Step("Переход в раздел 'Батик'")
    public CataloguePage goToBatikPaintings() {
        waitForElementVisible(batikPaintingsBtn);
        batikPaintingsBtn.click();
        return this;
    }
}
