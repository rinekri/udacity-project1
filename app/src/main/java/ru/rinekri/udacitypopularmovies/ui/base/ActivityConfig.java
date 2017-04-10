package ru.rinekri.udacitypopularmovies.ui.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ActivityConfig {
  //TODO 1: Add logic to specify ELCE views
  //TODO 3: Add logic to inflate shell

  @NonNull
  public abstract Integer contentRes();
  @StringRes
  @NonNull
  public abstract Integer titleRes();
  @NonNull
  public abstract String titleText();
  public abstract Boolean useBackButton();

  public static Builder builder() {
    return new AutoValue_ActivityConfig.Builder()
      .titleRes(0)
      .titleText("")
      .useBackButton(false);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder contentRes(@LayoutRes @NonNull Integer value);
    public abstract Builder titleRes(@StringRes @NonNull Integer value);
    public abstract Builder titleText(@NonNull String value);
    public abstract Builder useBackButton(Boolean use);
    public abstract ActivityConfig build();
  }
}