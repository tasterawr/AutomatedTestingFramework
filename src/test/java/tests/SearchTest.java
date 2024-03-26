package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;

public class SearchTest extends BaseTest {
    private MainPage mainPage;

    @BeforeMethod
    public void initialize() {
        this.mainPage = new MainPage(driver);
    }

    @Parameters({"containingString"})
    @Test(description = "Check name of the first element in search contains provided string")
    public void checkFirstElementNameContainsString(String containingString) {
        mainPage.open()
                .fillSearchInputAndSearch(containingString)
                .checkFirstProductNameContainsString(containingString);
    }
}
