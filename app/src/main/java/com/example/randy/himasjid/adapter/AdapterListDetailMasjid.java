package com.example.randy.himasjid.adapter;

/**
 * Created by RandyKhairuBasyar on 03/12/2016.
 */
import java.util.List;

import com.example.randy.himasjid.R;
import com.example.randy.himasjid.entity.Lokasi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterListDetailMasjid extends BaseAdapter {

    private List<Lokasi> listLokasi;
    private LayoutInflater inflater;

    public AdapterListDetailMasjid(Context context, List<Lokasi> listLokasi) {
        this.listLokasi = listLokasi;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listLokasi.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listLokasi.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    static class Holder {
        TextView name, lat, lng, kota, alamat;
        ImageView thumb;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        Holder holder;
        if (view == null) {
            holder = new Holder();

            view = inflater.inflate(R.layout.item_list, parent, false);

            holder.name = (TextView) view.findViewById(R.id.item_title);
            holder.lat = (TextView) view.findViewById(R.id.item_lat);
            holder.lng = (TextView) view.findViewById(R.id.item_lng);
            holder.thumb = (ImageView) view.findViewById(R.id.item_thumbnail);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        holder.name.setText(listLokasi.get(pos).getName());
        holder.lat.setText("Kota : " + listLokasi.get(pos).getKota());
        holder.lng.setText("Alamat : " + listLokasi.get(pos).getAlamat());
        holder.thumb.setImageResource(R.drawable.icon_mosquelocator);

        return view;
    }

}
