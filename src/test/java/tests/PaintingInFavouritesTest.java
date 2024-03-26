package tests;

import org.testng.annotations.*;
import pages.CataloguePage;
import pages.FavouritesPage;
import pages.MainPage;
import pages.ProductsByTypePage;
import reporting.TestFailureListener;

@Listeners({TestFailureListener.class})
public class PaintingInFavouritesTest extends BaseTest {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private ProductsByTypePage productsByTypePage;
    private FavouritesPage favouritesPage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.cataloguePage = new CataloguePage(driver);
        this.productsByTypePage = new ProductsByTypePage(driver);
        this.favouritesPage = new FavouritesPage(driver);
    }

    @Test(description = "Check painting is added to the favourites test")
    public void checkPaintingInFavourites() {
        mainPage.open().clickCatalogueBtn();
        cataloguePage.goToBatikPaintings();
        String firstElementHeader = productsByTypePage.getFirstProductHeader();
        productsByTypePage.clickFavouritesBtn()
                .goToFavourites();
        favouritesPage.checkFirstProductHeader(firstElementHeader);
    }

    @AfterMethod
    public void finish() {
        productsByTypePage.clickFavouritesBtn();
    }
}
