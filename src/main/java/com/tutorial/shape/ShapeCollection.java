package com.tutorial.shape;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShapeCollection {
    private List<Shape> shapes = new ArrayList<Shape>();

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public double totalArea() {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }

    public Shape largestShape() {
        return shapes.stream().max(Comparator.comparing(Shape::area)).orElse(null);
    }

    public void printAllDescriptions() {
        shapes.forEach(Shape::describe);
    }
}
