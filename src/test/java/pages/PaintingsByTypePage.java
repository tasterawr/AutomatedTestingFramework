package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class PaintingsByTypePage extends BasePage {
    @FindBy(css = ".ssize")
    WebElement firstElementHeader;
    @FindBy(css = ".heart")
    WebElement firstElementFavouritesBtn;

    @FindBy(css ="input[id=\"genre257\"]")
    WebElement cityscapeFilterCb;

    @FindBy(css = "div[id=\"applymsg\"]")
    WebElement applyBtn;

    public PaintingsByTypePage(WebDriver driver) {
        super(driver);
    }

    public PaintingsByTypePage addFirstToFavourites() {
        waitForElementVisible(firstElementFavouritesBtn);
        firstElementFavouritesBtn.click();
        return this;
    }

    public String getFirstElementHeader() {
        waitForElementVisible(firstElementHeader);
        return firstElementHeader.getText();
    }

    public PaintingsByTypePage addFilter(String filterName) {
        if (filterName.equals("Городской пейзаж")) {
            waitForElementVisible(cityscapeFilterCb);
            cityscapeFilterCb.click();
        }

        waitForElementEnable(applyBtn);
        applyBtn.click();
        return this;
    }

    public PaintingsByTypePage checkPaintingInStock(String paintingName) {
        List<WebElement> elements = driver.findElements(By.xpath("//a/div[contains(., \"" + paintingName + "\")]"));
        Assert.assertFalse(elements.isEmpty());
        return this;
    }

    public PaintingsByTypePage goToPaintingDetails(String paintingName) {
        WebElement element = driver.findElement(By.xpath("//a/div[contains(., \"" + paintingName + "\")]/parent::a"));
        element.click();
        return this;
    }

    public PaintingsByTypePage goToFavourites() {
        waitForElementVisible(favouritesBtn);
        favouritesBtn.click();
        return this;
    }
}
