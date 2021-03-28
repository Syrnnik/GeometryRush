package com.syrnnik.geometryrush.countingTests;

import com.syrnnik.geometryrush.countingActivities.flat.TriangleCount;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TriangleCountingTests {

    @Test
    public void setition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    final int len = new AllFiguresTests().len;
    ArrayList<Double> args = new ArrayList<>(len);

    @Before
    public void prepareArgs() {
        final ArrayList<Double> args = new ArrayList<>(len);
        this.resArgs();
    }

    @Test
    public void countSideA() {

        // SideA isKnown
        this.resArgs();
        args.set(0, 3.0);
        Assert.assertEquals(3.0, TriangleCount.countSideA(args));

        // With SideB, SideC and Perimeter
        this.resArgs();
        args.set(1, 4.0);
        args.set(2, 5.0);
        args.set(4, 12.0);
        Assert.assertEquals(3.0, TriangleCount.countSideA(args));

        // With Area and Height
        this.resArgs();
        args.set(5, 9.0);
        args.set(8, 6.0);
        Assert.assertEquals(3.0, TriangleCount.countSideA(args));
    }

    @Test
    public void countSideB() {

        // SideB isKnown
        this.resArgs();
        args.set(1, 4.0);
        Assert.assertEquals(4.0, TriangleCount.countSideB(args));

        // With SideA, SideC and Perimeter
        this.resArgs();
        args.set(0, 3.0);
        args.set(2, 5.0);
        args.set(4, 12.0);
        Assert.assertEquals(4.0, TriangleCount.countSideB(args));

        // With SideC and Perimeter and Area and Height
        this.resArgs();
        args.set(2, 5.0);
        args.set(4, 12.0);
        args.set(5, 9.0);
        args.set(8, 6.0);
        Assert.assertEquals(4.0, TriangleCount.countSideB(args));
    }

    @Test
    public void countSideC() {

        // SideC isKnown
        this.resArgs();
        args.set(2, 5.0);
        Assert.assertEquals(5.0, TriangleCount.countSideC(args));

        // With SideA, SideB and Perimeter
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        args.set(4, 12.0);
        Assert.assertEquals(5.0, TriangleCount.countSideC(args));

        // With SideB and Perimeter and Area and Height
        this.resArgs();
        args.set(1, 4.0);
        args.set(4, 12.0);
        args.set(5, 9.0);
        args.set(8, 6.0);
        Assert.assertEquals(5.0, TriangleCount.countSideC(args));
    }

    @Test
    public void countPerimeter() {

        // Perimeter isKnown
        this.resArgs();
        args.set(4, 12.0);
        Assert.assertEquals(12.0, TriangleCount.countPerimeter(args));

        // With SideA, SideB, SideC
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        args.set(2, 5.0);
        Assert.assertEquals(12.0, TriangleCount.countPerimeter(args));

        // With SideB, SideC and Area and Height
        this.resArgs();
        args.set(1, 4.0);
        args.set(2, 5.0);
        args.set(5, 9.0);
        args.set(8, 6.0);
        Assert.assertEquals(12.0, TriangleCount.countPerimeter(args));
    }

    @Test
    public void countArea() {

        // Area isKnown
        this.resArgs();
        args.set(5, 9.0);
        Assert.assertEquals(9.0, TriangleCount.countArea(args));

        // With SideA and Height
        this.resArgs();
        args.set(0, 3.0);
        args.set(8, 6.0);
        Assert.assertEquals(9.0, TriangleCount.countArea(args));
    }

    @Test
    public void countHeight() {

        // Height isKnown
        this.resArgs();
        args.set(8, 6.0);
        Assert.assertEquals(6.0, TriangleCount.countHeight(args));

        // With SideA and Area
        this.resArgs();
        args.set(0, 3.0);
        args.set(5, 9.0);
        Assert.assertEquals(6.0, TriangleCount.countHeight(args));
    }

    public void resArgs() {
        this.args = new ArrayList<>(len);
        for (int i = 0; i < len; i++) { this.args.add(i, 0.0); }
    }
}