package tests;

import pages.CataloguePage;
import pages.MainPage;
import pages.PaintingsByTypePage;
import org.testng.annotations.*;
import reporting.TestFailureListener;

@Listeners({TestFailureListener.class})
public class PaintingInStockTest extends BaseTest {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private PaintingsByTypePage paintingsByTypePage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.cataloguePage = new CataloguePage(driver);
        this.paintingsByTypePage = new PaintingsByTypePage(driver);
    }

    @Parameters("paintingName")
    @Test(description = "Check painting is available test")
    public void checkPaintingInStock(String paintingName) {
        mainPage.open()
                .clickCatalogueBtn();
        cataloguePage.goToEmbroideredPaintings();
        paintingsByTypePage.addFilter("Городской пейзаж")
                .checkPaintingInStock(paintingName);
    }
}
