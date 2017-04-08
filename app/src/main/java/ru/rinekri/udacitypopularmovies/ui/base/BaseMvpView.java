package ru.rinekri.udacitypopularmovies.ui.base;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface BaseMvpView<D> extends MvpView {
  void showContent(D data);
  void showLoading();
  void showEmpty();
  void showError(String message);
}