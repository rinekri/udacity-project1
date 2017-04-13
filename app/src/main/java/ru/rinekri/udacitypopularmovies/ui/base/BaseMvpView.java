package ru.rinekri.udacitypopularmovies.ui.base;


import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;

public interface BaseMvpView<D> extends MvpView {
  void showViewContent(D data);
  void showLoading();
  void showEmpty(@Nullable @StringRes Integer messageRes);
  void showError(@Nullable String message);
}