package org.example.tests;

import org.example.pages.CataloguePage;
import org.example.pages.MainPage;
import org.example.pages.PaintingsByTypePage;
import org.example.util.WebDriverProvider;
import org.testng.annotations.*;

import javax.inject.Inject;


public class EmbroideredPaintingsFirstTest extends BaseTest {
    private MainPage mainPage;
    private CataloguePage cataloguePage;
    private PaintingsByTypePage paintingsByTypePage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
        this.cataloguePage = new CataloguePage(driver);
        this.paintingsByTypePage = new PaintingsByTypePage(driver);
    }

    @Test
    public void checkPaintingInStock() {
        mainPage.open()
                .clickCatalogueBtn();
        cataloguePage.goToEmbroideredPaintings();
        paintingsByTypePage.addFilter("Городской пейзаж")
                .checkPaintingInStock("Трамвайный путь");
    }
}
