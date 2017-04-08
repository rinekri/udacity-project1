package ru.rinekri.udacitypopularmovies.ui.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ActivityConfig {
  public abstract Integer contentRes();
  public abstract Integer titleRes();

  public static Builder builder() {
    return new AutoValue_ActivityConfig.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder contentRes(@LayoutRes Integer value);
    public abstract Builder titleRes(@StringRes Integer value);
    public abstract ActivityConfig build();
  }
}