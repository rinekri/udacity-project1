package ru.rinekri.udacitypopularmovies.ui.base.recycler_view;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSimpleAdapter<D, VH extends BaseViewHolder<D>> extends RecyclerView.Adapter<VH> {
  private List<D> data = new ArrayList<>();
  @LayoutRes
  private Integer itemLayoutRes;

  public BaseSimpleAdapter(@LayoutRes Integer itemLayoutRes) {
    this.itemLayoutRes = itemLayoutRes;
  }

  public void swapContent(List<D> newData) {
    data.clear();
    data.addAll(newData);
    notifyDataSetChanged();
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayoutRes, parent, false);
    return createViewHolder(itemView);
  }

  protected abstract VH createViewHolder(View itemView);

  @Override
  public void onBindViewHolder(VH holder, int position) {
    holder.fill(data.get(position));
  }

  @Override
  public int getItemCount() {
    return data.size();
  }
}