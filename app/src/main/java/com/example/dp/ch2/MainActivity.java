package com.example.dp.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout);
    }

    public void run(View view) {
        TextView tv = (TextView) findViewById(R.id.textShow);
        tv.setText("你好!");
    }
}
