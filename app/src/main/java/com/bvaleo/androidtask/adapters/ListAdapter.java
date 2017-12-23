package com.bvaleo.androidtask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bvaleo.androidtask.R;
import com.bvaleo.androidtask.model.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Valery on 08.12.2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


    private List<Film> mFilmLists;
    private Context mContext;

    public ListAdapter(List<Film> mFilmLists, Context mContext) {
        this.mFilmLists = mFilmLists;
        this.mContext = mContext;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.name_rus)
        TextView nameRus;
        @BindView(R.id.name_eng)
        TextView nameEng;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film f = mFilmLists.get(position);

        holder.nameEng.setText(f.getNameEng());
        holder.nameRus.setText(f.getName());

        Picasso.with(this.mContext)
                .load(f.getImage())
                .resize(80, 80)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mFilmLists.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;

    }

    public void updateAnswers(List<Film> items) {
        mFilmLists = items;
        notifyDataSetChanged();
    }

    public Film getItem(int adapterPosition) {
        return mFilmLists.get(adapterPosition);
    }
}
