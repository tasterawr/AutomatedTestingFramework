package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.MainPage;
import pages.ProductDetailsPage;
import pages.ProductsByTypePage;
import reporting.TestFailureListener;

@Listeners({TestFailureListener.class})
public class PaintingStyleTest extends BaseTest {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private ProductsByTypePage productsByTypePage;
    private ProductDetailsPage productDetailsPage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.cataloguePage = new CataloguePage(driver);
        this.productsByTypePage = new ProductsByTypePage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
    }

    @Parameters({"paintingName", "paintingStyle"})
    @Test(description = "Check painting style test")
    public void checkPaintingStyle(String paintingName, String paintingStyle) {
        mainPage.open()
                .clickCatalogueBtn();
        cataloguePage.goToEmbroideredPaintings();
        productsByTypePage.addFilter("Городской пейзаж")
                .goToPaintingDetails(paintingName);
        productDetailsPage.checkStyle(paintingStyle);
    }
}
