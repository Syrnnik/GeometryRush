package com.syrnnik.geometryrush.countingTests;

import com.syrnnik.geometryrush.countingActivities.flat.CircleCount;

import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CircleCountingTests {

    @Test
    public void setition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    final int len = new AllFiguresTests().len;
    ArrayList<Double> args = new ArrayList<>(len);

    @Test
    public void countRadius() {

        // Radius isKnown
        this.resArgs();
        args.set(10, 4.0);
        Assert.assertEquals(4.0, CircleCount.countRadius(args));

        // With Perimeter
        this.resArgs();
        args.set(4, 8.0);
        Assert.assertEquals(4.0, CircleCount.countRadius(args));

        // With Area
        this.resArgs();
        args.set(5, 16.0);
        Assert.assertEquals(4.0, CircleCount.countRadius(args));
    }

    @Test
    public void countPerimeter() {

        // Perimeter isKnown
        this.resArgs();
        args.set(4, 8.0);
        Assert.assertEquals(8.0, CircleCount.countPerimeter(args));

        // With Radius
        this.resArgs();
        args.set(10, 4.0);
        Assert.assertEquals(8.0, CircleCount.countPerimeter(args));

        // With Area
        this.resArgs();
        args.set(5, 16.0);
        Assert.assertEquals(8.0, CircleCount.countPerimeter(args));
    }

    @Test
    public void countArea() {

        // Area isKnown
        this.resArgs();
        args.set(5, 16.0);
        Assert.assertEquals(16.0, CircleCount.countArea(args));

        // With Radius
        this.resArgs();
        args.set(10, 4.0);
        Assert.assertEquals(16.0, CircleCount.countArea(args));

        // With Perimeter
        this.resArgs();
        args.set(4, 8.0);
        Assert.assertEquals(16.0, CircleCount.countArea(args));
    }

    public void resArgs() {
        this.args = new ArrayList<>(len);
        for (int i = 0; i < len; i++) { this.args.add(i, 0.0); }
    }
}