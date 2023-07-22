package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Intent intent = getIntent();
        if (null != intent) {
            final String str = intent.getStringExtra("KEY_STRING");
            if (str != null) {
                TextView textView = findViewById(R.id.text_view);
                textView.setText(str);
            }
        }
    }
}
