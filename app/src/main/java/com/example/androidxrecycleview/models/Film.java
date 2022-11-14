package com.example.androidxrecycleview.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
private Integer ImgUser;
private String DecUser;
private String NameUser;

    public Film(String nameUser, String decUser, Integer imgUser) {
        this.ImgUser = imgUser;
        this.DecUser = decUser;
        this.NameUser = nameUser;
    }

    protected Film(Parcel in) {
        if (in.readByte() == 0) {
            ImgUser = null;
        } else {
            ImgUser = in.readInt();
        }
        DecUser = in.readString();
        NameUser = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public Integer getImgUser() {
        return ImgUser;
    }

    public String getDecUser() {
        return DecUser;
    }

    public String getNameUser() {
        return NameUser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (ImgUser == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(ImgUser);
        }
        parcel.writeString(DecUser);
        parcel.writeString(NameUser);
    }
}
