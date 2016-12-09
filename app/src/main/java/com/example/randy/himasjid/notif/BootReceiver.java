package com.example.randy.himasjid.notif;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/**
 * Created by RandyKhairuBasyar on 09/12/2016.
 */
public class BootReceiver extends BroadcastReceiver {
        AlarmReceiver alarm = new AlarmReceiver();
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
            {
                alarm.setAlarm(context);
            }
        }
    }
//END_INCLUDE(autostart)
