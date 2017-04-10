package ru.rinekri.udacitypopularmovies.ui.main;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpView;

public interface MainView extends BaseMvpView<MainPM> {
  @StateStrategyType(OneExecutionStateStrategy.class)
  void showMessage(String text);
}