package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import java8.util.function.Consumer;
import java8.util.stream.StreamSupport;
import ru.rinekri.udacitypopularmovies.ui.base.functions.UnsafeSupplier;
import ru.rinekri.udacitypopularmovies.ui.base.models.NetworkRequestWrapper;
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

  protected void elceNetworkRequestL(UnsafeSupplier<D> onLoad) {
    elceNetworkRequestLE(
      onLoad,
      (error) -> getViewState().showError(error.getMessage())
    );
  }

  protected void elceNetworkRequestLS(UnsafeSupplier<D> onLoad,
                                      Consumer<D> onSuccess) {
    networkRequest(
      () -> getViewState().showLoading(),
      onSuccess,
      onLoad,
      (error) -> getViewState().showError(error.getMessage()));
  }

  protected void elceNetworkRequestLE(UnsafeSupplier<D> onLoad,
                                      Consumer<Throwable> onError) {
    networkRequest(
      () -> getViewState().showLoading(),
      (result) -> getViewState().showViewContent(result),
      onLoad,
      onError);
  }

  protected void networkRequest(Runnable onPrepare,
                                Consumer<D> onSuccess,
                                UnsafeSupplier<D> onLoad,
                                Consumer<Throwable> onError) {

    AsyncTask request = new NetworkRequest(
      onPrepare,
      onSuccess,
      () -> NetworkRequestWrapper.create(onLoad.get(), null),
      onError
    );
    networkRequests.add(request);
    request.execute();
  }

  public class NetworkRequest extends AsyncTask<Object, Void, NetworkRequestWrapper<D>> {
    private Runnable onPrepare;
    private Consumer<D> onSuccess;
    private UnsafeSupplier<NetworkRequestWrapper<D>> onLoad;
    private Consumer<Throwable> onError;

    public NetworkRequest(Runnable onPrepare,
                          Consumer<D> onSuccess,
                          UnsafeSupplier<NetworkRequestWrapper<D>> onLoad,
                          Consumer<Throwable> onError) {
      this.onPrepare = onPrepare;
      this.onLoad = onLoad;
      this.onSuccess = onSuccess;
      this.onError = onError;
    }

    @Override
    protected void onPreExecute() {
      onPrepare.run();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected NetworkRequestWrapper<D> doInBackground(Object... params) {
      try {
        return onLoad.get();
      } catch (Exception ex) {
        return NetworkRequestWrapper.create(null, ex);
      }
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    @Override
    protected void onPostExecute(@NonNull NetworkRequestWrapper<D> result) {
      if (result.data() != null) {
        onSuccess.accept(result.data());
      } else if (result.error() != null) {
        Timber.e("Loading error occurred: %s", result.error().getMessage());
        onError.accept(result.error());
      }
    }
  }
}