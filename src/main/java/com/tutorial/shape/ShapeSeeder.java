package com.tutorial.shape;

import com.tutorial.shape.calculator.Circle;
import com.tutorial.shape.calculator.Rectangle;
import com.tutorial.shape.calculator.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShapeSeeder {

    private static final Random RANDOM = ThreadLocalRandom.current();

    public static List<Shape> generateFixedShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.0));
        shapes.add(new Circle(2.5));
        shapes.add(new Rectangle(4.0, 6.0));
        shapes.add(new Rectangle(7.0, 3.0));
        shapes.add(new Triangle(3, 4, 5));   // valid right triangle
        shapes.add(new Triangle(5, 5, 6));   // isosceles triangle
        shapes.add(new Triangle(6, 8, 10));  // valid right triangle
        return shapes;
    }

    public static List<Shape> generateRandomShapes(int count) {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int type = RANDOM.nextInt(3);
            switch (type) {
                case 0 -> shapes.add(new Circle(randomDouble(1.0, 10.0)));
                case 1 -> shapes.add(new Rectangle(randomDouble(1.0, 10.0), randomDouble(1.0, 10.0)));
                case 2 -> shapes.add(generateRandomTriangle());
            }
        }
        return shapes;
    }

    private static Triangle generateRandomTriangle() {
        int maxAttempts = 100;
        for (int i = 0; i < maxAttempts; i++) {
            double a = randomDouble(1.0, 10.0);
            double b = randomDouble(1.0, 10.0);

            double minC = Math.abs(a - b) + 0.1;
            double maxC = a + b - 0.1;

            if (minC < maxC) {
                double c = minC + (maxC - minC) * RANDOM.nextDouble();
                c = Math.round(c * 100.0) / 100.0;
                a = Math.round(a * 100.0) / 100.0;
                b = Math.round(b * 100.0) / 100.0;
                return new Triangle(a, b, c);
            }
        }
        return new Triangle(3, 4, 5);
    }

    private static double randomDouble(double min, double max) {
        return Math.round((min + (max - min) * RANDOM.nextDouble()) * 100.0) / 100.0;
    }

}