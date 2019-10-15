package com.dzbo.unitTests;

import org.junit.Assert;
import org.junit.Test;

public class TrianglePossibilityTest {

    @Test
    public void equalSidesLengthTest(){
        Assert.assertTrue(Triangle.isPossible(5, 5, 5));
    }

    @Test
    public void zeroSideLengthTest(){
        Assert.assertFalse(Triangle.isPossible(0, 5, 5));
    }

    @Test
    public void floatSidesLengthTest(){
        Assert.assertTrue(Triangle.isPossible(5.55, 5.65, 5.75));
    }

    @Test
    public void negativeSideLengthTest(){
        Assert.assertFalse(Triangle.isPossible(11.1, 7.2, -3));
    }

    @Test
    public void zeroSidesLengthTest(){
        Assert.assertFalse(Triangle.isPossible(0, 0, 1));
    }

    @Test
    public void allSidesZeroLengthTest(){
        Assert.assertFalse(Triangle.isPossible(0, 0, 0));
    }

    @Test
    public void sidesWithLargeLengthTest(){
        Assert.assertTrue(Triangle.isPossible(1000, 2000, 3000));
    }

    @Test
    public void negativeSidesLengthTest(){
        Assert.assertFalse(Triangle.isPossible(-11, -7, -3));
    }

    @Test
    public void negativeFloatSidesLengthTest(){
        Assert.assertFalse(Triangle.isPossible(-5.1, -5.123, -5.3123));
    }

    @Test
    public void negativeZeroSidesLengthTest(){
        Assert.assertFalse(Triangle.isPossible(-0, -0, -0));
    }
}
