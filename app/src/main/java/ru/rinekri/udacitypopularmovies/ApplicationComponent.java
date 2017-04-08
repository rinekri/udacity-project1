package ru.rinekri.udacitypopularmovies;

import android.content.Context;

import dagger.Component;
import ru.rinekri.udacitypopularmovies.annotations.ApplicationScope;
import ru.rinekri.udacitypopularmovies.network.NetworkModule;
import ru.rinekri.udacitypopularmovies.network.services.MainServiceApi;

@ApplicationScope
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
  Context context();
  MainServiceApi mainServiceApi();
}