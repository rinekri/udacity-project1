package ru.rinekri.udacitypopularmovies;

import dagger.Component;
import ru.rinekri.udacitypopularmovies.annotations.ApplicationScope;

@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

}