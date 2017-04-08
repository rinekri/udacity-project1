package ru.rinekri.udacitypopularmovies.ui.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class ActivityConfig {
  abstract Integer contentRes();
  abstract Integer titleRes();

  static Builder builder() {
    return new AutoValue_ActivityConfig.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder contentRes(@LayoutRes Integer value);
    abstract Builder titleRes(@StringRes Integer value);
    abstract ActivityConfig build();
  }
}