package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.ui.base.recycler_view.BaseSimpleAdapter;
import ru.rinekri.udacitypopularmovies.ui.base.recycler_view.BaseViewHolder;

public class MainAdapter extends BaseSimpleAdapter<MovieInfo, MainAdapter.MainViewHolder> {
  public MainAdapter(@LayoutRes Integer itemLayoutRes) {
    super(itemLayoutRes);
  }

  @Override
  protected MainViewHolder createViewHolder(View itemView) {
    return new MainViewHolder(itemView);
  }

  public class MainViewHolder extends BaseViewHolder<MovieInfo> {
    @BindView(R.id.movie_poster)
    ImageView poster;
    @BindView(R.id.movie_title)
    TextView title;

    public MainViewHolder(View itemView) {
      super(itemView);
    }

    @Override
    public void fill(MovieInfo item) {
      //TODO: Add error handling and placeholder showing
      Picasso
        .with(poster.getContext())
        .load(item.posterPath())
        .into(poster);

      title.setText(item.title());
    }
  }
}