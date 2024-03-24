package org.example.di;

import dagger.Component;
import org.example.pages.CataloguePage;
import org.example.pages.MainPage;
import org.example.pages.PaintingsByTypePage;
import org.openqa.selenium.WebDriver;

@Component(modules = PageModule.class)
public interface AppGraph {
    MainPage getMainPage();
    CataloguePage getCataloguePage();
    PaintingsByTypePage getPaintingsByTypePage();
}
