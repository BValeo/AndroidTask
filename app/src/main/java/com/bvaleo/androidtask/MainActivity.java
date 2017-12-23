package com.bvaleo.androidtask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bvaleo.androidtask.adapters.ListAdapter;
import com.bvaleo.androidtask.adapters.ListClickListener;
import com.bvaleo.androidtask.model.Film;
import com.bvaleo.androidtask.model.FilmList;
import com.bvaleo.androidtask.network.IFilmGetter;
import com.bvaleo.androidtask.util.ApiUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rec_view)
    public RecyclerView mRecView;
    private ListAdapter mAdapter;
    private IFilmGetter mGetter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mGetter = ApiUtils.getFilmGetter();
        mAdapter = new ListAdapter(new ArrayList<Film>(0), this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);

        mRecView.setLayoutManager(layoutManager);
        mRecView.setAdapter(mAdapter);
        mRecView.addOnItemTouchListener(getListener());
        mRecView.addItemDecoration(decoration);

        loadAnswers();

    }


    public void loadAnswers() {
        mGetter.getFilms().enqueue(new Callback<FilmList>() {
            @Override
            public void onResponse(Call<FilmList> call, Response<FilmList> response) {
                mAdapter.updateAnswers(response.body().getList());
                Toast.makeText(MainActivity.this,
                        response.body().getList().get(0).getNameEng(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<FilmList> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "ERROR",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    private ListClickListener getListener(){
        return new ListClickListener(MainActivity.this, mRecView, new ListClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Film film = mAdapter.getItem(position);
                Toast.makeText(MainActivity.this, film.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Film film = mAdapter.getItem(position);
                Toast.makeText(MainActivity.this, film.getNameEng(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
