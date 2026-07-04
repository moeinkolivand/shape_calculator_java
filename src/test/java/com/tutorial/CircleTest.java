package com.tutorial;
import com.tutorial.shape.calculator.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleTest {
    private final double radius = 10.0;
    private Circle circle;

    @Test
    public void initiateWithNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Circle(-5.0);
        });
    }

    @BeforeEach
    public void createRectangle(){
        circle = new Circle(radius);
    }

    @Test
    public void calculateArea() {
        double exceptedArea = Math.PI * radius * radius;
        assertEquals(exceptedArea, circle.area());
    }

    @Test
    public void calculatePerimeter() {
        double exceptedPerimeter = 2 * Math.PI * radius;
        assertEquals(exceptedPerimeter, circle.perimeter());
    }

}
