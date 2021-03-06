package com.bvaleo.androidtask.model;

import com.google.gson.annotations.Expose;

import io.realm.RealmModel;

public class FilmList implements RealmModel {

    @Expose
    private java.util.List<Film> list = null;

    public java.util.List<Film> getList() {
        return list;
    }

    public void setList(java.util.List<Film> list) {
        this.list = list;
    }

}