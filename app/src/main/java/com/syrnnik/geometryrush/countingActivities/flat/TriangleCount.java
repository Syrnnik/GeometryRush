package com.syrnnik.geometryrush.countingActivities.flat;

import java.util.ArrayList;

public class TriangleCount {

    public static Double countSideA(ArrayList<Double> args) {

        if (args.get(0) > 0) { return args.get(0); }
        // With Perimeter
        if (args.get(4) > 0) {
            if (args.get(1) > 0 && args.get(2) > 0) { return countPerimeter(args) - countSideB(args) - countSideC(args); }
        }
        // With Area
        if (args.get(5) > 0) {
            if (args.get(8) > 0) { return countArea(args) * 2 / countHeight(args); }
        }
        return args.get(0);
    }

    public static Double countSideB(ArrayList<Double> args) {

        if (args.get(1) > 0) { return args.get(1); }
        // With SideC and SideA
        // With Perimeter
        if (args.get(4) > 0) {
            if (countSideA(args) > 0 && args.get(2) > 0) { return countPerimeter(args) - countSideA(args) - countSideC(args); }
        }
        return args.get(1);
    }

    public static Double countSideC(ArrayList<Double> args) {

        if (args.get(2) > 0) { return args.get(2); }
        // With Perimeter
        if (args.get(4) > 0) {
            if (countSideA(args) > 0 && args.get(1) > 0) { return countPerimeter(args) - countSideA(args) - countSideB(args); }
        }
        return args.get(2);
    }

    public static Double countPerimeter(ArrayList<Double> args) {
        if (args.get(4) > 0) { return args.get(4); }
        // With Sides
        if (countSideA(args) > 0 && args.get(1) > 0 && args.get(2) > 0) { return countSideA(args) + countSideB(args) + countSideC(args); }
        return args.get(4);
    }

    public static Double countArea(ArrayList<Double> args) {
        if (args.get(5) > 0) { return args.get(5); }
        // With Sides
        if (args.get(8) > 0) {
            if (countSideA(args) > 0) { return countSideA(args) * countHeight(args) / 2; }
        }
        return args.get(5);
    }

    public static Double countHeight(ArrayList<Double> args) {
        if (args.get(8) > 0) { return args.get(8); }
        // With Sides
        if (args.get(5) > 0) {
            if (countSideA(args) > 0) { return countArea(args) * 2 / countSideA(args); }
        }
        return args.get(8);
    }
}
