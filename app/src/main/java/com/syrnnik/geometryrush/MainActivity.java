package com.syrnnik.geometryrush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);

    }

    public void startTypes(View view) { startActivity(new Intent(MainActivity.this, FigureSpacesActivity.class)); }
}