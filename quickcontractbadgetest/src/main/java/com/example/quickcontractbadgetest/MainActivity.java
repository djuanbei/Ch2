package com.example.quickcontractbadgetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        QuickContactBadge badge = (QuickContactBadge) findViewById(R.id.quickContactBadge);
        badge.assignContactFromPhone("028-6666666", false);

    }
}
