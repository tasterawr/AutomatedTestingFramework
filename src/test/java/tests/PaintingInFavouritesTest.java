package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.FavouritesPage;
import pages.MainPage;
import pages.PaintingsByTypePage;
import reporting.TestFailureListener;

@Listeners({TestFailureListener.class})
public class PaintingInFavouritesTest extends BaseTest {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private PaintingsByTypePage paintingsByTypePage;
    private FavouritesPage favouritesPage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.cataloguePage = new CataloguePage(driver);
        this.paintingsByTypePage = new PaintingsByTypePage(driver);
        this.favouritesPage = new FavouritesPage(driver);
    }

    @Test(description = "Check painting is added to the favourites test")
    public void checkPaintingInFavourites() {
        mainPage.open().clickCatalogueBtn();
        cataloguePage.goToBatikPaintings();
        String firstElementHeader = paintingsByTypePage.getFirstElementHeader();
        paintingsByTypePage.addFirstToFavourites()
                .goToFavourites();
        favouritesPage.checkFirstElementHeader(firstElementHeader);
    }
}
