package com.syrnnik.geometryrush;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.syrnnik.geometryrush.countingActivities.flat.CircleCount;
import com.syrnnik.geometryrush.countingActivities.flat.ParallelogramCount;
import com.syrnnik.geometryrush.countingActivities.flat.RectangleCount;
import com.syrnnik.geometryrush.countingActivities.flat.TrapezeCount;
import com.syrnnik.geometryrush.countingActivities.flat.TriangleCount;

import java.util.ArrayList;

public class CountingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting);
        final String selectedFigure = getIntent().getStringExtra("figure");
        assert selectedFigure != null;
        final ArrayList<String> isKnown = getIntent().getStringArrayListExtra("isKnown");
        assert isKnown != null;
        final ArrayList<String> needFind = getIntent().getStringArrayListExtra("needFind");
        assert needFind != null;
        final ArrayList<String> selectedParams = getIntent().getStringArrayListExtra("selectedParams");
        setTitle(getResources().getString(R.string.count_btn_text) + " " + selectedFigure);

        // Error Text
        final TextView errorMsg = findViewById(R.id.errorMsg);

        final String rectangle = getResources().getString(R.string.rectangle_btn_text);
        final String triangle = getResources().getString(R.string.triangle_btn_text);
        final String trapeze = getResources().getString(R.string.trapeze_btn_text);
        final String parallelogram = getResources().getString(R.string.parallelogram_btn_text);
        final String circle = getResources().getString(R.string.circle_btn_text);

        final String sideA = getResources().getString(R.string.sideA);
        final String sideB = getResources().getString(R.string.sideB);
        final String sideC = getResources().getString(R.string.sideC);
        final String sideD = getResources().getString(R.string.sideD);
        final String perimeter = getResources().getString(R.string.perimeter);
        final String area = getResources().getString(R.string.area);
        final String volume = getResources().getString(R.string.volume);
        final String diagonal = getResources().getString(R.string.diagonal);
        final String height = getResources().getString(R.string.height);
        final String median = getResources().getString(R.string.median);
        final String radius = getResources().getString(R.string.radius);

        // TODO: counting pi for circle
