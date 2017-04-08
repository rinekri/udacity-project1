package ru.rinekri.udacitypopularmovies.ui.base;

import com.arellomobile.mvp.MvpPresenter;

abstract public class BaseMvpPresenter<V extends BaseMvpView<?>> extends MvpPresenter<V> {

  @Override
  protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    loadContent();
  }

  protected abstract void loadContent();
}