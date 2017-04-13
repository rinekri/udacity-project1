package ru.rinekri.udacitypopularmovies.ui.base;


import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.rinekri.udacitypopularmovies.ui.base.models.ErrorConfig;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface BaseMvpView<D> extends MvpView {
  void showViewContent(D data);
  void showLoading();
  void showEmpty(@Nullable @StringRes Integer messageRes);
  void showError(ErrorConfig errorConfig);
}