package com.pluralsight.shape;

import java.awt.*;
import java.util.Arrays;

public class Circle extends Shape{
    // private data members
    private int radius;

    // constructor
    public Circle(int[] coordinate, String color, int border, int width, int height, int radius) {
        super(coordinate, color, border, width, height);
        this.radius = radius;
    }

    // setters and getters
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // override from super class the paint method
    @Override
    public void paint(){
    // set pen width
    turtle.setPenWidth(border);
    // get color object
    Color userColor = getColor(color);
    // set color to draw
    turtle.setColor(userColor);
    // pen down to start trail
    turtle.penDown();
    // calculate circle
    double angleIncrement = 1.0; // The degree by which the turtle will turn in each step
    double circumference = 2 * Math.PI * radius; // Circumference of the circle

    // Calculate the number of steps needed to complete the circle
    int steps = 360;

    // loop to draw circle
    for (int i = 0; i < steps; i++) {
        turtle.turnRight(angleIncrement);
        turtle.forward(circumference / steps); // Move forward by the length of each segment
    }

    }

    // method to get color object
    public Color getColor(String colorChoice){
        return colorMap.getOrDefault(color.toLowerCase(), Color.PINK); // Default to pink if color not found
    }

    @Override
    public String toString() {
        return "Circle{" +
                "height=" + height +
                ", width=" + width +
                ", border=" + border +
                ", color='" + color + '\'' +
                ", coordinate=" + Arrays.toString(coordinate) +
                ", radius=" + radius +
                '}';
    }
}
