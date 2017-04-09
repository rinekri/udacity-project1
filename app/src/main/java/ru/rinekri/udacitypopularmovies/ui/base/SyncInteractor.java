package ru.rinekri.udacitypopularmovies.ui.base;

import android.support.annotation.NonNull;

public interface SyncInteractor<PARAMS, RESULT> {
  RESULT getData(@NonNull PARAMS params) throws Exception;
}