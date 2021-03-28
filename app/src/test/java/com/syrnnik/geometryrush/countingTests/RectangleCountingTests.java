package com.syrnnik.geometryrush.countingTests;

import com.syrnnik.geometryrush.countingActivities.flat.RectangleCount;

import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RectangleCountingTests {

    @Test
    public void setition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    final int len = new AllFiguresTests().len;
    ArrayList<Double> args = new ArrayList<>(len);

    @Test
    public void countSideA() {

        // SideA isKnown
        this.resArgs();
        args.set(0, 3.0);
        Assert.assertEquals(3.0, RectangleCount.countSideA(args));

        // With SideB and Perimeter
        this.resArgs();
        args.set(1, 4.0);
        args.set(4, 14.0);
        Assert.assertEquals(3.0, RectangleCount.countSideA(args));

        // With SideB and Area
        this.resArgs();
        args.set(1, 4.0);
        args.set(5, 12.0);
        Assert.assertEquals(3.0, RectangleCount.countSideA(args));

        // With Perimeter and Area
        this.resArgs();
        args.set(4, 14.0);
        args.set(5, 12.0);
        Assert.assertEquals(3.0, RectangleCount.countSideA(args));
    }

    @Test
    public void countSideB() {

        // SideB isKnown
        this.resArgs();
        args.set(1, 4.0);
        Assert.assertEquals(4.0, RectangleCount.countSideB(args));

        // With SideA and Perimeter
        this.resArgs();
        args.set(0, 3.0);
        args.set(4, 14.0);
        Assert.assertEquals(4.0, RectangleCount.countSideB(args));

        // With SideA and Area
        this.resArgs();
        args.set(0, 3.0);
        args.set(5, 12.0);
        Assert.assertEquals(4.0, RectangleCount.countSideB(args));

        // With Perimeter and Area
        this.resArgs();
        args.set(4, 14.0);
        args.set(5, 12.0);
        Assert.assertEquals(4.0, RectangleCount.countSideB(args));
    }

    @Test
    public void countPerimeter() {

        // Perimeter isKnown
        this.resArgs();
        args.set(4, 14.0);
        Assert.assertEquals(14.0, RectangleCount.countPerimeter(args));

        // With SideA and SideB
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        Assert.assertEquals(14.0, RectangleCount.countPerimeter(args));

        // With SideA and Area
        this.resArgs();
        args.set(0, 3.0);
        args.set(5, 12.0);
        Assert.assertEquals(14.0, RectangleCount.countPerimeter(args));

        // With SideB and Area
        this.resArgs();
        args.set(1, 4.0);
        args.set(5, 12.0);
        Assert.assertEquals(14.0, RectangleCount.countPerimeter(args));
    }

    @Test
    public void countArea() {

        // Perimeter isKnown
        this.resArgs();
        args.set(5, 12.0);
        Assert.assertEquals(12.0, RectangleCount.countArea(args));

        // With SideA and SideB
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        Assert.assertEquals(12.0, RectangleCount.countArea(args));

        // With SideA and Perimeter
        this.resArgs();
        args.set(0, 3.0);
        args.set(4, 14.0);
        Assert.assertEquals(12.0, RectangleCount.countArea(args));

        // With SideB and Perimeter
        this.resArgs();
        args.set(1, 4.0);
        args.set(4, 14.0);
        Assert.assertEquals(12.0, RectangleCount.countArea(args));
    }

    @Test
    public void countDiagonal() {

        // Perimeter isKnown
        this.resArgs();
        args.set(7, 5.0);
        Assert.assertEquals(5.0, RectangleCount.countDiagonal(args));

        // With SideA and SideB
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        Assert.assertEquals(5.0, RectangleCount.countDiagonal(args));
    }

    public void resArgs() {
        this.args = new ArrayList<>(len);
        for (int i = 0; i < len; i++) { this.args.add(i, 0.0); }
    }
}