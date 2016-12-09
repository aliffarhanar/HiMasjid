package com.example.randy.himasjid.entity;

/**
 * Created by RandyKhairuBasyar on 03/12/2016.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Lokasi implements Parcelable {
    private String name;
    private String kota;
    private String alamat;
    private Double lat;
    private Double lng;

    public Lokasi() {
        // TODO Auto-generated constructor stub
    }

    public Lokasi(Parcel in) {
        readFromParcel(in);
    }

    public Lokasi(String name, Double lat, Double lng,String kota,String alamat) {
        super();
        this.name = name;
        this.kota = kota;
        this.alamat = alamat;
        this.lat = lat;
        this.lng = lng;
    }

    public String getKota() {
        return kota;
    }
    public void setKota(String kota) {
        this.name = kota;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.name = alamat;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(kota);
        dest.writeString(alamat);
    }

    /**
     * read from parcel
     *
     * @param in
     */
    private void readFromParcel(Parcel in) {
        name = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();
        kota = in.readString();
        alamat = in.readString();
    }

    public static final Parcelable.Creator<Lokasi> CREATOR = new Parcelable.Creator<Lokasi>() {

        @Override
        public Lokasi createFromParcel(Parcel source) {
            return new Lokasi(source);
        }

        @Override
        public Lokasi[] newArray(int size) {
            return new Lokasi[size];
        }
    };


}
