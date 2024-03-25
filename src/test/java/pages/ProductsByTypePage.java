package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductsByTypePage extends BasePage {
    @FindBy(css = ".ssize")
    WebElement firstProductHeader;
    @FindBy(css = ".heart")
    WebElement firstProductFavouritesBtn;

    @FindBy(css ="input[id=\"genre257\"]")
    WebElement cityscapeFilterCb;

    @FindBy(css = "div[id=\"applymsg\"]")
    WebElement applyBtn;

    public ProductsByTypePage(WebDriver driver) {
        super(driver);
    }

    public ProductsByTypePage clickFavouritesBtn() {
        waitForElementVisible(firstProductFavouritesBtn);
        firstProductFavouritesBtn.click();
        return this;
    }

    public String getFirstProductHeader() {
        waitForElementVisible(firstProductHeader);
        return firstProductHeader.getText();
    }

    public String getProductPrice(int productIndex) {
        WebElement post = driver.findElements(By.className("post")).get(productIndex);
        return post.findElement(By.className("price")).getText();
    }

    public ProductsByTypePage addProductToFavourites(int productIndex) {
        WebElement post = driver.findElements(By.className("post")).get(productIndex);
        post.findElement(By.className("heart")).click();
        return this;
    }

    public ProductsByTypePage addFilter(String filterName) {
        if (filterName.equals("Городской пейзаж")) {
            waitForElementVisible(cityscapeFilterCb);
            cityscapeFilterCb.click();
        }

        waitForElementEnable(applyBtn);
        applyBtn.click();
        return this;
    }

    public ProductsByTypePage checkPaintingInStock(String paintingName) {
        List<WebElement> elements = driver.findElements(By.xpath("//a/div[contains(., \"" + paintingName + "\")]"));
        Assert.assertFalse(elements.isEmpty());
        return this;
    }

    public ProductsByTypePage goToPaintingDetails(String paintingName) {
        WebElement element = driver.findElement(By.xpath("//a/div[contains(., \"" + paintingName + "\")]"));
        waitForElementClickable(element);
        element.click();
        return this;
    }

    public ProductsByTypePage goToFavourites() {
        waitForElementVisible(favouritesBtn);
        favouritesBtn.click();
        return this;
    }
}
