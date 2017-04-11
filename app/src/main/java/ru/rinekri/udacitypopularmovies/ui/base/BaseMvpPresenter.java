package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.AsyncTask;

import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import java8.util.function.Consumer;
import java8.util.stream.StreamSupport;
import ru.rinekri.udacitypopularmovies.ui.base.functions.UnsafeSupplier;
import timber.log.Timber;

abstract public class BaseMvpPresenter<D, V extends BaseMvpView<D>> extends MvpPresenter<V> {
  protected List<AsyncTask> networkRequests = new ArrayList<>();

  @Override
  public void onDestroy() {
    abortNetworkRequests();
    super.onDestroy();
  }

  protected void abortNetworkRequests() {
    StreamSupport
      .stream(networkRequests)
      .forEach((request) -> request.cancel(true));
    networkRequests.clear();
  }

  protected void elceNetworkRequest(UnsafeSupplier<D> loadingAction) {
    elceNetworkRequest(
      loadingAction,
      (error) -> getViewState().showError(error.getMessage()));
  }

  protected void elceNetworkRequest(UnsafeSupplier<D> loadingAction,
                                    Consumer<Throwable> errorAction) {
    networkRequest(
      () -> getViewState().showLoading(),
      (result) -> getViewState().showContent(result),
      loadingAction,
      errorAction);
  }

  protected void networkRequest(Runnable beforeLoadingAction,
                                Consumer<D> endLoadingAction,
                                UnsafeSupplier<D> loadingAction,
                                Consumer<Throwable> errorAction) {

    AsyncTask request = new NetworkRequest(beforeLoadingAction, endLoadingAction,
      loadingAction, errorAction);
    networkRequests.add(request);
    request.execute();
  }

  public class NetworkRequest extends AsyncTask<Object, Void, D> {
    private Runnable beforeLoadingAction1;
    private Consumer<D> endLoadingAction;
    private UnsafeSupplier<D> loadingAction;
    private Consumer<Throwable> errorAction;

    public NetworkRequest(Runnable beforeLoadingAction,
                          Consumer<D> endLoadingAction,
                          UnsafeSupplier<D> loadingAction,
                          Consumer<Throwable> errorAction) {
      this.beforeLoadingAction1 = beforeLoadingAction;
      this.loadingAction = loadingAction;
      this.endLoadingAction = endLoadingAction;
      this.errorAction = errorAction;
    }

    @Override
    protected void onPreExecute() {
      beforeLoadingAction1.run();
    }

    @Override
    protected D doInBackground(Object... params) {
      try {
        return loadingAction.get();
      } catch (Exception ex) {
        Timber.e("Loading error occurred: %s", ex.getMessage());
        errorAction.accept(ex);
      }
      return null;
    }

    @Override
    protected void onPostExecute(D result) {
      if (result != null) {
        endLoadingAction.accept(result);
      }
    }
  }
}