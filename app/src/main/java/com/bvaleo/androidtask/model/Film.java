package com.bvaleo.androidtask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmModel;

public class Film implements Parcelable, RealmModel {

    @Expose
    private String image;
    @Expose
    private String name;
    @SerializedName("name_eng")
    @Expose
    private String nameEng;
    @Expose
    private String premiere;
    @Expose
    private String description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeString(this.name);
        dest.writeString(this.nameEng);
        dest.writeString(this.premiere);
        dest.writeString(this.description);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.image = in.readString();
        this.name = in.readString();
        this.nameEng = in.readString();
        this.premiere = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };



}