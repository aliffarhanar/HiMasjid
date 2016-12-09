package com.example.randy.himasjid;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.randy.himasjid.CariMasjid.detail_listmasjid;
import com.example.randy.himasjid.adapter.AdapterListDetailMasjid;
import com.example.randy.himasjid.entity.Lokasi;


import com.example.randy.himasjid.R;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class CariMasjidActivity extends ActionBarActivity implements OnItemClickListener  {

    private ListView lv;
    private List<Lokasi> listLokasi;
    private AdapterListDetailMasjid adapter;

    SearchView searchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);

        searchview = (SearchView) findViewById(R.id.search_view);

        // initialize view
        lv = (ListView) findViewById(R.id.list);

        // geneate some dummy data
        generateData();

        // instance adapter for list
        adapter = new AdapterListDetailMasjid(this, listLokasi);

        // set adapter to list
        lv.setAdapter(adapter);

        // set listener list
        lv.setOnItemClickListener(this);



    }

    /**
     * add some data, u can use data from sqlite or whatever..
     */
    private void generateData() {
        listLokasi = new ArrayList<Lokasi>();

        listLokasi.add(new Lokasi("Masjid Nur Rahman", -6.9544941,107.6376788, "Bandung", "Jalan Cijawura Hilir RT 06 RW 12"));
        listLokasi.add(new Lokasi("Masjid Al-Muawanah", -6.9272027,107.576117, "Bandung", "Jalan Batu Permata RT 03 RW 07"));
        listLokasi.add(new Lokasi("Masjid Nurul Huda",-6.9408069,107.6262366, "Bandung", "Jalan Margaasih RT 01 RW 10"));
        listLokasi.add(new Lokasi("Masjid Al-Hidayah", -6.9572307,107.6417259, "Bandung", "Jalan Margaasih RT 06 RW 10"));
        listLokasi.add(new Lokasi("Masjid Al-Muhajir", -6.923527,107.5742273, "Bandung", "Jalan Cibuntu RT. 04/ RW. 09 Kelurahan Warung Muncang Kecamatan Bandung Kulon"));
        listLokasi.add(new Lokasi("Masjid Nurul Huda", -6.9373156,107.582655, "Bandung", "Jalan Cibuntu RT. 07/ RW. 02 Kelurahan Warung Muncang Kecamatan Bandung Kulon."));
        listLokasi.add(new Lokasi("Masjid Al-Hulasoh", -6.9277301,107.5561454, "Bandung", "Jl.Cibuntu RT. 07/ RW. 06 Kelurahan Warung Muncang Kecamatan bandung Kulon "));
        listLokasi.add(new Lokasi("Masjid Mftahul hasanah", -6.930581,107.5708454, "Bandung", "Jl. Holis RT. 01/ RW. 01 Kelurahan Warung Muncang Kecamatan bandung Kulon "));
        listLokasi.add(new Lokasi("Masjid Al-Jihad Siliwangi", -6.9219279,107.5794182, "Bandung", "Jl. Suryani RT. 07/ RW. 01 Kelurahan Warung Muncang Kecamatan bandung Kulon"));
        listLokasi.add(new Lokasi("Masjid RIYAADHUL JANNAH", -6.6773011,107.6801059, "Bandung", "JL. PARAKAN SAAT II RT. 05/09 KEL. CISARANTEN ENDAH KEC. ARCAMANIK "));
        listLokasi.add(new Lokasi("Masjid Raya Bandung", -6.9217568,107.6043132, "Bandung", "Jl. Asia Afrika, Balonggede, Regol."));
        listLokasi.add(new Lokasi("Masjid Syamsul 'Ulum", -6.975712,107.6299653, "Bandung", "Jl. Sukabirus, Dayeuhkolot"));
        listLokasi.add(new Lokasi("Masjid Al Ukhuwah", -6.9107485,107.6063988, "Bandung", "Jl. Wastukencana No.27 Babakan Ciamis Sumur Bandung"));
        listLokasi.add(new Lokasi("Masjid Nurul Hikmah",-6.9882106,107.6803136, "Bandung", "JL. Ranca Lame, RT. 04/03, Bojongsoang."));
        listLokasi.add(new Lokasi("Masjid Al Mu'min",-6.9859854,107.6342898, "Bandung", "Griya bandung Asri 2 ( GBA ), Komplek 1, Jalan Tirtawangi Raya"));
        listLokasi.add(new Lokasi("Masjid Jami' al Barokah", -6.9720189,107.6533405, "Bandung", "Griya Bandung Asri 2, RT. 05/RW. 08, Cipagalo, "));
        listLokasi.add(new Lokasi("Masjid Al-Muttaqin", -6.9244125,107.5991088, "Bandung", "Jl. Diponegoro No.22, Citarum,"));
        listLokasi.add(new Lokasi("Masjid Baiturrahman GBI", -6.9411255,107.6070403, "Bandung", "Jl. Griya Bandung Indah, Buahbatu, "));
        listLokasi.add(new Lokasi("Masjid AL-HIDAYAH", -6.9764907,107.6325527, "Bandung", "JL. Bojongsoang, RT.07/2, Bojong Soang, Lengkong,"));
        listLokasi.add(new Lokasi("Masjid At Tawakal", -6.9783504,107.6842552, "Bandung", "JL. Sapan, RW. 09, Bojongsoang, Tegalluar"));

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
        Lokasi loc = (Lokasi) adapter.getItem(pos);
        startActivity(new Intent(this, detail_listmasjid.class).putExtra("object", loc));
    }


}


