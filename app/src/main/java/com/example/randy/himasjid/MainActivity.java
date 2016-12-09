package com.example.randy.himasjid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.randy.himasjid.notif.AlarmReceiver;


public class MainActivity extends AppCompatActivity {
    AlarmReceiver alarm = new AlarmReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarm.setAlarm(this);
        DigitalClock simpleDigitalClock = (DigitalClock) findViewById(R.id.digitalClock1);
        AnalogClock simpleAnalogClock = (AnalogClock) findViewById(R.id.analogClock1);

        ImageView btn1 = (ImageView) findViewById(R.id.buttonCariMasjid);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CariMasjidActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn2 = (ImageView) findViewById(R.id.buttonMasjidTerdekat);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MasjidTerdekatActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn3 = (ImageView) findViewById(R.id.buttonJadwalSholat);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JadwalSholatActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.buttonSetting);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn5 = (ImageView) findViewById(R.id.buttonTentangKami);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TentangKamiActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn6 = (ImageView) findViewById(R.id.buttonHelp);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notif, menu);
        return true;
    }
}

