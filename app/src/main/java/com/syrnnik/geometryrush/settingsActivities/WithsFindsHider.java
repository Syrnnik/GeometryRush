package com.syrnnik.geometryrush.settingsActivities;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.syrnnik.geometryrush.FigureSettingsActivity;
import com.syrnnik.geometryrush.FiguresTypesActivity;
import com.syrnnik.geometryrush.R;

import java.util.ArrayList;

public class WithsFindsHider extends FigureSettingsActivity {

    public static void hideWithsFinds(ArrayList<CheckBox> allWithCheckBoxes, ArrayList<CheckBox> allFindCheckBoxes) {

        // Hide Known Finds
        for (CheckBox with : allWithCheckBoxes) {
            if (allFindCheckBoxes.get(allWithCheckBoxes.indexOf(with)).isChecked()) { with.setVisibility(View.GONE); }
        }
    }

    public static void hideSides(ArrayList<CheckBox> allWithCheckBoxes, ArrayList<CheckBox> allParamsCheckBoxes, String selectedFigure, ArrayList<String> figures, String type, ArrayList<String> types, ImageView figureImage) {

        // Hide Unnecessary Elements
        allWithCheckBoxes.get(10).setVisibility(View.GONE);
        // For 2D figures
        if (type.equals(types.get(0))) {
            allWithCheckBoxes.get(4).setVisibility(View.GONE);
            allWithCheckBoxes.get(7).setVisibility(View.GONE);
            allWithCheckBoxes.get(8).setVisibility(View.GONE);
            allWithCheckBoxes.get(10).setVisibility(View.GONE);

            // For Rectangle
            if (selectedFigure.equals(figures.get(0))) {
                figureImage.setImageResource(R.drawable.rectangle_image);

                allWithCheckBoxes.get(2).setVisibility(View.GONE);
                allWithCheckBoxes.get(3).setVisibility(View.GONE);
                allWithCheckBoxes.get(8).setVisibility(View.VISIBLE);
                allWithCheckBoxes.get(9).setVisibility(View.GONE);

                // Rectangle -> Square
                // Equilateral
                if (allParamsCheckBoxes.get(0).isChecked()) {
                    figureImage.setImageResource(R.drawable.rectangle_equilateral_image);

                    allWithCheckBoxes.get(1).setVisibility(View.GONE);
                }

                allParamsCheckBoxes.get(0).setVisibility(View.VISIBLE);
            }
            // For Triangle
            else if (selectedFigure.equals(figures.get(1))) {
                figureImage.setImageResource(R.drawable.triangle_image);

                allWithCheckBoxes.get(3).setVisibility(View.GONE);


                // Rectangular
                if (allParamsCheckBoxes.get(2).isChecked()) {
                    figureImage.setImageResource(R.drawable.triangle_rectangular_image);
                }
                // Isosceles
                if (allParamsCheckBoxes.get(1).isChecked()) {
                    figureImage.setImageResource(R.drawable.triangle_isosceles_image);

                    allWithCheckBoxes.get(1).setVisibility(View.GONE);
                }
                // Equilateral
                if (allParamsCheckBoxes.get(0).isChecked()) {
                    figureImage.setImageResource(R.drawable.triangle_equilateral_image);

                    allWithCheckBoxes.get(1).setVisibility(View.GONE);
                    allWithCheckBoxes.get(2).setVisibility(View.GONE);
                }

                for (CheckBox checkbox : allParamsCheckBoxes) { checkbox.setVisibility(View.VISIBLE); }
            }
            // For Trapeze
            else if (selectedFigure.equals(figures.get(2))) {
                figureImage.setImageResource(R.drawable.trapeze_image);

                // Rectangular
                if (allParamsCheckBoxes.get(2).isChecked()) {
                    figureImage.setImageResource(R.drawable.trapeze_rectangular_image);
                }
                // Isosceles
                if (allParamsCheckBoxes.get(1).isChecked()) {
                    figureImage.setImageResource(R.drawable.trapeze_isosceles_image);

                    allWithCheckBoxes.get(3).setVisibility(View.GONE);
                }

                allParamsCheckBoxes.get(1).setVisibility(View.VISIBLE);
                allParamsCheckBoxes.get(2).setVisibility(View.VISIBLE);
            }
            // For Parallelogram
            else if (selectedFigure.equals(figures.get(3))) {
                figureImage.setImageResource(R.drawable.parallelogram_image);

                allWithCheckBoxes.get(2).setVisibility(View.GONE);
                allWithCheckBoxes.get(3).setVisibility(View.GONE);

                // Equilateral
                if (allParamsCheckBoxes.get(0).isChecked()) {
                    figureImage.setImageResource(R.drawable.parallelogram_equilateral_image);

                    allWithCheckBoxes.get(1).setVisibility(View.GONE);
                }

                allParamsCheckBoxes.get(0).setVisibility(View.VISIBLE);
            }
            // For Circle
            else if (selectedFigure.equals(figures.get(4))) {
                figureImage.setImageResource(R.drawable.rectangle_image);

                for (CheckBox with : allWithCheckBoxes) { with.setVisibility(View.GONE); }
                allWithCheckBoxes.get(4).setVisibility(View.VISIBLE);
                allWithCheckBoxes.get(5).setVisibility(View.VISIBLE);
                allWithCheckBoxes.get(6).setVisibility(View.VISIBLE);

                for (CheckBox check : allParamsCheckBoxes) { check.setVisibility(View.GONE); }
            }
        }
        // For 3D figures
//        else if (type.equals(types.get(1))) {
//            // Parallelepiped
//            if (selectedFigure.equals(figures.get(6))) {
//                allWithCheckBoxes.get(3).setVisibility(View.GONE);
//                allWithCheckBoxes.get(6).setVisibility(View.GONE);
//                allWithCheckBoxes.get(10).setVisibility(View.GONE);
//
//                allParamsCheckBoxes.get(2).setVisibility(View.GONE);
//            }
//            // Tetrahedron
//            else if (selectedFigure.equals(figures.get(7))) {
//                allWithCheckBoxes.get(3).setVisibility(View.GONE);
//                allWithCheckBoxes.get(6).setVisibility(View.GONE);
//                allWithCheckBoxes.get(10).setVisibility(View.GONE);
//
//                allParamsCheckBoxes.get(0).setVisibility(View.GONE);
//                allParamsCheckBoxes.get(1).setVisibility(View.GONE);
//                allParamsCheckBoxes.get(2).setVisibility(View.GONE);
//            }
//            // Pyramid
//            else if (selectedFigure.equals(figures.get(8))) {
//                allWithCheckBoxes.get(6).setVisibility(View.GONE);
//                allWithCheckBoxes.get(8).setVisibility(View.GONE);
//                allWithCheckBoxes.get(10).setVisibility(View.GONE);
//
//                allParamsCheckBoxes.get(1).setVisibility(View.GONE);
//                allParamsCheckBoxes.get(2).setVisibility(View.GONE);
//            }
//            // Sphere
//            else if (selectedFigure.equals(figures.get(10))) {
//                for (CheckBox with : allWithCheckBoxes) {
//                    if (allWithCheckBoxes.get(5) != with && allWithCheckBoxes.get(7) != with && allWithCheckBoxes.get(4) != with) {
//                        with.setVisibility(View.GONE);
//                    }
//                }
//                allWithCheckBoxes.get(4).setVisibility(View.VISIBLE);
//
//                for (CheckBox check : allParamsCheckBoxes) { check.setVisibility(View.GONE); }
//            }
//        }
    }
}
