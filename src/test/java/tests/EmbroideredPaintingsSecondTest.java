package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.MainPage;
import pages.PaintingsByTypePage;
import reporting.TestFailureListener;

@Listeners({TestFailureListener.class})
public class EmbroideredPaintingsSecondTest extends BaseTest {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private PaintingsByTypePage paintingsByTypePage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.cataloguePage = new CataloguePage(driver);
        this.paintingsByTypePage = new PaintingsByTypePage(driver);
    }

    @Test(description = "Check painting is available test")
    public void checkPaintingInStock() {
        mainPage.open()
                .clickCatalogueBtn();
        cataloguePage.goToEmbroideredPaintings();
        paintingsByTypePage.addFilter("Городской пейзаж")
                .checkPaintingInStock("Трамвайный путь");
    }
}
