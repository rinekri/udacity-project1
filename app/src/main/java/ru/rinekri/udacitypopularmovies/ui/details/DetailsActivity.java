package ru.rinekri.udacitypopularmovies.ui.details;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import jp.wasabeef.picasso.transformations.BlurTransformation;
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

  @NonNull
  private MovieShortInfo getStartData() {
    return getIntent().getParcelableExtra(EXTRA_MOVIE_SHORT_INFO);
  }

  @BindView(R.id.backdrop)
  ImageView moviePoster;
  @BindView(R.id.details_release_date)
  TextView releaseDate;
  @BindView(R.id.details_vote_average)
  TextView voteAverage;
  @BindView(R.id.details_overview)
  TextView overview;

  @InjectPresenter
  public DetailsPresenter presenter;

  @ProvidePresenter
  public DetailsPresenter providePresenter() {
    return new DetailsPresenter(getStartData());
  }

  @Override
  protected ActivityConfig provideActivityConfig() {
    return ActivityConfig.builder()
      .contentRes(R.layout.content_details)
      .titleText(getStartData().title())
      .useBackButton(true)
      .build();
  }

  //TODO: Replace to actually MVP pattern
  @Override
  protected void initView() {
    Picasso
      .with(this)
      .load(getStartData().posterPath())
      .transform(new BlurTransformation(this))
      .into(moviePoster);

    voteAverage.setText(getStartData().voteAverage());
    overview.setText(getStartData().overview());
    releaseDate.setText(getStartData().releaseDate());
  }
}