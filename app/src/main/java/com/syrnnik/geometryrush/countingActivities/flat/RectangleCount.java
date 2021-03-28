package com.syrnnik.geometryrush.countingActivities.flat;

import java.util.ArrayList;

public class RectangleCount {

    public static Double countSideA(ArrayList<Double> args) {

        if (args.get(0) > 0) { return args.get(0); }
        // With Perimeter and Area
        if (args.get(4) > 0 && args.get(5) > 0) {
            double disc = Math.pow(countPerimeter(args) / 2, 2) - 4 * countArea(args);
            if (disc > 0) { return (countPerimeter(args) / 2 - Math.sqrt(disc)) / 2; }
            else { return 0.0; }
        }
        // With Perimeter
        if (args.get(4) > 0) {
            if (countSideB(args) > 0) { return countPerimeter(args) / 2 - countSideB(args); }
        }
        // With Area
        if (args.get(5) > 0) {
            if (countSideB(args) > 0) { return countArea(args) / countSideB(args); }
        }
        return args.get(0);
    }

    public static Double countSideB(ArrayList<Double> args) {

        if (args.get(1) > 0) { return args.get(1); }
        // With Perimeter and Area
        if (args.get(4) > 0 && args.get(5) > 0) {
            double disc = Math.pow(countPerimeter(args) / 2, 2) - 4 * countArea(args);
            if (disc > 0) { return (countPerimeter(args) / 2 + Math.sqrt(disc)) / 2; }
            else { return 0.0; }
        }
        // With Perimeter
        if (args.get(4) > 0) {
            if (countSideA(args) > 0) { return countPerimeter(args) / 2 - countSideA(args); }
        }
        // With Area
        if (args.get(5) > 0) {
            if (countSideA(args) > 0) { return countArea(args) / countSideA(args); }
        }
        return args.get(1);
    }

    public static Double countPerimeter(ArrayList<Double> args) {
        if (args.get(4) > 0) { return args.get(4); }
        // With Sides
        if (countSideA(args) > 0 && countSideB(args) > 0) { return (countSideA(args) + countSideB(args)) * 2; }
        // With Area
        if (args.get(5) > 0) {
            // With SideA
            if (countSideA(args) > 0) { return (countSideA(args) + (countArea(args) / countSideA(args))) * 2; }
            // With SideB
            if (countSideB(args) > 0) { return ((countArea(args) / countSideB(args)) + countSideB(args)) * 2; }
        }
        return args.get(4);
    }

    public static Double countArea(ArrayList<Double> args) {
        if (args.get(5) > 0) { return args.get(5); }
        // With Sides
        if (countSideA(args) > 0 && countSideB(args) > 0) { return countSideA(args) * countSideB(args); }
        // With Perimeter
        if (args.get(4) > 0) {
            // With SideA
            if (countSideA(args) > 0) { return countSideA(args) * (countPerimeter(args) / 2 - countSideA(args)); }
            // With SideB
            if (countSideB(args) > 0) { return (countPerimeter(args) / 2 - countSideB(args)) * countSideB(args); }
        }
        return args.get(5);
    }

    public static Double countDiagonal(ArrayList<Double> args) {
        if (args.get(7) > 0) { return args.get(7); }
        // With Sides
        if (countSideA(args) > 0 && countSideB(args) > 0) { return Math.sqrt(Math.pow(countSideA(args), 2) + Math.pow(countSideB(args), 2)); }
        return args.get(7);
    }
}
