package com.syrnnik.geometryrush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class FiguresTypesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figures_types);
        setTitle(R.string.figures_types_title);
//        final String figureType = getIntent().getStringExtra("type");
//        assert figureType != null;
        final String figureType = getResources().getString(R.string.type_2d);

        // Typed Figures Lists
        final ScrollView flatFigures = findViewById(R.id.flatFigures);
        final ScrollView volumetricFigures = findViewById(R.id.volumetricFigures);

        // Show necessary figures
        if (figureType.equals(getResources().getString(R.string.type_2d))) { // 2D figures
            flatFigures.setVisibility(View.VISIBLE);
            volumetricFigures.setVisibility(View.GONE);
        } else if (figureType.equals(getResources().getString(R.string.type_3d))) { // 3D figures
            flatFigures.setVisibility(View.GONE);
            volumetricFigures.setVisibility(View.VISIBLE);
        }
    }

    public void openSettingMenu(View btn) {
        // Return Selected Figure
        String figureName = btn.getContentDescription().toString();
        final String figureType = getIntent().getStringExtra("type");
        Intent settingMenu = new Intent(FiguresTypesActivity.this, FigureSettingsActivity.class);
        // Send Selected Figure Name to Setting Menu Activity
        settingMenu.putExtra("figure", figureName);
        settingMenu.putExtra("type", figureType);
        startActivity(settingMenu);
    }
}