//        Button piPerimeterBtn = findViewById(R.id.piPerimeter_btn);
//        Button piAreaBtn = findViewById(R.id.piArea_btn);
//        if (selectedFigure.equals(circle)) {
//            if (isKnown.contains(perimeter)) { piPerimeterBtn.setVisibility(View.VISIBLE); }
//            if (isKnown.contains(area)) { piAreaBtn.setVisibility(View.VISIBLE); }
//        } else {
//            piPerimeterBtn.setVisibility(View.GONE);
//            piAreaBtn.setVisibility(View.GONE);
//        }

        // Available Findings
        final String[] elements = new String[]{
                sideA, sideB, sideC, sideD,
                perimeter, area, volume,
                diagonal,
                height, median,
                radius,
        };

        final String equilateral = getResources().getString(R.string.equilateral);
        final String isosceles = getResources().getString(R.string.isosceles);
        final String rectangular = getResources().getString(R.string.rectangular);

        // Fill Texts
        final TextView[] inputTexts = new TextView[]{
                findViewById(R.id.sideAText),
                findViewById(R.id.sideBText),
                findViewById(R.id.sideCText),
                findViewById(R.id.sideDText),
                findViewById(R.id.perimeterText),
                findViewById(R.id.areaText),
                findViewById(R.id.volumeText),
                findViewById(R.id.diagonalText),
                findViewById(R.id.heightText),
                findViewById(R.id.medianText),
                findViewById(R.id.radiusText),
        };
        for (int i = 0; i < inputTexts.length; i++) {
            inputTexts[i].setText((elements[i] + ":"));
            inputTexts[i].setVisibility(View.GONE);
        }

        // Fill Inputs
        final EditText[] inputEdits = new EditText[]{
                findViewById(R.id.sideAInput),
                findViewById(R.id.sideBInput),
                findViewById(R.id.sideCInput),
                findViewById(R.id.sideDInput),
                findViewById(R.id.perimeterInput),
                findViewById(R.id.areaInput),
                findViewById(R.id.volumeInput),
                findViewById(R.id.diagonalInput),
                findViewById(R.id.heightInput),
                findViewById(R.id.medianInput),
                findViewById(R.id.radiusInput),
        };
        for (int i = 0; i < inputEdits.length; i++) {
            for (int k = 0; k < isKnown.toArray().length; k++) {
                if ((isKnown.get(k) + ":").equals(inputTexts[i].getText().toString())) {
                    inputEdits[i].setHint(getResources().getString(R.string.enter) + " " + isKnown.get(k));
                }
            }
            inputEdits[i].setVisibility(View.GONE);
        }
        // Show Known Inputs
        for (int i = 0; i < inputTexts.length; i++) {
            for (String known : isKnown) {
                if (inputTexts[i].getText().toString().equals((known + ":"))) {
                    inputTexts[i].setVisibility(View.VISIBLE);
                    inputEdits[i].setVisibility(View.VISIBLE);
                }
            }
        }

        // Fill Outputs
        final TextView[] outputTexts = new TextView[]{
                findViewById(R.id.sideAOutput),
                findViewById(R.id.sideBOutput),
                findViewById(R.id.sideCOutput),
                findViewById(R.id.sideDOutput),
                findViewById(R.id.perimeterOutput),
                findViewById(R.id.areaOutput),
                findViewById(R.id.volumeOutput),
                findViewById(R.id.diagonalOutput),
                findViewById(R.id.heightOutput),
                findViewById(R.id.medianOutput),
                findViewById(R.id.radiusOutput),
        };
        for (int i = 0; i < outputTexts.length; i++) {
            outputTexts[i].setText(("·" + elements[i] + " = "));
            outputTexts[i].setVisibility(View.GONE);
        }
        // Show Answers Outputs
        for (TextView outputText : outputTexts) {
            for (String need : needFind) {
                if (outputText.getText().equals(("·" + need + " = "))) {
                    outputText.setVisibility(View.VISIBLE);
                    outputText.setVisibility(View.VISIBLE);
                }
            }
        }

        // Count Btn OnClick Function
        final Button countBtn = findViewById(R.id.count_btn);
        countBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(countBtn.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                // Answers Array
                final ArrayList<Double> answers = new ArrayList<>(inputTexts.length);
                for (int i = 0; i < inputTexts.length; i++) { answers.add(i, 0.0); }

                // Update Answers
                for (String known : isKnown) {
                    for (int i = 0; i < inputTexts.length; i++) {
                        errorMsg.setText(" ");
                        if (inputTexts[i].getText().toString().equals(known + ":")) {

                            // Fill answers
                            if (inputEdits[i].getText().toString().replace("π", "").matches("^\\d+(?:[.]\\d+)?$")) {
                                answers.add(i, Double.parseDouble(inputEdits[i].getText().toString().replace("π", "")));
                            } else {
                                errorMsg.setText(getResources().getString(R.string.wrong_number));
                                if (inputEdits[i].getText().toString().replace("π", "").matches("^\\d+(?:[,]\\d+)?$")) {
                                    errorMsg.setText(getResources().getString(R.string.not_dot));
                                }
                                for (int k = 0; k < outputTexts.length; k++) {
                                    outputTexts[k].setText((elements[k] + " = -_-"));
                                }
                                return;
                            }
                        }
                    }
                }

                // Use Selected Params
                if (selectedParams.contains(equilateral)) {
                    answers.set(1, answers.get(0));
                    answers.set(2, answers.get(0));
                    answers.set(3, answers.get(0));
                }
                else if (selectedParams.contains(isosceles)) {
                    if (selectedFigure.equals(trapeze)) {
                        answers.set(3, answers.get(2));
                    }
                    else {
                        answers.set(1, answers.get(0));
                    }
                }

                // Start Counting
                for (TextView find : outputTexts) {

                    String element = "";
                    String answer = "";
                    String formula = "";

                    // Count Rectangle
                    if (selectedFigure.equals(rectangle)) {
                        // Count Rectangle SideA
                        if (find.getText().toString().contains(sideA)) {
                            if (isKnown.contains(perimeter) && isKnown.contains(area)) {
                                formula = getResources().getString(R.string.rectangle_sideA_fromPerimeterAndArea_formula);
                            } else if (isKnown.contains(sideB) && isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.rectangle_sideA_fromSideBAndPerimeter_formula);
                            } else if (isKnown.contains(sideB) && isKnown.contains(area)) {
                                formula = getResources().getString(R.string.rectangle_sideA_fromSideBAndArea_formula);
                            }

                            if (selectedParams.contains(equilateral)) {
                                if (isKnown.contains(area)) {
                                    formula = getResources().getString(R.string.square_sideA_fromArea_formula);
                                }
                            }

                            element = sideA;
                            answer = RectangleCount.countSideA(answers).toString();
                        }
                        // Count Rectangle SideB
                        else if (find.getText().toString().contains(sideB)) {
                            if (isKnown.contains(perimeter) && isKnown.contains(area)) {
                                formula = getResources().getString(R.string.rectangle_sideA_fromPerimeterAndArea_formula);
                            } else if (isKnown.contains(sideA)) {
                                if (isKnown.contains(perimeter)) {
                                    formula = getResources().getString(R.string.rectangle_sideA_fromSideBAndPerimeter_formula);
                                } else if (isKnown.contains(area)) {
                                    formula = getResources().getString(R.string.rectangle_sideA_fromSideBAndArea_formula);
                                }
                            }

                            element = sideB;
                            answer = RectangleCount.countSideB(answers).toString();
                        }
                        // Count Rectangle Perimeter
                        else if (find.getText().toString().contains(perimeter)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideB)) {
                                formula = getResources().getString(R.string.rectangle_perimeter_formula);
                            } else if (isKnown.contains(area)) {
                                if (isKnown.contains(sideA)) {
                                    formula = getResources().getString(R.string.rectangle_perimeter_fromSideAAndArea_formula);
                                } else if (isKnown.contains(sideB)) {
                                    formula = getResources().getString(R.string.rectangle_perimeter_fromSideBAndArea_formula);
                                }
                            }

                            if (selectedParams.contains(equilateral)) {
                                if (isKnown.contains(sideA)) {
                                    formula = getResources().getString(R.string.square_perimeter_formula);
                                }
                            }

                            element = perimeter;
                            answer = RectangleCount.countPerimeter(answers).toString();
                        }
                        // Count Rectangle Area
                        else if (find.getText().toString().contains(area)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideB)) {
                                formula = getResources().getString(R.string.rectangle_area_formula);
                            } else if (isKnown.contains(sideA) || isKnown.contains(sideB)) {
                                if (isKnown.contains(perimeter)) {
                                    formula = getResources().getString(R.string.rectangle_area_fromSideAAndPerimeter_formula);
                                }
                            }

                            if (selectedParams.contains(equilateral)) {
                                if (isKnown.contains(sideA)) {
                                    formula = getResources().getString(R.string.square_area_formula);
                                }
                            }

                            element = area;
                            answer = RectangleCount.countArea(answers).toString();
                        }
                        // Count Rectangle Diagonal
                        else if (find.getText().toString().contains(diagonal)) {

                            if (isKnown.contains(sideA) && (isKnown.contains(sideB) || selectedParams.contains(equilateral))) {

                                double diagonalAnswer = RectangleCount.countDiagonal(answers);
                                answer = String.valueOf(diagonalAnswer);
                                if (diagonalAnswer % 1 != 0) {
                                    answer = "√" + Math.pow(RectangleCount.countDiagonal(answers), 2);
                                }
                                formula = getResources().getString(R.string.rectangle_diagonal_formula);

                                if (selectedParams.contains(equilateral)) {
                                    formula = getResources().getString(R.string.square_diagonal_formula);
                                    answer = RectangleCount.countSideA(answers).toString() + "√2";
                                }
                            }
                            element = diagonal;
                        }
                    }
                    // Count Triangle
                    else if (selectedFigure.equals(triangle)) {
                        // Count Triangle SideA
                        if (find.getText().toString().contains(sideA)) {
                            if ((isKnown.contains(sideB) || selectedParams.contains(isosceles)) && isKnown.contains(sideC) && isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.triangle_sideA_from2SidesAndPerimeter_formula);
                                if (selectedParams.contains(isosceles)) {
                                    formula = getResources().getString(R.string.triangle_sideA_fromSideCAndPerimeter_formula);
                                }
                            } else if (isKnown.contains(area) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.triangle_sideA_fromAreaAndHeight_formula);
                            }
                            answer = String.valueOf((TriangleCount.countPerimeter(answers) - TriangleCount.countSideC(answers)) / 2);

                            if (isKnown.contains(sideC) && selectedParams.contains(rectangular)) {
                                if (selectedParams.contains(isosceles)) {
                                    answer = TriangleCount.countSideC(answers) / 2 + "√2";
                                    formula = getResources().getString(R.string.triangle_sideA_fromSideC_isoAndRect_formula);
                                } else if (isKnown.contains(sideB)) {
                                    // TODO: move rectangular triangle(and others) to counting file
                                    double sideALength = Math.sqrt(Math.pow(TriangleCount.countSideC(answers), 2) - Math.pow(TriangleCount.countSideB(answers), 2));
                                    answer = String.valueOf(sideALength);
                                    if (sideALength % 1 != 0) {
                                        answer = "√" + Math.pow(sideALength, 2);
                                    }
                                    formula = getResources().getString(R.string.triangle_sideA_fromSideBAndSideC_rect_formula);
                                }
                            }

                            element = sideA;
                        }
                        // Count Triangle SideB
                        else if (find.getText().toString().contains(sideB)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideC) && isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.triangle_sideA_from2SidesAndPerimeter_formula);
                            } else if (isKnown.contains(area) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.triangle_sideA_fromAreaAndHeight_formula);
                            }

                            if (isKnown.contains(sideC) && selectedParams.contains(rectangular)) {
                                if (selectedParams.contains(isosceles)) {
                                    answer = TriangleCount.countSideC(answers) / 2 + "√2";
                                    formula = getResources().getString(R.string.triangle_sideA_fromSideC_isoAndRect_formula);
                                } else if (isKnown.contains(sideA)) {
                                    double sideBLength = Math.sqrt(Math.pow(TriangleCount.countSideC(answers), 2) - Math.pow(TriangleCount.countSideA(answers), 2));
                                    answer = String.valueOf(sideBLength);
                                    if (sideBLength % 1 != 0) {
                                        answer = "√" + Math.pow(sideBLength, 2);
                                    }
                                    formula = getResources().getString(R.string.triangle_sideA_fromSideBAndSideC_rect_formula);
                                }
                            }

                            element = sideB;
                        }
                        // Count Triangle SideC
                        else if (find.getText().toString().contains(sideC)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideB) && isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.triangle_sideA_from2SidesAndPerimeter_formula);
                            } else if (isKnown.contains(area) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.triangle_sideA_fromAreaAndHeight_formula);
                            }

                            if (isKnown.contains(sideA) && selectedParams.contains(rectangular)) {
                                if (selectedParams.contains(isosceles)) {
                                    answer = TriangleCount.countSideA(answers) + "√2";
                                    formula = getResources().getString(R.string.triangle_sideC_fromSideA_isoAndRect_formula);
                                } else if (isKnown.contains(sideB)) {
                                    double sideCLength = Math.sqrt(Math.pow(TriangleCount.countSideA(answers), 2) + Math.pow(TriangleCount.countSideB(answers), 2));
                                    answer = String.valueOf(sideCLength);
                                    if (sideCLength % 1 != 0) {
                                        answer = "√" + Math.pow(sideCLength, 2);
                                    }
                                    formula = getResources().getString(R.string.triangle_sideC_from2Sides_rect_formula);
                                }
                            }

                            element = sideC;
                        }
                        // Count Triangle Perimeter
                        else if (find.getText().toString().contains(perimeter)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideB) && isKnown.contains(sideC)) {
                                formula = getResources().getString(R.string.triangle_perimeter_formula);
                            } else if (isKnown.contains(sideA) && selectedParams.contains(equilateral)) {
                                formula = getResources().getString(R.string.triangle_perimeter_equ_formula);
                            } else if (isKnown.contains(sideA) && isKnown.contains(sideB) && selectedParams.contains(isosceles)) {
                                formula = getResources().getString(R.string.triangle_perimeter_iso_formula);
                            }
