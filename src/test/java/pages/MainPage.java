package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//li[contains(.,'Показать еще')]")
    WebElement showMoreDirectionsBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие главной страницы сайта")
    public MainPage open() {
        this.driver.get("https://artnow.ru/");
        timeSleep();
        return this;
    }

    @Step("Переход в каталог")
    public MainPage clickCatalogueBtn() {
        waitForElementVisible(catalogueBtn);
        catalogueBtn.click();
        return this;
    }

    @Step("Нажатие на кнопку 'Показать еще...' в меню направлений")
    public MainPage clickShowMoreDirectionsBtn() {
        timeSleep();
        waitForElementClickable(showMoreDirectionsBtn);
        showMoreDirectionsBtn.click();
        return this;
    }

    @Step("Переход в раздел по указанному направлению")
    public MainPage clickDirection(String directionName) {
        driver.findElement(By.xpath("//a[contains(.,'"+ directionName + "')]")).click();
        return this;
    }

    @Step("Заполнение строки поиска указанной строкой и поиск")
    public MainPage fillSearchInputAndSearch(String searchRequest) {
        waitForElementEnable(searchInput);
        searchInput.sendKeys(searchRequest);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Проверка, что название первого продукта содержит указанную строку")
    public MainPage checkFirstProductNameContainsString(String str) {
        timeSleep();
        WebElement firstPost = driver.findElement(By.className("post"));
        List<WebElement> elements = firstPost.findElements(By.xpath("//a/div[contains(., '" + str + "')]"));
        Assert.assertFalse(elements.isEmpty());
        return this;
    }
}
