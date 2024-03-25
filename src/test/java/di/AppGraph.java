package di;

import dagger.Component;
import pages.CataloguePage;
import pages.MainPage;
import pages.ProductsByTypePage;

@Component(modules = PageModule.class)
public interface AppGraph {
    MainPage getMainPage();
    CataloguePage getCataloguePage();
    ProductsByTypePage getPaintingsByTypePage();
}
