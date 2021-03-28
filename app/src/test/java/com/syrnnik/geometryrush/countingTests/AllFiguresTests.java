package com.syrnnik.geometryrush.countingTests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AllFiguresTests {

    public final int len = 11;

    @Test
    public void setition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void countRectangle() {
        RectangleCountingTests rectangle = new RectangleCountingTests();

        rectangle.countSideA();
        rectangle.countSideB();
        rectangle.countPerimeter();
        rectangle.countArea();
        rectangle.countDiagonal();
    }

    @Test
    public void countTriangle() {
        TriangleCountingTests triangle = new TriangleCountingTests();

        triangle.countSideA();
        triangle.countSideB();
        triangle.countSideC();
        triangle.countPerimeter();
        triangle.countArea();
        triangle.countHeight();
    }

    @Test
    public void countTrapeze() {
        TrapezeCountingTests trapeze = new TrapezeCountingTests();

        trapeze.countSideA();
        trapeze.countSideB();
        trapeze.countSideC();
        trapeze.countSideD();
        trapeze.countPerimeter();
        trapeze.countArea();
        trapeze.countHeight();
    }

    @Test
    public void countParallelogram() {
        ParallelogramCountingTests parallelogram = new ParallelogramCountingTests();

        parallelogram.countSideA();
        parallelogram.countSideB();
        parallelogram.countPerimeter();
        parallelogram.countArea();
        parallelogram.countHeight();
    }

    @Test
    public void countCircle() {
        CircleCountingTests circle = new CircleCountingTests();

        circle.countRadius();
        circle.countPerimeter();
        circle.countArea();
    }
}