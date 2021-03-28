package com.syrnnik.geometryrush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FigureSpacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure_spaces);
        setTitle(R.string.app_name);

    }

    public void figuresTypes(View btn) {
        // Return Selected Figure Type
        String figureType = btn.getContentDescription().toString();
        Intent figuresTypes = new Intent(FigureSpacesActivity.this, FiguresTypesActivity.class);
//        if (figureType.equals(getResources().getString(R.string.type_2d))) { figuresTypes = new Intent(FigureSpacesActivity.this, Figures2DActivity.class); }
//        else if (figureType.equals(getResources().getString(R.string.type_3d))) { figuresTypes = new Intent(FigureSpacesActivity.this, Figures3DActivity.class); }
        // Send Selected Figure Type
        figuresTypes.putExtra("type", figureType);
        startActivity(figuresTypes);
    }
}