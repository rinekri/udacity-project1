package ru.rinekri.udacitypopularmovies;

import android.content.Context;

import dagger.Component;
import ru.rinekri.udacitypopularmovies.annotations.ApplicationScope;

@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
  Context context();
}