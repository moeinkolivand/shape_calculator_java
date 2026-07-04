package com.tutorial;

import com.tutorial.shape.calculator.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    private Triangle triangle;
    private static final double DELTA = 0.0001;

    @BeforeEach
    public void setUp() {
        triangle = new Triangle(3.0, 4.0, 5.0);
    }

    @Test
    public void initiateWithNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(-1.0, 4.0, 5.0);
        });
    }


    @Test
    public void testConstructorThrowsOnNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(-1.0, 4.0, 5.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(3.0, -4.0, 5.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(3.0, 4.0, -5.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(-1.0, -2.0, -3.0);
        });
    }

    @Test
    public void testConstructorThrowsOnZeroSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(0.0, 4.0, 5.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(3.0, 0.0, 5.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(3.0, 4.0, 0.0);
        });
    }

    @Test
    public void testConstructorThrowsOnInvalidTriangleInequality() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(1.0, 2.0, 3.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(1.0, 1.0, 5.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(10.0, 2.0, 20.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(5.0, 6.0, 11.0);
        });
    }


    @Test
    public void testConstructorAcceptsValidTriangle() {
        assertDoesNotThrow(() -> {
            new Triangle(3.0, 4.0, 5.0);
        });
        assertDoesNotThrow(() -> {
            new Triangle(5.0, 5.0, 6.0);
        });
        assertDoesNotThrow(() -> {
            new Triangle(6.0, 8.0, 10.0);
        });
        assertDoesNotThrow(() -> {
            new Triangle(2.0, 3.0, 4.0);
        });
    }


    @Test
    public void testValidTriangleArea() {
        assertEquals(6.0, triangle.area(), 0.0001);
    }

    @Test
    public void testValidTrianglePerimeter() {
        assertEquals(12.0, triangle.perimeter(), 0.0001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -5.5, -0.001, -100.0})
    public void testConstructorThrowsOnAnyNegativeSide(double invalidSide) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(invalidSide, 4.0, 5.0);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 2.0, 3.0",
            "1.0, 1.0, 5.0",
            "10.0, 2.0, 20.0",
            "0.0, 4.0, 5.0"
    })
    public void testConstructorThrowsOnInvalidInputs(double a, double b, double c) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(a, b, c);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "3.0, 4.0, 5.0, 6.0, 12.0",
            "5.0, 5.0, 6.0, 12.0, 16.0",
            "6.0, 8.0, 10.0, 24.0, 24.0",
            "4.0, 4.0, 4.0, 6.9282, 12.0",
            "2.0, 3.0, 4.0, 2.9047, 9.0"
    })
    public void testAreaAndPerimeterForMultipleTriangles(
            double a, double b, double c, double expectedArea, double expectedPerimeter) {

        Triangle triangle = new Triangle(a, b, c);

        assertEquals(expectedArea, triangle.area(), DELTA);
        assertEquals(expectedPerimeter, triangle.perimeter(), DELTA);
    }
}