//                            else if ((isKnown.contains(sideA) && isKnown.contains(sideB)) || (isKnown.contains(sideB) && isKnown.contains(sideC)) || (isKnown.contains(sideA) && isKnown.contains(sideC))) {
////                            || ((isKnown.contains(sideA) || isKnown.contains(sideB) || isKnown.contains(sideC)) && selectedParams.contains(isosceles))) {
////                                if (isKnown.contains(area) && isKnown.contains(height)) {
//                                    formula = getResources().getString(R.string.triangle_perimeter_from2SidesAndAreaAndHeight_formula);
////                                }

                            element = perimeter;
                            answer = TriangleCount.countPerimeter(answers).toString();
                        }
                        // Count Triangle Area
                        else if (find.getText().toString().contains(area)) {
                            if ((isKnown.contains(sideA) || isKnown.contains(sideB) || isKnown.contains(sideC)) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.triangle_area_formula);
                            }

                            find.setText(answerText(area, TriangleCount.countArea(answers).toString(), formula));
                        }
                        // Count Triangle Height
                        else if (find.getText().toString().contains(height)) {
                            if ((isKnown.contains(sideA) || isKnown.contains(sideB) || isKnown.contains(sideC)) && isKnown.contains(area)) {
                                formula = getResources().getString(R.string.triangle_height_formula);
                            }

                            find.setText(answerText(height, TriangleCount.countHeight(answers).toString(), formula));
                            element = height;
                            answer = TriangleCount.countHeight(answers).toString();
                        }
                    }
                    // Count Trapeze
                    else if (selectedFigure.equals(trapeze)) {
                        // Count Trapeze SideA
                        if (find.getText().toString().contains(sideA)) {
                            if (isKnown.contains(sideB) && isKnown.contains(sideC) && isKnown.contains(sideD) && isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.trapeze_sideA_from3SidesAndPerimeter_formula);
                            } else if (isKnown.contains(sideB) && isKnown.contains(area) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.trapeze_sideA_fromSideBAndAreaAndHeight_formula);
                            }

                            element = sideA;
                            answer = TrapezeCount.countSideA(answers).toString();
                        }
                        // Count Trapeze SideB
                        else if (find.getText().toString().contains(sideB)) {
                            if (isKnown.contains(sideC) && isKnown.contains(sideD) && isKnown.contains(perimeter)) {
                                if (isKnown.contains(sideA)) {
                                    formula = getResources().getString(R.string.trapeze_sideA_from3SidesAndPerimeter_formula);
                                }
                            } else if (isKnown.contains(sideA) && isKnown.contains(area) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.trapeze_sideA_fromSideBAndAreaAndHeight_formula);
                            }

                            element = sideB;
                            answer = TrapezeCount.countSideB(answers).toString();
                        }
                        // Count Trapeze SideC
                        else if (find.getText().toString().contains(sideC)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideB) && isKnown.contains(sideD) && isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.trapeze_sideA_from3SidesAndPerimeter_formula);
                                answer = TrapezeCount.countSideC(answers).toString();
                            } else if (selectedParams.contains(isosceles)) {
                                formula = getResources().getString(R.string.trapeze_sideA_from2SidesAndPerimeter_iso_formula);
                                answer = String.valueOf((TrapezeCount.countPerimeter(answers) - TrapezeCount.countSideA(answers) - TrapezeCount.countSideB(answers)) / 2);
                            }

                            element = sideC;
                        }
                        // Count Trapeze SideD
                        else if (find.getText().toString().contains(sideD)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideB) && isKnown.contains(sideC) && isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.trapeze_sideA_from3SidesAndPerimeter_formula);
                                answer = TrapezeCount.countSideD(answers).toString();
                            } else if (selectedParams.contains(isosceles)) {
                                formula = getResources().getString(R.string.trapeze_sideA_from2SidesAndPerimeter_iso_formula);
                                answer = String.valueOf((TrapezeCount.countPerimeter(answers) - TrapezeCount.countSideA(answers) - TrapezeCount.countSideB(answers)) / 2);
                            }

                            element = sideD;
                        }
                        // Count Trapeze Perimeter
                        else if (find.getText().toString().contains(perimeter)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideB) && isKnown.contains(sideC)) {
                                if (isKnown.contains(sideD)) {
                                    formula = getResources().getString(R.string.trapeze_perimeter_formula);
                                } else if (selectedParams.contains(isosceles)) {
                                    formula = getResources().getString(R.string.trapeze_perimeter_fromSides_iso_formula);
                                }
                            }

                            element = perimeter;
                            answer = TrapezeCount.countPerimeter(answers).toString();
                        }
                        // Count Trapeze Area
                        else if (find.getText().toString().contains(area)) {
                            if (isKnown.contains(sideA) && isKnown.contains(sideB) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.trapeze_area_formula);
                            }

                            element = area;
                            answer = TrapezeCount.countArea(answers).toString();
                        }
                        // Count Trapeze Height
                        else if (find.getText().toString().contains(height)) {
                            if (isKnown.contains(sideC) && isKnown.contains(sideD) && isKnown.contains(area)) {
                                formula = getResources().getString(R.string.trapeze_height_formula);
                            }

                            element = height;
                            answer = TrapezeCount.countHeight(answers).toString();
                        }
                    }
                    // Count Parallelogram
                    else if (selectedFigure.equals(parallelogram)) {
                        // Count Parallelogram SideA
                        if (find.getText().toString().contains(sideA)) {
                            if (isKnown.contains(perimeter) && (isKnown.contains(sideB) || selectedParams.contains(equilateral))) {
                                formula = getResources().getString(R.string.parallelogram_sideA_fromSideBAndPerimeter_formula);
                                answer = ParallelogramCount.countSideA(answers).toString();
                                if (selectedParams.contains(equilateral)) {
                                    answer = String.valueOf(ParallelogramCount.countPerimeter(answers) / 4);
                                }
                            } else if (isKnown.contains(area) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.parallelogram_sideA_fromAreaAndHeight_formula);
                            }

                            element = sideA;
                        }
                        // Count Parallelogram SideB
                        else if (find.getText().toString().contains(sideB)) {
                            if (isKnown.contains(sideA) && isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.parallelogram_sideA_fromSideBAndPerimeter_formula);
                            }

                            element = sideB;
                            answer = ParallelogramCount.countSideA(answers).toString();
                        }
                        // Count Parallelogram Perimeter
                        else if (find.getText().toString().contains(perimeter)) {
                            if (isKnown.contains(sideA) && (isKnown.contains(sideB) || selectedParams.contains(equilateral))) {
                                formula = getResources().getString(R.string.parallelogram_perimeter_fromSides_formula);
                            }

                            element = perimeter;
                            answer = ParallelogramCount.countSideA(answers).toString();
                        }
                        // Count Parallelogram Area
                        else if (find.getText().toString().contains(area)) {
                            if (isKnown.contains(sideA) && isKnown.contains(height)) {
                                formula = getResources().getString(R.string.parallelogram_area_formula);
                            }

                            element = area;
                            answer = ParallelogramCount.countSideA(answers).toString();
                        }
                        // Count Parallelogram Height
                        else if (find.getText().toString().contains(height)) {
                            if (isKnown.contains(sideA) && isKnown.contains(area)) {
                                formula = getResources().getString(R.string.parallelogram_height_fromSideAAndArea_formula);
                            }

                            element = height;
                            answer = ParallelogramCount.countSideA(answers).toString();
                        }
                    }
                    // Count Circle
                    else if (selectedFigure.equals(circle)) {

                        String pi = "";
                        if (inputEdits[10].getText().toString().contains("π")) { pi = "π"; }

                        // Count Circle Radius
                        if (find.getText().toString().contains(radius)) {
                            if (isKnown.contains(perimeter)) {
                                formula = getResources().getString(R.string.circle_radius_fromPerimeter_formula);
                                answer = CircleCount.countRadius(answers).toString();
                            }
                            else if (isKnown.contains(area)) {
                                formula = getResources().getString(R.string.circle_radius_fromArea_formula);
                                double radius = Math.sqrt(CircleCount.countArea(answers));
                                if (radius % 1 != 0) {
                                    radius = Math.pow(CircleCount.countArea(answers), 2);
                                }

                                if (!pi.isEmpty()) { pi = "√" + pi; }

                                answer = radius + pi;
                            }

                            element = radius;
                        }
                        // Count Circle Perimeter
                        else if (find.getText().toString().contains(perimeter)) {

                            formula = getResources().getString(R.string.circle_perimeter_formula);
                            element = perimeter;
                            answer = CircleCount.countPerimeter(answers) + pi;
                        }
                        // Count Circle Area
                        else if (find.getText().toString().contains(area)) {

                            formula = getResources().getString(R.string.circle_area_formula);
                            element = area;
                            answer = CircleCount.countArea(answers) + pi;
                        }
                    }

                    find.setText(answerText(element, answer, formula));
                }
            }
        });
    }

    // Prepare string for output answer
    public static String answerText(String element, String answer, String formula) {
        return "·" + element + " = " + answer + "\nformula: " + formula;
    }

    public void addPiToInput(View view) {

        final String perimeter = getResources().getString(R.string.perimeter);
        final String area = getResources().getString(R.string.area);
        EditText input = new EditText(view.getContext());

        if (view.getContentDescription().toString().equals(perimeter)) { input = findViewById(R.id.perimeterInput); }
        else if (view.getContentDescription().toString().equals(area)) { input = findViewById(R.id.areaInput); }

        if (!input.getText().toString().contains("π")) { input.setText((input.getText().toString() + "π")); }
        else {
//            String txt = input.getText().toString().replace("π", "");
            input.setText((input.getText().toString().replace("π", "") + "π"));
        }
    }
}