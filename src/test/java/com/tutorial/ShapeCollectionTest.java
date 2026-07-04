package com.tutorial;

import com.tutorial.shape.Shape;
import com.tutorial.shape.ShapeCollection;
import com.tutorial.shape.calculator.Circle;
import com.tutorial.shape.calculator.Rectangle;
import com.tutorial.shape.calculator.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeCollectionTest {

    private static final double CIRCLE_RADIUS = 5.0;
    private static final double RECT_WIDTH = 4.0;
    private static final double RECT_HEIGHT = 6.0;
    private static final double TRI_A = 3.0;
    private static final double TRI_B = 4.0;
    private static final double TRI_C = 5.0;

    private static final double CIRCLE_AREA = Math.PI * CIRCLE_RADIUS * CIRCLE_RADIUS;
    private static final double RECT_AREA = RECT_WIDTH * RECT_HEIGHT;
    private static final double TRI_AREA = (TRI_A * TRI_B) / 2.0;

    private static final double EXPECTED_TOTAL_AREA = CIRCLE_AREA + RECT_AREA + TRI_AREA;
    private static final double EXPECTED_LARGEST_AREA = CIRCLE_AREA;
    private static final Class<?> EXPECTED_LARGEST_CLASS = Circle.class;

    private static final double DELTA = 0.0001;

    private ShapeCollection shapeCollection;

    @BeforeEach
    public void setUp() {
        shapeCollection = new ShapeCollection();
        shapeCollection.addShape(new Circle(CIRCLE_RADIUS));
        shapeCollection.addShape(new Rectangle(RECT_WIDTH, RECT_HEIGHT));
        shapeCollection.addShape(new Triangle(TRI_A, TRI_B, TRI_C));
    }


    @Test
    public void testTotalAreaReturnsCorrectSum() {
        double total = shapeCollection.totalArea();
        assertEquals(EXPECTED_TOTAL_AREA, total, DELTA);
    }

    @Test
    public void testTotalAreaReturnsZeroWhenEmpty() {
        ShapeCollection emptyCollection = new ShapeCollection();
        assertEquals(0.0, emptyCollection.totalArea(), DELTA);
    }

    @Test
    public void testLargestShapeReturnsCorrectInstance() {
        Shape largest = shapeCollection.largestShape();

        assertNotNull(largest);
        assertEquals(EXPECTED_LARGEST_AREA, largest.area(), DELTA);
        assertEquals(EXPECTED_LARGEST_CLASS, largest.getClass());
    }

    @Test
    public void testLargestShapeReturnsNullWhenEmpty() {
        ShapeCollection emptyCollection = new ShapeCollection();
        Shape largest = emptyCollection.largestShape();

        assertNull(largest);
    }

    @Test
    public void testLargestShapeHandlesDuplicateAreas() {
        ShapeCollection collection = new ShapeCollection();
        collection.addShape(new Rectangle(4.0, 6.0));
        collection.addShape(new Rectangle(3.0, 8.0));

        Shape largest = collection.largestShape();

        assertNotNull(largest);
        assertEquals(24.0, largest.area(), DELTA);
        assertInstanceOf(Rectangle.class, largest);
        assertEquals(24.0, largest.area(), DELTA);
    }

}