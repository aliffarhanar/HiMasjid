package com.example.randy.himasjid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DigitalClock simpleDigitalClock = (DigitalClock) findViewById(R.id.digitalClock1);
        AnalogClock simpleAnalogClock = (AnalogClock) findViewById(R.id.analogClock1);

        ImageButton btn1 = (ImageButton) findViewById(R.id.buttonCariMasjid);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CariMasjidActivity.class);
                startActivity(intent);
            }
        });
    }
}

