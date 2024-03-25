package di;

import dagger.Module;
import dagger.Provides;
import pages.CataloguePage;
import pages.MainPage;
import pages.ProductsByTypePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.inject.Named;

@Module
public class PageModule {
    @Provides
    public MainPage mainPage(WebDriver driver){
        return new MainPage(driver);
    }

    @Provides
    public CataloguePage cataloguePage(WebDriver driver){
        return new CataloguePage(driver);
    }

    @Provides
    public ProductsByTypePage paintingsByTypePage(WebDriver driver){
        return new ProductsByTypePage(driver);
    }

    @Provides
    @Named("chrome")
    public WebDriver chromeDriver() {
        return new ChromeDriver(new ChromeOptions());
    }

    @Provides
    @Named("firefox")
    public WebDriver firefoxDriver() {
        return new FirefoxDriver(new FirefoxOptions());
    }
}
