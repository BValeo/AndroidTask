package com.bvaleo.androidtask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private PostItemListener mListener;

    public ListAdapter(List<Film> mFilmLists, Context mContext, PostItemListener mListener) {
        this.mFilmLists = mFilmLists;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.name_rus)
        TextView nameRus;
        @BindView(R.id.name_eng)
        TextView nameEng;

        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Film film = getItem(getAdapterPosition());
            Toast.makeText(mContext,
                    film.getName(),
                    Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
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
        ViewHolder vh = new ViewHolder(view, this.mListener);

        return vh;

    }


    public interface PostItemListener {
        void onPostClick(long id);
    }

    public void updateAnswers(List<Film> items) {
        mFilmLists = items;
        notifyDataSetChanged();
    }

    private Film getItem(int adapterPosition) {
        return mFilmLists.get(adapterPosition);
    }
}
