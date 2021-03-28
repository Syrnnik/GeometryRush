package com.syrnnik.geometryrush.settingsActivities.flat;

import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class updateTriangle {

    public static void updateSettings(ArrayList<CheckBox> allWithCheckBoxes, ArrayList<CheckBox> allFindCheckBoxes, ArrayList<CheckBox> allParamsCheckBoxes) {

        // SideA or SideB or SideC
        if (allWithCheckBoxes.get(0).isChecked() || allWithCheckBoxes.get(1).isChecked() || allWithCheckBoxes.get(2).isChecked()) {
            // Perimeter
            if (allWithCheckBoxes.get(5).isChecked() && !allParamsCheckBoxes.get(0).isChecked()) {
                // SideA and SideB or Isosceles
                if (allWithCheckBoxes.get(0).isChecked() && (allWithCheckBoxes.get(1).isChecked() || allParamsCheckBoxes.get(1).isChecked())) {
                    // Find SideC
                    if (!allWithCheckBoxes.get(2).isChecked()) { allFindCheckBoxes.get(2).setVisibility(View.VISIBLE); }
                }
                // SideA and SideС and not Isosceles
                if (allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(2).isChecked() && !allParamsCheckBoxes.get(1).isChecked()) {
                    // Find SideB
                    if (!allWithCheckBoxes.get(1).isChecked()) { allFindCheckBoxes.get(1).setVisibility(View.VISIBLE); }
                }
                // SideC and SideB or Isosceles
                if (allWithCheckBoxes.get(2).isChecked() && (allWithCheckBoxes.get(1).isChecked() || allParamsCheckBoxes.get(1).isChecked())) {
                    // Find SideA
                    if (!allWithCheckBoxes.get(0).isChecked()) { allFindCheckBoxes.get(0).setVisibility(View.VISIBLE); }
                }
            }
            // Rectangular
            if (allParamsCheckBoxes.get(2).isChecked()) {
                // Isosceles or SideA and SideB
                if (allParamsCheckBoxes.get(1).isChecked() || (allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(1).isChecked())) {
                    // Find SideC
                    if (!allWithCheckBoxes.get(2).isChecked()) { allFindCheckBoxes.get(2).setVisibility(View.VISIBLE); }
                    // Find SideA
                    if (!allWithCheckBoxes.get(0).isChecked()) { allFindCheckBoxes.get(0).setVisibility(View.VISIBLE); }
                }
                // SideA and SideC
                if (allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(2).isChecked()) {
                    // Find SideB
                    if (!allWithCheckBoxes.get(1).isChecked()) { allFindCheckBoxes.get(1).setVisibility(View.VISIBLE); }
                }
                // SideB and SideC
                if (allWithCheckBoxes.get(1).isChecked() && allWithCheckBoxes.get(2).isChecked()) {
                    // Find SideA
                    if (!allWithCheckBoxes.get(0).isChecked()) { allFindCheckBoxes.get(0).setVisibility(View.VISIBLE); }
                }
            }
            // Area
            if (allWithCheckBoxes.get(6).isChecked()) {
                // Find Height
                if (!allWithCheckBoxes.get(9).isChecked()) { allFindCheckBoxes.get(9).setVisibility(View.VISIBLE); }
            }
            // Height
            if (allWithCheckBoxes.get(9).isChecked()) {
                // Find Area
                if (!allWithCheckBoxes.get(6).isChecked()) { allFindCheckBoxes.get(6).setVisibility(View.VISIBLE); }
            }
            // All Sides
            if ((allWithCheckBoxes.get(0).isChecked() && (allWithCheckBoxes.get(1).isChecked() || allParamsCheckBoxes.get(1).isChecked()) && allWithCheckBoxes.get(2).isChecked()) || allParamsCheckBoxes.get(0).isChecked()) {
                // Find Perimeter
                if (!allWithCheckBoxes.get(5).isChecked()) { allFindCheckBoxes.get(5).setVisibility(View.VISIBLE); }
            }
        }
    }
}
