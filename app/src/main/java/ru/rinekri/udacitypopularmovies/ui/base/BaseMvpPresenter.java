package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.AsyncTask;

import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import java8.util.function.Consumer;
import java8.util.function.Supplier;
import java8.util.stream.StreamSupport;

abstract public class BaseMvpPresenter<V extends BaseMvpView<?>> extends MvpPresenter<V> {
  protected List<AsyncTask> networkRequests = new ArrayList<>();

  @Override
  protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    loadContent();
  }

  protected abstract void loadContent();

  @Override
  public void onDestroy() {
    StreamSupport
      .stream(networkRequests)
      .forEach((request) -> request.cancel(true));
    networkRequests.clear();
    super.onDestroy();
  }

  protected <RESULT> void makeRequest(Runnable beforeLoadingAction,
                                      Consumer<RESULT> afterLoadingAction,
                                      Supplier<RESULT> loadingAsyncAction,
                                      Consumer<Throwable> errorAction) {

    AsyncTask request = new NetworkRequest<>(beforeLoadingAction, afterLoadingAction, loadingAsyncAction, errorAction);
    networkRequests.add(request);
    request.execute();
  }

  public class NetworkRequest<RESULT> extends AsyncTask<Void, Object, RESULT> {
    private Runnable beforeLoadingAction1;
    private Consumer<RESULT> afterLoadingAction;
    private Supplier<RESULT> loadingAsyncAction;
    private Consumer<Throwable> errorAction;

    public NetworkRequest(Runnable beforeLoadingAction,
                          Consumer<RESULT> afterLoadingAction,
                          Supplier<RESULT> loadingAsyncAction,
                          Consumer<Throwable> errorAction) {
      this.beforeLoadingAction1 = beforeLoadingAction;
      this.loadingAsyncAction = loadingAsyncAction;
      this.afterLoadingAction = afterLoadingAction;
      this.errorAction = errorAction;
    }

    @Override
    protected void onPreExecute() {
      beforeLoadingAction1.run();
    }

    @Override
    protected RESULT doInBackground(Void... params) {
      try {
        return loadingAsyncAction.get();
      } catch (Exception ex) {
        errorAction.accept(ex);
      }
      return null;
    }

    @Override
    protected void onPostExecute(RESULT result) {
      if (result != null) {
        afterLoadingAction.accept(result);
      }
    }
  }
}