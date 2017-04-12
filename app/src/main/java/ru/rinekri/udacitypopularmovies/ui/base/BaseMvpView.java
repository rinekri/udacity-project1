package ru.rinekri.udacitypopularmovies.ui.base;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseMvpView<D> extends MvpView {
  void showViewContent(D data);
  void showLoading();
  void showEmpty();
  void showError(String message);
}