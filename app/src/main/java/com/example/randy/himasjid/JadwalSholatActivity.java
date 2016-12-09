package com.example.randy.himasjid;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class JadwalSholatActivity extends Activity {
    PrayTime prayers;

    TextView mFajr, mSunrise, mDhuhr, mAsr, mSunset, mIsha, mDate;
    RelativeLayout mlayoutDate;

    double timezone;

    double latitude = -6.973434;
    double longitude = 107.635021;

    int year, month, day;

    public String[] months = { "Januari", "Februari", "March", "April",
            "Mei", "Juni", "Juli", "Augustus", "September", "Oktober",
            "November", "Desember" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_sholat);

        mFajr		= (TextView) findViewById(R.id.fajr_value);
        mSunrise	= (TextView) findViewById(R.id.Sunrise_value);
        mDhuhr		= (TextView) findViewById(R.id.Dhuhr_value);
        mAsr		= (TextView) findViewById(R.id.Asr_value);
        mSunset		= (TextView) findViewById(R.id.Sunset_value);
        mIsha		= (TextView) findViewById(R.id.Isha_value);
        mDate		= (TextView) findViewById(R.id.date_value);
        mlayoutDate	= (RelativeLayout) findViewById(R.id.layout_date);

        timezone = (Calendar.getInstance().getTimeZone().getOffset(Calendar.getInstance().getTimeInMillis())) / (1000 * 60 * 60);

        prayers	 = new PrayTime();

        prayers.setTimeFormat(prayers.Time24);
        prayers.setCalcMethod(prayers.Makkah);
        prayers.setAsrJuristic(prayers.Shafii);
        prayers.setAdjustHighLats(prayers.MidNight);
        prayers.setTimeZone(prayers.getTimeZone());

        prayers.setFajrAngle(20.0);
        prayers.setIshaAngle(18.0);

        int[] offsets = { 2, 2, 2, 2, 2, 2, 2 };
        prayers.tune(offsets);

        Calendar cal	= Calendar.getInstance();
        year			= cal.get(Calendar.YEAR);
        month			= cal.get(Calendar.MONTH);
        day				= cal.get(Calendar.DAY_OF_MONTH);

        ShowPrayTime(year, month, day);

        mlayoutDate.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
    }

    private void ShowPrayTime(int year, int month, int day) {

        ArrayList<String> prayerTimes = prayers.getPrayerTimes(year, month, day, latitude, longitude, timezone);

        mFajr.setText(prayerTimes.get(0));
        mSunrise.setText(prayerTimes.get(1));
        mDhuhr.setText(prayerTimes.get(2));
        mAsr.setText(prayerTimes.get(3));
        mSunset.setText(prayerTimes.get(4));
        mIsha.setText(prayerTimes.get(6));

        mDate.setText(day + " " + months[month] + " " + year);
    }

    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            ShowPrayTime(selectedYear, selectedMonth, selectedDay);

            year	= selectedYear;
            month	= selectedMonth;
            day		= selectedDay;

        }
    };

}
