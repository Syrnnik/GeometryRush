package com.syrnnik.geometryrush.settingsActivities.flat;

import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class updateCircle {

    public static void updateSettings(ArrayList<CheckBox> allWithCheckBoxes, ArrayList<CheckBox> allFindCheckBoxes) {

        // Radius
        if (allWithCheckBoxes.get(4).isChecked()) {
            // Find Perimeter
            if (!allWithCheckBoxes.get(5).isChecked()) { allFindCheckBoxes.get(5).setVisibility(View.VISIBLE); }
            // Find Area
            if (!allWithCheckBoxes.get(6).isChecked()) { allFindCheckBoxes.get(6).setVisibility(View.VISIBLE); }
        }
        // Perimeter
        if (allWithCheckBoxes.get(5).isChecked()) {
            // Find Radius
            if (!allWithCheckBoxes.get(4).isChecked()) { allFindCheckBoxes.get(4).setVisibility(View.VISIBLE); }
            // Find Area
            if (!allWithCheckBoxes.get(6).isChecked()) { allFindCheckBoxes.get(6).setVisibility(View.VISIBLE); }
        }
        // Area
        if (allWithCheckBoxes.get(6).isChecked()) {
            // Find Radius
            if (!allWithCheckBoxes.get(4).isChecked()) { allFindCheckBoxes.get(4).setVisibility(View.VISIBLE); }
            // Find Perimeter
            if (!allWithCheckBoxes.get(5).isChecked()) { allFindCheckBoxes.get(5).setVisibility(View.VISIBLE); }
        }
    }
}
