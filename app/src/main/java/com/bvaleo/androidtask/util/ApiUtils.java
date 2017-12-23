package com.bvaleo.androidtask.util;

import com.bvaleo.androidtask.network.IFilmGetter;
import com.bvaleo.androidtask.network.RetrofitClient;

/**
 * Created by Valery on 13.12.2017.
 */

public class ApiUtils {
    public static IFilmGetter getFilmGetter(){
        return RetrofitClient.getClient(Constants.BASE_URL).create(IFilmGetter.class);
    }
}
