package com.syrnnik.geometryrush.settingsActivities.flat;

import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class updateTrapeze {

    public static void updateSettings(ArrayList<CheckBox> allWithCheckBoxes, ArrayList<CheckBox> allFindCheckBoxes, ArrayList<CheckBox> allParamsCheckBoxes) {

        // SideA or SideB or SideC or SideD is Known
        if (allWithCheckBoxes.get(0).isChecked() || allWithCheckBoxes.get(1).isChecked() || allWithCheckBoxes.get(2).isChecked() || allWithCheckBoxes.get(3).isChecked()) {
            // All Sides
            if (allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(1).isChecked() && allWithCheckBoxes.get(2).isChecked() && (allWithCheckBoxes.get(3).isChecked() || allParamsCheckBoxes.get(1).isChecked())) {
                // Find Perimeter
                if (!allWithCheckBoxes.get(5).isChecked()) { allFindCheckBoxes.get(5).setVisibility(View.VISIBLE); }
            }
            // Sides and Height
            if (allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(1).isChecked() && allWithCheckBoxes.get(9).isChecked()) {
                // Find Area
                if (!allWithCheckBoxes.get(6).isChecked()) { allFindCheckBoxes.get(6).setVisibility(View.VISIBLE); }
            }
            // Sides and Area
            if (allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(1).isChecked() && allWithCheckBoxes.get(6).isChecked()) {
                // Find Height
                if (!allWithCheckBoxes.get(9).isChecked()) { allFindCheckBoxes.get(9).setVisibility(View.VISIBLE); }
            }
            // Perimeter
            if (allWithCheckBoxes.get(5).isChecked()) {
                // Find SideD
                if (allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(1).isChecked() && allWithCheckBoxes.get(2).isChecked() && !allWithCheckBoxes.get(3).isChecked() && !allParamsCheckBoxes.get(1).isChecked()) { allFindCheckBoxes.get(3).setVisibility(View.VISIBLE); }
                // Find SideC
                if (allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(1).isChecked() && !allWithCheckBoxes.get(2).isChecked() &&
                        ((allWithCheckBoxes.get(3).isChecked() && !allParamsCheckBoxes.get(1).isChecked()) || allParamsCheckBoxes.get(1).isChecked())) { allFindCheckBoxes.get(2).setVisibility(View.VISIBLE); }
                // Find SideB
                if (allWithCheckBoxes.get(0).isChecked() && !allWithCheckBoxes.get(1).isChecked() && allWithCheckBoxes.get(2).isChecked() && allWithCheckBoxes.get(3).isChecked()) { allFindCheckBoxes.get(1).setVisibility(View.VISIBLE); }
                // Find SideA
                if (!allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(1).isChecked() && allWithCheckBoxes.get(2).isChecked() && allWithCheckBoxes.get(3).isChecked()) { allFindCheckBoxes.get(0).setVisibility(View.VISIBLE); }
            }
            // Area
            if (allWithCheckBoxes.get(6).isChecked()) {
                // Find Height
                if (allWithCheckBoxes.get(1).isChecked() && allWithCheckBoxes.get(6).isChecked() && !allWithCheckBoxes.get(9).isChecked()) { allFindCheckBoxes.get(9).setVisibility(View.VISIBLE); }
                // Height
                if (allWithCheckBoxes.get(9).isChecked()) {
                    // Find SideA or SideB
                    if (!allWithCheckBoxes.get(0).isChecked()) { allFindCheckBoxes.get(0).setVisibility(View.VISIBLE); }
                    else if (!allWithCheckBoxes.get(1).isChecked()) { allFindCheckBoxes.get(1).setVisibility(View.VISIBLE); }
                }
            }
        }
    }
}
