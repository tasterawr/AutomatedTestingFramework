package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.MainPage;
import pages.PaintingDetailsPage;
import pages.PaintingsByTypePage;
import reporting.TestFailureListener;

@Listeners({TestFailureListener.class})
public class PaintingStyleTest extends BaseTest {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private PaintingsByTypePage paintingsByTypePage;
    private PaintingDetailsPage paintingDetailsPage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.cataloguePage = new CataloguePage(driver);
        this.paintingsByTypePage = new PaintingsByTypePage(driver);
        this.paintingDetailsPage = new PaintingDetailsPage(driver);
    }

    @Parameters({"paintingName", "paintingStyle"})
    @Test(description = "Check painting style test")
    public void checkPaintingStyle(String paintingName, String paintingStyle) {
        mainPage.open()
                .clickCatalogueBtn();
        cataloguePage.goToEmbroideredPaintings();
        paintingsByTypePage.addFilter("Городской пейзаж")
                .goToPaintingDetails(paintingName);
        paintingDetailsPage.checkStyle(paintingStyle);
    }
}
