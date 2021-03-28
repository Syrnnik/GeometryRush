package com.syrnnik.geometryrush.countingActivities.volumetric;

import java.util.ArrayList;

public class ParallelepipedCount {

    public static Double countSideA(ArrayList<Double> args) {

        if (args.get(0) > 0) { return args.get(0); }
        else if (args.get(0) == null) { return null; }
        // Perimeter
        else if (countPerimeter(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return countPerimeter(args) / 4 - countSideB(args) - countSideC(args); }
        }
        // Volume
        else if (countVolume(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return countVolume(args) / countSideB(args) / countSideC(args); }
        }
        // Diagonal
        else if (countDiagonal(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return Math.pow(countDiagonal(args), 2) - Math.pow(countSideC(args), 2) - Math.pow(countSideB(args), 2); }
        }
        return args.get(0);
    }

    public static Double countSideB(ArrayList<Double> args) {

        if (args.get(1) > 0) { return args.get(1); }
        else if (args.get(1) == null) { return null; }
        // Perimeter
        else if (countPerimeter(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return countPerimeter(args) / 4 - countSideA(args) - countSideC(args); }
        }
        // Volume
        else if (countVolume(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return countVolume(args) / countSideA(args) / countSideC(args); }
        }
        // Diagonal
        else if (countDiagonal(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return Math.pow(countDiagonal(args), 2) - Math.pow(countSideA(args), 2) - Math.pow(countSideC(args), 2); }
        }
        return args.get(1);
    }

    public static Double countSideC(ArrayList<Double> args) {

        if (args.get(2) > 0) { return args.get(2); }
        else if (args.get(2) == null) { return null; }
        // Perimeter
        else if (countPerimeter(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return countPerimeter(args) / 4 - countSideA(args) - countSideB(args); }
        }
        // Volume
        else if (countVolume(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return countVolume(args) / countSideA(args) / countSideB(args); }
        }
        // Diagonal
        else if (countDiagonal(args) > 0) {
            if (countSideB(args) > 0 && countSideC(args) > 0) { return Math.pow(countDiagonal(args), 2) - Math.pow(countSideA(args), 2) - Math.pow(countSideB(args), 2); }
        }
        return args.get(2);
    }

    public static Double countPerimeter(ArrayList<Double> args) {
        if (args.get(4) > 0) { return args.get(4); }
        else if (args.get(4) == null) { return null; }
        else if (countSideA(args) > 0 && countSideB(args) > 0 && countSideC(args) > 0) { return (countSideA(args) + countSideB(args) + countSideC(args)) * 4; }
        return args.get(4);
    }

    public static Double countVolume(ArrayList<Double> args) {
        if (args.get(6) > 0) { return args.get(6); }
        else if (args.get(6) == null) { return null; }
        else if (countSideA(args) > 0 && countSideB(args) > 0 && countSideC(args) > 0) { return countSideA(args) * countSideB(args) * countSideC(args); }
        return args.get(6);
    }

    public static Double countDiagonal(ArrayList<Double> args) {
        if (args.get(7) > 0) { return args.get(7); }
        else if (args.get(7) == null) { return null; }
        else if (countSideA(args) > 0 && countSideB(args) > 0 && countSideC(args) > 0) { return Math.pow(countSideA(args), 2) + Math.pow(countSideB(args), 2) + Math.pow(countSideC(args), 2); }
        return args.get(7);
    }
}
