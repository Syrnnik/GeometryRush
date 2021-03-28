package com.syrnnik.geometryrush.settingsActivities.flat;

import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class updateRectangle {

    public static void updateSettings(ArrayList<CheckBox> allWithCheckBoxes, ArrayList<CheckBox> allFindCheckBoxes, ArrayList<CheckBox> allParamsCheckBoxes) {

        // SideA or SideB
        if (allWithCheckBoxes.get(0).isChecked() || allWithCheckBoxes.get(1).isChecked()) {
            // Both Sides
            // Or Rectangle -> Square
            if (allWithCheckBoxes.get(0).isChecked() && (allWithCheckBoxes.get(1).isChecked() || allParamsCheckBoxes.get(0).isChecked())) {
                // Find Perimeter
                if (!allWithCheckBoxes.get(5).isChecked()) { allFindCheckBoxes.get(5).setVisibility(View.VISIBLE); }
                // Find Area
                if (!allWithCheckBoxes.get(6).isChecked()) { allFindCheckBoxes.get(6).setVisibility(View.VISIBLE); }
                // Find Diagonal
                if (!allWithCheckBoxes.get(8).isChecked()) { allFindCheckBoxes.get(8).setVisibility(View.VISIBLE); }
            }
            // Perimeter
            if (allWithCheckBoxes.get(5).isChecked()) {
                // Find Area
                if (!allWithCheckBoxes.get(6).isChecked()) { allFindCheckBoxes.get(6).setVisibility(View.VISIBLE); }
            }
            // Area
            if (allWithCheckBoxes.get(6).isChecked()) {
                // Find Area
                if (!allWithCheckBoxes.get(5).isChecked()) { allFindCheckBoxes.get(5).setVisibility(View.VISIBLE); }
            }
        }
        // Perimeter or Area or Diagonal
        if (allWithCheckBoxes.get(5).isChecked() || allWithCheckBoxes.get(6).isChecked() || allWithCheckBoxes.get(8).isChecked()) {
            // SideA
            // Rectangle -> Square
            if (allWithCheckBoxes.get(0).isChecked() && !allWithCheckBoxes.get(1).isChecked() && !allParamsCheckBoxes.get(0).isChecked()) {
                // Find SideB
                if (!allWithCheckBoxes.get(1).isChecked()) { allFindCheckBoxes.get(1).setVisibility(View.VISIBLE); }
            }
            // SideB
            if ((!allWithCheckBoxes.get(0).isChecked() && allWithCheckBoxes.get(1).isChecked()) || allParamsCheckBoxes.get(0).isChecked()) {
                // Find SideA
                if (!allWithCheckBoxes.get(0).isChecked()) { allFindCheckBoxes.get(0).setVisibility(View.VISIBLE); }
            }
            // Perimeter and Area
            if (allWithCheckBoxes.get(5).isChecked() && allWithCheckBoxes.get(6).isChecked()) {
                if (!allWithCheckBoxes.get(0).isChecked()) { allFindCheckBoxes.get(0).setVisibility(View.VISIBLE); }
                if (!allWithCheckBoxes.get(1).isChecked()) { allFindCheckBoxes.get(1).setVisibility(View.VISIBLE); }
            }
        }
    }
}
