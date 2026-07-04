package com.tutorial.shape.calculator;

import com.tutorial.shape.Drawable;
import com.tutorial.shape.Shape;

public class Circle extends Shape implements Drawable {
    private final double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("The Radius Cannot Be Negative");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String drawAscii() {
        return "Ascii Shape Of Circle";
    }
}
