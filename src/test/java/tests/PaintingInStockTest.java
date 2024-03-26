package tests;

import pages.CataloguePage;
import pages.MainPage;
import pages.ProductsByTypePage;
import org.testng.annotations.*;
import reporting.TestFailureListener;

@Listeners({TestFailureListener.class})
public class PaintingInStockTest extends BaseTest {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private ProductsByTypePage productsByTypePage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.cataloguePage = new CataloguePage(driver);
        this.productsByTypePage = new ProductsByTypePage(driver);
    }

    @Parameters("paintingName")
    @Test(description = "Check painting is available test")
    public void checkPaintingInStock(String paintingName) {
        mainPage.open()
                .clickCatalogueBtn();
        cataloguePage.goToEmbroideredPaintings();
        productsByTypePage.setGenre("Городской пейзаж")
                .checkProductInStock(paintingName);
    }
}