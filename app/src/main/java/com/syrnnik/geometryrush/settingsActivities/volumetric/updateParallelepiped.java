package com.syrnnik.geometryrush.settingsActivities.volumetric;

import android.view.View;
import android.widget.CheckBox;

public class updateParallelepiped {

    public static void updateSettings(CheckBox[] allWithCheckBoxes, CheckBox[] allFindCheckBoxes, CheckBox[] allParamsCheckBoxes) {

        // All Sides
        if (allWithCheckBoxes[0].isChecked() && allWithCheckBoxes[1].isChecked() && allWithCheckBoxes[2].isChecked()) {
            // Find Perimeter
            if (!allWithCheckBoxes[4].isChecked()) { allFindCheckBoxes[4].setVisibility(View.VISIBLE); }
            // Find Volume
            if (!allWithCheckBoxes[6].isChecked()) { allFindCheckBoxes[6].setVisibility(View.VISIBLE); }
            // Find Diagonal
            if (!allWithCheckBoxes[7].isChecked()) { allFindCheckBoxes[7].setVisibility(View.VISIBLE); }
        }

        // Perimeter or Volume or Diagonal
        if (allWithCheckBoxes[4].isChecked() || allWithCheckBoxes[6].isChecked() || allWithCheckBoxes[7].isChecked()) {
            if (allWithCheckBoxes[0].isChecked() && allWithCheckBoxes[1].isChecked() && !allWithCheckBoxes[2].isChecked() ||
                allWithCheckBoxes[0].isChecked() && allParamsCheckBoxes[1].isChecked() && !allWithCheckBoxes[2].isChecked()) { allFindCheckBoxes[2].setVisibility(View.VISIBLE); }
            if (allWithCheckBoxes[0].isChecked() && !allWithCheckBoxes[1].isChecked() && allWithCheckBoxes[2].isChecked()) { allFindCheckBoxes[1].setVisibility(View.VISIBLE); }
            if (!allWithCheckBoxes[0].isChecked() && allWithCheckBoxes[1].isChecked() && allWithCheckBoxes[2].isChecked()) { allFindCheckBoxes[0].setVisibility(View.VISIBLE); }
        }
    }
}
