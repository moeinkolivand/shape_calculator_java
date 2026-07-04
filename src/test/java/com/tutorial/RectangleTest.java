package com.tutorial;

import com.tutorial.shape.calculator.Rectangle;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class RectangleTest {
    private final double width = 10.0;
    private final double height = 2.0;
    private Rectangle rectangle;
    @Test
    public void initiateWithNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(-5.0, -5.0);
        });
    }

    @BeforeEach
    public void createRectangle(){
        rectangle = new Rectangle(width, height);
    }

    @Test
    public void calculateArea() {
        double exceptedArea = width * height;
        assertEquals(exceptedArea, rectangle.area());
    }

    @Test
    public void calculatePerimeter() {
        double exceptedPerimeter = 2 * (width + height);
        assertEquals(exceptedPerimeter, rectangle.perimeter());
    }

}
