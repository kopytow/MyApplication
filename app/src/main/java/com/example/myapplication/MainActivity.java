package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("MY_LOG", "MainActivity.onCreate");
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_launch).setOnClickListener(view -> {
            final Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("KEY_STRING", "Hello word!");
            startActivity(intent);
        });
        findViewById(R.id.button_launch_service).setOnClickListener(view -> {
            final Intent intent = new Intent(MainActivity.this, MyService.class);
            startService(intent);
            bindService(intent, new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {

                }
            }, Context.BIND_AUTO_CREATE);
        });
        findViewById(R.id.button_explore_contacts).setOnClickListener(view -> {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                final Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null);
                if (cursor != null) {
//                    int rows = cursor.getCount();
                    if (cursor.isBeforeFirst()) cursor.moveToNext();
                    do {
//                    for (int i = 0; i < rows; i++) {
                        int index = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                        final String name = cursor.getString(index);
                        Log.e("MY_CONTACTS", "Name = " + name);
//                        cursor.moveToNext();
                    } while (cursor.moveToNext());
                    cursor.close();
                }
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MY_LOG", "MainActivity.onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MY_LOG", "MainActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MY_LOG", "MainActivity.onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MY_LOG", "MainActivity.onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MY_LOG", "MainActivity.onResume");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}