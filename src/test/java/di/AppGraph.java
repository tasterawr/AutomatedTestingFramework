package di;

import dagger.Component;
import pages.CataloguePage;
import pages.MainPage;
import pages.PaintingsByTypePage;

@Component(modules = PageModule.class)
public interface AppGraph {
    MainPage getMainPage();
    CataloguePage getCataloguePage();
    PaintingsByTypePage getPaintingsByTypePage();
}
