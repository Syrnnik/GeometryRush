package com.syrnnik.geometryrush.countingTests;

import com.syrnnik.geometryrush.countingActivities.flat.ParallelogramCount;

import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParallelogramCountingTests {

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
        Assert.assertEquals(3.0, ParallelogramCount.countSideA(args));

        // With SideB and Perimeter
        this.resArgs();
        args.set(1, 4.0);
        args.set(4, 14.0);
        Assert.assertEquals(3.0, ParallelogramCount.countSideA(args));

        // With Area and Height
        this.resArgs();
        args.set(5, 12.0);
        args.set(8, 4.0);
        Assert.assertEquals(3.0, ParallelogramCount.countSideA(args));
    }

    @Test
    public void countSideB() {

        // SideB isKnown
        this.resArgs();
        args.set(1, 4.0);
        Assert.assertEquals(4.0, ParallelogramCount.countSideB(args));

        // With SideA and Perimeter
        this.resArgs();
        args.set(0, 3.0);
        args.set(4, 14.0);
        Assert.assertEquals(4.0, ParallelogramCount.countSideB(args));
    }

    @Test
    public void countPerimeter() {

        // Perimeter isKnown
        this.resArgs();
        args.set(4, 14.0);
        Assert.assertEquals(14.0, ParallelogramCount.countPerimeter(args));

        // With SideA and SideB
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        Assert.assertEquals(14.0, ParallelogramCount.countPerimeter(args));

        // With SideB and Area and Height
        this.resArgs();
        args.set(1, 4.0);
        args.set(5, 12.0);
        args.set(8, 4.0);
        Assert.assertEquals(14.0, ParallelogramCount.countPerimeter(args));
    }

    @Test
    public void countArea() {

        // Area isKnown
        this.resArgs();
        args.set(5, 12.0);
        Assert.assertEquals(12.0, ParallelogramCount.countArea(args));

        // With SideA and Height
        this.resArgs();
        args.set(0, 3.0);
        args.set(8, 4.0);
        Assert.assertEquals(12.0, ParallelogramCount.countArea(args));
    }

    @Test
    public void countHeight() {

        // Height isKnown
        this.resArgs();
        args.set(8, 4.0);
        Assert.assertEquals(4.0, ParallelogramCount.countHeight(args));

        // With SideA and SideB
        this.resArgs();
        args.set(0, 3.0);
        args.set(5, 12.0);
        Assert.assertEquals(4.0, ParallelogramCount.countHeight(args));
    }

    public void resArgs() {
        this.args = new ArrayList<>(len);
        for (int i = 0; i < len; i++) { this.args.add(i, 0.0); }
    }
}