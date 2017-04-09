package ru.rinekri.udacitypopularmovies.ui.details;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.ui.base.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;

public class DetailsActivity extends BaseMvpActivity<DetailsPM> implements DetailsView {
  @InjectPresenter
  public DetailsPresenter presenter;

  @ProvidePresenter
  public DetailsPresenter providePresenter() {
    return new DetailsPresenter();
  }

  @Override
  protected ActivityConfig provideActivityConfig() {
    return ActivityConfig.builder()
      .contentRes(R.layout.content_details)
      .titleRes(R.string.main_title)
      .build();
  }
}