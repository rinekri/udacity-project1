package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import java8.util.function.Consumer;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.ui.base.recycler_view.BaseSimpleAdapter;
import ru.rinekri.udacitypopularmovies.ui.base.recycler_view.BaseViewHolder;

public class MainAdapter extends BaseSimpleAdapter<MovieInfo, MainAdapter.MainViewHolder> {
  @Nullable
  private Consumer<MovieInfo> onPosterClickAction;

  public MainAdapter(@LayoutRes Integer itemLayoutRes,
                     @Nullable Consumer<MovieInfo> onPosterClickAction) {
    super(itemLayoutRes);
    this.onPosterClickAction = onPosterClickAction;
  }

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

      itemView.setOnClickListener((view) -> {
        if (MainAdapter.this.onPosterClickAction != null) {
          MainAdapter.this.onPosterClickAction.accept(item);
        }
      });
    }
  }
}