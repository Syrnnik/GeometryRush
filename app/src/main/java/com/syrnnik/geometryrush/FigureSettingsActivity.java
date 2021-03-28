package com.syrnnik.geometryrush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.syrnnik.geometryrush.settingsActivities.WithsFindsHider;
import com.syrnnik.geometryrush.settingsActivities.flat.updateCircle;
import com.syrnnik.geometryrush.settingsActivities.flat.updateParallelogram;
import com.syrnnik.geometryrush.settingsActivities.flat.updateRectangle;
import com.syrnnik.geometryrush.settingsActivities.flat.updateTrapeze;
import com.syrnnik.geometryrush.settingsActivities.flat.updateTriangle;

import java.util.ArrayList;

public class FigureSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String selectedFigure = getIntent().getStringExtra("figure");
        assert selectedFigure != null;
        setTitle(selectedFigure + " " + getResources().getString(R.string.figures_settings_title));
        setContentView(R.layout.activity_figure_settings);
//        final String figureType = getIntent().getStringExtra("type");
//        assert figureType != null;
        final String figureType = getResources().getString(R.string.type_2d);

        final ImageView figureImage = findViewById(R.id.figure_image);

        final ArrayList<String> figures = new ArrayList<>();
        figures.add(getResources().getString(R.string.rectangle_btn_text));
        figures.add(getResources().getString(R.string.triangle_btn_text));
        figures.add(getResources().getString(R.string.trapeze_btn_text));
        figures.add(getResources().getString(R.string.parallelogram_btn_text));
        figures.add(getResources().getString(R.string.circle_btn_text));
        figures.add(getResources().getString(R.string.parallelepiped_btn_text));
        figures.add(getResources().getString(R.string.tetrahedron_btn_text));
        figures.add(getResources().getString(R.string.pyramid_btn_text));
        figures.add(getResources().getString(R.string.sphere_btn_text));

        final ArrayList<String> figuresTypes = new ArrayList<>();
        figuresTypes.add(getResources().getString(R.string.type_2d));
        figuresTypes.add(getResources().getString(R.string.type_3d));

        final ArrayList<String> elements = new ArrayList<>();
        elements.add(getResources().getString(R.string.sideA));
        elements.add(getResources().getString(R.string.sideB));
        elements.add(getResources().getString(R.string.sideC));
        elements.add(getResources().getString(R.string.sideD));
        elements.add(getResources().getString(R.string.radius));
        elements.add(getResources().getString(R.string.perimeter));
        elements.add(getResources().getString(R.string.area));
        elements.add(getResources().getString(R.string.volume));
        elements.add(getResources().getString(R.string.diagonal));
        elements.add(getResources().getString(R.string.height));
        elements.add(getResources().getString(R.string.median));

        // Checkboxes What Known
        CheckBox withSideACheckbox = findViewById(R.id.with_sideA_checkbox);
        CheckBox withSideBCheckbox = findViewById(R.id.with_sideB_checkbox);
        CheckBox withSideCCheckbox = findViewById(R.id.with_sideC_checkbox);
        CheckBox withSideDCheckbox = findViewById(R.id.with_sideD_checkbox);
        CheckBox withRadiusCheckbox = findViewById(R.id.with_radius_checkbox);
        CheckBox withDiagonalCheckbox = findViewById(R.id.with_diagonal_checkbox);
        CheckBox withPerimeterCheckbox = findViewById(R.id.with_perimeter_checkbox);
        CheckBox withAreaCheckbox = findViewById(R.id.with_area_checkbox);
        CheckBox withVolumeCheckbox = findViewById(R.id.with_volume_checkbox);
        CheckBox withHeightCheckbox = findViewById(R.id.with_height_checkbox);
        CheckBox withMedianCheckbox = findViewById(R.id.with_median_checkbox);

        final ArrayList<CheckBox> allWithCheckBoxes = new ArrayList<>();
        allWithCheckBoxes.add(withSideACheckbox);
        allWithCheckBoxes.add(withSideBCheckbox);
        allWithCheckBoxes.add(withSideCCheckbox);
        allWithCheckBoxes.add(withSideDCheckbox);
        allWithCheckBoxes.add(withRadiusCheckbox);
        allWithCheckBoxes.add(withPerimeterCheckbox);
        allWithCheckBoxes.add(withAreaCheckbox);
        allWithCheckBoxes.add(withVolumeCheckbox);
        allWithCheckBoxes.add(withDiagonalCheckbox);
        allWithCheckBoxes.add(withHeightCheckbox);
        allWithCheckBoxes.add(withMedianCheckbox);

        // Checkboxes What Find
        CheckBox findSideACheckbox = findViewById(R.id.find_sideA_checkbox);
        CheckBox findSideBCheckbox = findViewById(R.id.find_sideB_checkbox);
        CheckBox findSideCCheckbox = findViewById(R.id.find_sideC_checkbox);
        CheckBox findSideDCheckbox = findViewById(R.id.find_sideD_checkbox);
        CheckBox findRadiusCheckbox = findViewById(R.id.find_radius_checkbox);
        CheckBox findPerimeterCheckbox = findViewById(R.id.find_perimeter_checkbox);
        CheckBox findAreaCheckbox = findViewById(R.id.find_area_checkbox);
        CheckBox findVolumeCheckbox = findViewById(R.id.find_volume_checkbox);
        CheckBox findDiagonalCheckbox = findViewById(R.id.find_diagonal_checkbox);
        CheckBox findHeightCheckbox = findViewById(R.id.find_height_checkbox);
        CheckBox findMedianCheckbox = findViewById(R.id.find_median_checkbox);

        final ArrayList<CheckBox> allFindCheckBoxes = new ArrayList<>();
        allFindCheckBoxes.add(findSideACheckbox);
        allFindCheckBoxes.add(findSideBCheckbox);
        allFindCheckBoxes.add(findSideCCheckbox);
        allFindCheckBoxes.add(findSideDCheckbox);
        allFindCheckBoxes.add(findRadiusCheckbox);
        allFindCheckBoxes.add(findPerimeterCheckbox);
        allFindCheckBoxes.add(findAreaCheckbox);
        allFindCheckBoxes.add(findVolumeCheckbox);
        allFindCheckBoxes.add(findDiagonalCheckbox);
        allFindCheckBoxes.add(findHeightCheckbox);
        allFindCheckBoxes.add(findMedianCheckbox);

        // Hide All Finds
        for (CheckBox find : allFindCheckBoxes) { find.setVisibility(View.GONE); }

        // Figures Params Checkboxes
        CheckBox equilateralCheckbox = findViewById(R.id.equilateral_checkbox);
        CheckBox isoscelesCheckbox = findViewById(R.id.isosceles_checkbox);
        CheckBox rectangularCheckbox = findViewById(R.id.rectangular_checkbox);

        final ArrayList<CheckBox> allParamsCheckBoxes = new ArrayList<>();
        allParamsCheckBoxes.add(equilateralCheckbox);
        allParamsCheckBoxes.add(isoscelesCheckbox);
        allParamsCheckBoxes.add(rectangularCheckbox);

        // Hide All Settings
        for (CheckBox param : allParamsCheckBoxes) { param.setVisibility(View.GONE); }

        // if Circle -> no Other Settings
        if (selectedFigure.equals(figures.get(4))) { findViewById(R.id.other_settings_text).setVisibility(View.GONE); }

        // Updating Settings
        final ArrayList<CheckBox> allCheckboxes = new ArrayList<>();
        allCheckboxes.addAll(allWithCheckBoxes);
        allCheckboxes.addAll(allFindCheckBoxes);
        allCheckboxes.addAll(allParamsCheckBoxes);

        WithsFindsHider.hideSides(allWithCheckBoxes, allParamsCheckBoxes, selectedFigure, figures, figureType, figuresTypes, figureImage);

        final Button countBtn = findViewById(R.id.count_btn);
        for (CheckBox checkbox : allCheckboxes) {
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View checkbox) {
                    // Rehide Finds
                    for (CheckBox find : allFindCheckBoxes) { find.setVisibility(View.GONE); }
                    // ReShow Withs
                    for (CheckBox with : allWithCheckBoxes) { with.setVisibility(View.VISIBLE); }
                    WithsFindsHider.hideWithsFinds(allWithCheckBoxes, allFindCheckBoxes);

                    // 2D figures
                    if (figureType.equals(figuresTypes.get(0))) {
                        // Rectangle
                        if (selectedFigure.equals(figures.get(0))) { updateRectangle.updateSettings(allWithCheckBoxes, allFindCheckBoxes, allParamsCheckBoxes); }
                        // Triangle
                        else if (selectedFigure.equals(figures.get(1))) { updateTriangle.updateSettings(allWithCheckBoxes, allFindCheckBoxes, allParamsCheckBoxes); }
                        // Trapeze
                        else if (selectedFigure.equals(figures.get(2))) { updateTrapeze.updateSettings(allWithCheckBoxes, allFindCheckBoxes, allParamsCheckBoxes); }
                        // Parallelogram
                        else if (selectedFigure.equals(figures.get(3))) { updateParallelogram.updateSettings(allWithCheckBoxes, allFindCheckBoxes, allParamsCheckBoxes); }
                        // Circle
                        else if (selectedFigure.equals(figures.get(4))) { updateCircle.updateSettings(allWithCheckBoxes, allFindCheckBoxes); }
                    }
//                    // 3D figures
//                    else if (figureType.equals(figuresTypes.get(0))) {
//                        // Parallelepiped
//                        if (selectedFigure.equals(figures.get(5))) { updateParallelepiped.updateSettings(allWithCheckBoxes, allFindCheckBoxes, allParamsCheckBoxes); }
//                        // Tetrahedron
//                        else if (selectedFigure.equals(figures.get(6))) { updateTetrahedron.updateSettings(allWithCheckBoxes, allFindCheckBoxes, allParamsCheckBoxes); }
//                        // Pyramid
//                        else if (selectedFigure.equals(figures.get(7))) { updatePyramid.updateSettings(allWithCheckBoxes, allFindCheckBoxes, allParamsCheckBoxes); }
//                        // Sphere
//                        else if (selectedFigure.equals(figures.get(8))) { updateSphere.updateSettings(allWithCheckBoxes, allFindCheckBoxes); }
//                    }

                    // Uncheck All Hided Elements
                    for (CheckBox find : allFindCheckBoxes) {
                        if (find.getVisibility() != View.VISIBLE) { find.setChecked(false); }
                    }
                    for (CheckBox with : allWithCheckBoxes) { with.setVisibility(View.VISIBLE); }
                    WithsFindsHider.hideSides(allWithCheckBoxes, allParamsCheckBoxes, selectedFigure, figures, figureType, figuresTypes, figureImage);
                    WithsFindsHider.hideWithsFinds(allWithCheckBoxes, allFindCheckBoxes);

                    for (CheckBox with : allWithCheckBoxes) {
                        if (with.getVisibility() != View.VISIBLE) { with.setChecked(false); }
                    }

                    if (!whatCheckedList(allFindCheckBoxes).isEmpty()) { countBtn.setVisibility(View.VISIBLE); }
                    else { countBtn.setVisibility(View.GONE); }

                    for (CheckBox checkBox : allParamsCheckBoxes) { if (checkBox.getVisibility() != View.VISIBLE) { checkBox.setChecked(false); } }
                }
            });
        }

        // Next Count Activity
        countBtn.setVisibility(View.GONE);
        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent countingAct = new Intent(FigureSettingsActivity.this, CountingActivity.class);
                countingAct.putExtra("figure", selectedFigure); // String value
                countingAct.putExtra("isKnown", whatCheckedList(allWithCheckBoxes)); // String list
                countingAct.putExtra("needFind", whatCheckedList(allFindCheckBoxes));
                countingAct.putExtra("selectedParams", whatCheckedList(allParamsCheckBoxes));
                startActivity(countingAct);
            }
        });
    }

    // Sorting Functions
    public static ArrayList<String> whatCheckedList(ArrayList<CheckBox> array) {
        ArrayList<String> checksList = new ArrayList<>();
        for (CheckBox checkbox : array) { if (checkbox.isChecked()) { checksList.add(checkbox.getText().toString()); } }
        return checksList;
    }
}