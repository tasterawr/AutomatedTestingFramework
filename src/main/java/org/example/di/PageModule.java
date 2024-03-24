package org.example.di;

import dagger.Module;
import dagger.Provides;
import org.example.pages.CataloguePage;
import org.example.pages.MainPage;
import org.example.pages.PaintingsByTypePage;
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
    public PaintingsByTypePage paintingsByTypePage(WebDriver driver){
        return new PaintingsByTypePage(driver);
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
