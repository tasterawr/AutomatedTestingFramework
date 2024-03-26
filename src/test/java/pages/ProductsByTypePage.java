package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductsByTypePage extends BasePage {
    @FindBy(css = ".ssize")
    private WebElement firstProductHeader;
    @FindBy(css = ".heart")
    private WebElement firstProductFavouritesBtn;

    @FindBy(css ="input[id=\"genre257\"]")
    private WebElement cityscapeFilterCb;

    @FindBy(css = "div[id=\"applymsg\"]")
    private WebElement applyBtn;

    public ProductsByTypePage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход в Избранное")
    public ProductsByTypePage clickFavouritesBtn() {
        waitForElementVisible(firstProductFavouritesBtn);
        firstProductFavouritesBtn.click();
        return this;
    }

    @Step("Получение название первого продукта на странице")
    public String getFirstProductHeader() {
        waitForElementVisible(firstProductHeader);
        return firstProductHeader.getText();
    }

    @Step("Получение цены продукта с заданным индексом на странице")
    public String getProductPrice(int productIndex) {
        WebElement post = driver.findElements(By.className("post")).get(productIndex);
        return post.findElement(By.className("price")).getText();
    }

    @Step("Добавление продукта с заданным индексом в Избранное")
    public ProductsByTypePage addProductToFavourites(int productIndex) {
        WebElement post = driver.findElements(By.className("post")).get(productIndex);
        post.findElement(By.className("heart")).click();
        return this;
    }

    @Step("Добавление фильтра по указанному жанру")
    public ProductsByTypePage setGenre(String genreName) {
        WebElement genreElement = driver.findElement(By.xpath("//label[contains(.,'" + genreName + "')]/input"));
        waitForElementClickable(genreElement);
        genreElement.click();

        waitForElementEnable(applyBtn);
        applyBtn.click();
        return this;
    }

    @Step("Проверка, что продукт с указанным наименованием есть в выдаче")
    public ProductsByTypePage checkProductInStock(String productName) {
        List<WebElement> elements = driver.findElements(By.xpath("//a/div[contains(., \"" + productName + "\")]"));
        Assert.assertFalse(elements.isEmpty());
        return this;
    }

    @Step("Переход на страницу деталей продукта")
    public ProductsByTypePage goToProductDetails(String productName) {
        WebElement element = driver.findElement(By.xpath("//a/div[contains(., '" + productName + "')]"));
        waitForElementClickable(element);
        element.click();
        return this;
    }

    @Step("Переход в Избранное")
    public ProductsByTypePage goToFavourites() {
        waitForElementVisible(favouritesBtn);
        favouritesBtn.click();
        return this;
    }
}
