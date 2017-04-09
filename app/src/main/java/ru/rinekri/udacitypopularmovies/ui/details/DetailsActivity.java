package ru.rinekri.udacitypopularmovies.ui.details;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.rinekri.udacitypopularmovies.BuildConfig;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.ui.base.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;

public class DetailsActivity extends BaseMvpActivity<DetailsPM> implements DetailsView {

  private static final String EXTRA_MOVIE_SHORT_INFO = BuildConfig.APPLICATION_ID + ".extra_short_info";

  public static void start(Context context,
                           @NonNull MovieShortInfo movieShortInfo) {
    Intent intent = new Intent(context, DetailsActivity.class);
    intent.putExtra(EXTRA_MOVIE_SHORT_INFO, movieShortInfo);
    context.startActivity(intent);
  }


  @InjectPresenter
  public DetailsPresenter presenter;

  @ProvidePresenter
  public DetailsPresenter providePresenter() {
    MovieShortInfo shortInfo = getIntent().getParcelableExtra(EXTRA_MOVIE_SHORT_INFO);
    return new DetailsPresenter(shortInfo);
  }

  @Override
  protected ActivityConfig provideActivityConfig() {
    return ActivityConfig.builder()
      .contentRes(R.layout.content_details)
      .titleRes(R.string.main_title)
      .build();
  }
}