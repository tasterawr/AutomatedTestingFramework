package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class FavouritesPriceTest extends BaseTest {
    private MainPage mainPage;
    private ProductsByTypePage productsByTypePage;
    private FavouritesPage favouritesPage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.productsByTypePage = new ProductsByTypePage(driver);
        this.favouritesPage = new FavouritesPage(driver);
    }

    @Parameters({"directionName", "productIndex"})
    @Test(description = "Check product price in catalogue and in favourites is the same")
    public void checkPriceInFavouritesMatch(String directionName, int productIndex) {
        mainPage.open()
                .clickShowMoreDirectionsBtn()
                .clickDirection(directionName);
        String productPrice = productsByTypePage.getProductPrice(productIndex);
        productsByTypePage.addProductToFavourites(productIndex)
                .goToFavourites();
        favouritesPage.checkFirstProductPriceMatches(productPrice);
    }

    @AfterMethod
    public void finish() {
        productsByTypePage.clickFavouritesBtn();
    }
}
