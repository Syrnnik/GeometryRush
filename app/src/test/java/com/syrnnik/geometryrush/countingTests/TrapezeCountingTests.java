package com.syrnnik.geometryrush.countingTests;

import com.syrnnik.geometryrush.countingActivities.flat.TrapezeCount;

import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TrapezeCountingTests {

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
        Assert.assertEquals(3.0, TrapezeCount.countSideA(args));

        // With SideB, SideC, SideD and Perimeter
        this.resArgs();
        args.set(1, 4.0);
        args.set(2, 5.0);
        args.set(3, 6.0);
        args.set(4, 18.0);
        Assert.assertEquals(3.0, TrapezeCount.countSideA(args));

        // With SideB and Area and Height
        this.resArgs();
        args.set(1, 4.0);
        args.set(5, 7.0);
        args.set(8, 2.0);
        Assert.assertEquals(3.0, TrapezeCount.countSideA(args));
    }

    @Test
    public void countSideB() {

        // SideB isKnown
        this.resArgs();
        args.set(1, 4.0);
        Assert.assertEquals(4.0, TrapezeCount.countSideB(args));

        // With SideA, SideC, SideD and Perimeter
        this.resArgs();
        args.set(0, 3.0);
        args.set(2, 5.0);
        args.set(3, 6.0);
        args.set(4, 18.0);
        Assert.assertEquals(4.0, TrapezeCount.countSideB(args));

        // With SideA and Area and Height
        this.resArgs();
        args.set(0, 3.0);
        args.set(5, 7.0);
        args.set(8, 2.0);
        Assert.assertEquals(4.0, TrapezeCount.countSideB(args));
    }

    @Test
    public void countSideC() {

        // SideC isKnown
        this.resArgs();
        args.set(2, 5.0);
        Assert.assertEquals(5.0, TrapezeCount.countSideC(args));

        // With SideA, SideB, SideD and Perimeter
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        args.set(3, 6.0);
        args.set(4, 18.0);
        Assert.assertEquals(5.0, TrapezeCount.countSideC(args));

        // With SideB, SideD and Perimeter and Area and Height
        this.resArgs();
        args.set(1, 4.0);
        args.set(3, 6.0);
        args.set(4, 18.0);
        args.set(5, 7.0);
        args.set(8, 2.0);
        Assert.assertEquals(5.0, TrapezeCount.countSideC(args));
    }

    @Test
    public void countSideD() {

        // SideD isKnown
        this.resArgs();
        args.set(3, 6.0);
        Assert.assertEquals(6.0, TrapezeCount.countSideD(args));

        // With SideA, SideB, SideC and Perimeter
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        args.set(2, 5.0);
        args.set(4, 18.0);
        Assert.assertEquals(6.0, TrapezeCount.countSideD(args));

        // With SideB, SideC and Perimeter and Area and Height
        this.resArgs();
        args.set(1, 4.0);
        args.set(2, 5.0);
        args.set(4, 18.0);
        args.set(5, 7.0);
        args.set(8, 2.0);
        Assert.assertEquals(6.0, TrapezeCount.countSideD(args));
    }

    @Test
    public void countPerimeter() {

        // Perimeter isKnown
        this.resArgs();
        args.set(4, 18.0);
        Assert.assertEquals(18.0, TrapezeCount.countPerimeter(args));

        // With SideA, SideB, SideC, SideD
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        args.set(2, 5.0);
        args.set(3, 6.0);
        Assert.assertEquals(18.0, TrapezeCount.countPerimeter(args));

        // With SideB, SideC, SideD and Area and Height
        this.resArgs();
        args.set(1, 4.0);
        args.set(2, 5.0);
        args.set(3, 6.0);
        args.set(5, 7.0);
        args.set(8, 2.0);
        Assert.assertEquals(18.0, TrapezeCount.countPerimeter(args));
    }

    @Test
    public void countArea() {

        // Area isKnown
        this.resArgs();
        args.set(5, 7.0);
        Assert.assertEquals(7.0, TrapezeCount.countArea(args));

        // With SideA, SideB and Height
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        args.set(8, 2.0);
        Assert.assertEquals(7.0, TrapezeCount.countArea(args));
    }

    @Test
    public void countHeight() {

        // Height isKnown
        this.resArgs();
        args.set(8, 2.0);
        Assert.assertEquals(2.0, TrapezeCount.countHeight(args));

        // With SideA, SideB and Area
        this.resArgs();
        args.set(0, 3.0);
        args.set(1, 4.0);
        args.set(5, 7.0);
        Assert.assertEquals(2.0, TrapezeCount.countHeight(args));
    }

    public void resArgs() {
        this.args = new ArrayList<>(len);
        for (int i = 0; i < len; i++) { this.args.add(i, 0.0); }
    }
}