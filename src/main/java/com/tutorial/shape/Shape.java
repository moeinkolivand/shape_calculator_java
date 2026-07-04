package com.tutorial.shape;


public abstract class Shape {
    protected String name;

    public abstract double area();
    public abstract double perimeter();

    public void describe() {
        System.out.println("The Shape Name Is " + getClass().getSimpleName() + " The Area Is " + area() + " And The Perimeter Is " + perimeter());
    }
}
