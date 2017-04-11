package ru.rinekri.udacitypopularmovies.ui.base;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.google.auto.value.AutoValue;

import ru.rinekri.udacitypopularmovies.R;

@AutoValue
public abstract class ActivityConfig {
  //TODO: Add logic to inflate shell
  @NonNull
  public abstract Integer contentRes();
  @StringRes
  @NonNull
  public abstract Integer titleRes();
  @NonNull
  public abstract String titleText();
  @NonNull
  public abstract Boolean useBackButton();
  @NonNull
  public abstract Integer errorViewId();
  @NonNull
  public abstract Integer emptyViewId();
  @NonNull
  public abstract Integer progressViewId();

  public static Builder builder() {
    return new AutoValue_ActivityConfig.Builder()
      .titleRes(0)
      .titleText("")
      .useBackButton(false)
      .errorViewId(R.id.error_view)
      .emptyViewId(R.id.empty_view)
      .progressViewId(R.id.progress_view);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder contentRes(@LayoutRes @NonNull Integer value);
    public abstract Builder titleRes(@StringRes @NonNull Integer value);
    public abstract Builder titleText(@NonNull String value);
    public abstract Builder useBackButton(@NonNull Boolean use);
    public abstract Builder errorViewId(@NonNull @IdRes Integer layoutId);
    public abstract Builder emptyViewId(@NonNull @IdRes Integer layoutId);
    public abstract Builder progressViewId(@NonNull @IdRes Integer layoutId);
    public abstract ActivityConfig build();
  }
}