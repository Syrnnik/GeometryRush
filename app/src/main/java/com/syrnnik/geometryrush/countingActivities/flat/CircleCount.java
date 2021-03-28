package com.syrnnik.geometryrush.countingActivities.flat;

import java.util.ArrayList;

public class CircleCount {

//    static double pi = 3.14;

    public static Double countRadius(ArrayList<Double> args) {

        if (args.get(10) > 0) { return args.get(10); }
        // With Perimeter
        if (args.get(4) > 0) { return countPerimeter(args) / 2; }
        // With Area
        if (args.get(5) > 0) { return Math.sqrt(countArea(args)); }
        return args.get(10);
    }

    public static Double countPerimeter(ArrayList<Double> args) {

        if (args.get(4) > 0) { return args.get(4); }
        // With Radius
        if (countRadius(args) > 0) { return countRadius(args) * 2; }
        return args.get(4);
    }

    public static Double countArea(ArrayList<Double> args) {

        if (args.get(5) > 0) { return args.get(5); }
        // With Radius
        if (countRadius(args) > 0) { return Math.pow(countRadius(args), 2); }
        return args.get(5);
    }
}
