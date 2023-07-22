package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.Nullable;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MY_LOG", "MyService.onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("MY_LOG", "MyService.onStartCommand");
        final String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Log.e("MY_LOG", "Call number:" + number);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MY_LOG", "MyService.onBind");
        return null;
    }
}
