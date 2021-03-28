package com.syrnnik.geometryrush.countingActivities.flat;

import java.util.ArrayList;

public class ParallelogramCount {

    public static Double countSideA(ArrayList<Double> args) {

        if (args.get(0) > 0) { return args.get(0); }
        // With Perimeter
        if (args.get(4) > 0) {
            if (countSideB(args) > 0) { return countPerimeter(args) / 2 - countSideB(args); }
        }
        // With Area
        if (args.get(5) > 0) {
            if (countHeight(args) > 0) { return countArea(args) / countHeight(args); }
        }
        return args.get(0);
    }

    public static Double countSideB(ArrayList<Double> args) {

        if (args.get(1) > 0) { return args.get(1); }
        // With Perimeter
        if (args.get(4) > 0) {
            if (countSideA(args) > 0) { return countPerimeter(args) / 2 - countSideA(args); }
        }
        return args.get(1);
    }

    public static Double countPerimeter(ArrayList<Double> args) {
        if (args.get(4) > 0) { return args.get(4); }
        // With Sides
        if (countSideA(args) > 0 && args.get(1) > 0) { return (countSideA(args) + countSideB(args)) * 2; }
        return args.get(4);
    }

    public static Double countArea(ArrayList<Double> args) {
        if (args.get(5) > 0) { return args.get(5); }
        // With Sides
        if (args.get(8) > 0) {
            // With SideA
            if (args.get(0) > 0) { return countSideA(args) * countHeight(args); }
        }
        return args.get(5);
    }

    public static Double countHeight(ArrayList<Double> args) {
        if (args.get(8) > 0) { return args.get(8); }
        // With Area
        if (args.get(5) > 0) {
            // With SideA
            if (args.get(0) > 0) { return countArea(args) / countSideA(args); }
        }
        return args.get(8);
    }
}
