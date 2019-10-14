package com.dzbo.unitTests;

import org.junit.Assert;
import org.junit.Test;

public class TriangleCheckTest {

    @Test
    public void zeroInequalityTest(){
        Assert.assertTrue(TriangleCheck.isTriangle(5, 5, 5));
    }

    @Test
    public void firstInequalityTest(){
        Assert.assertFalse(TriangleCheck.isTriangle(0, 0, 0));
    }

    @Test
    public void secondInequalityTest(){
        Assert.assertTrue(TriangleCheck.isTriangle(5.55, 5.65, 5.75));
    }

    @Test
    public void thirdInequalityTest(){
        Assert.assertFalse(TriangleCheck.isTriangle(11.1, 7.2, -3));
    }

    @Test
    public void fourthInequalityTest(){
        Assert.assertFalse(TriangleCheck.isTriangle(0, 1, 1));
    }

    @Test
    public void fifthInequalityTest(){
        Assert.assertFalse(TriangleCheck.isTriangle(3.88, 0, 5));
    }

    @Test
    public void sixthInequalityTest(){
        Assert.assertTrue(TriangleCheck.isTriangle(1000, 2000, 3000));
    }

    @Test
    public void seventhInequalityTest(){
        Assert.assertFalse(TriangleCheck.isTriangle(-11, 7, 3));
    }

    @Test
    public void eighthInequalityTest(){
        Assert.assertFalse(TriangleCheck.isTriangle(5, 5.123, -5.3123));
    }

    @Test
    public void ninthInequalityTest(){
        Assert.assertFalse(TriangleCheck.isTriangle(11.123, -7, 3));
    }

}
