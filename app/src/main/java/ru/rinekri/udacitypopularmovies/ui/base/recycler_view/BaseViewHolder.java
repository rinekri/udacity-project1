package ru.rinekri.udacitypopularmovies.ui.base.recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<D> extends RecyclerView.ViewHolder {
  public BaseViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(itemView);
    initItem();
  }

  protected void initItem() {}

  public abstract void fill(D item);
}