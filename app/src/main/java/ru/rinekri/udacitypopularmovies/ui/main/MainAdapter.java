package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter<D> extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
  private List<D> data = new ArrayList<D>();

  public void swapContent(List<D> newData) {
    data.clear();
    data.addAll(newData);
    notifyDataSetChanged();
  }

  @Override
  public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //TODO: Add logic to create ViewHolder and bind them
    return null;
  }

  @Override
  public void onBindViewHolder(MainViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public class MainViewHolder extends RecyclerView.ViewHolder {
    public MainViewHolder(View itemView) {
      super(itemView);
    }
  }
}