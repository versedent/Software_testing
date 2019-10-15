package com.dzbo.unitTests;

public class Triangle {

    public static boolean isPossible(double x, double y, double z) {
        return (x > 0 && y > 0 && z > 0 && (x + y >= z) && (y + z >= x) && (z + x >= y));
    }
}
