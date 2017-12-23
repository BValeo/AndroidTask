package com.bvaleo.androidtask.network;

import com.bvaleo.androidtask.model.FilmList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Valery on 13.12.2017.
 */

public interface IFilmGetter {
    @GET("/v2/57cffac8260000181e650041")
    Call<FilmList> getFilms();
}
