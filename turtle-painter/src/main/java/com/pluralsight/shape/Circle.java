package com.pluralsight.shape;

import java.awt.*;

public class Circle extends Shape{
    private int radius;

    public Circle(int[] coordinate, String color, int border, int width, int height, int radius) {
        super(coordinate, color, border, width, height);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void paint(){
    Color userColor = getColor(color);
    turtle.setColor(userColor);
    turtle.penDown();

    // Assuming you have a Turtle object named "turtle" available
    double angleIncrement = 1.0; // The degree by which the turtle will turn in each step
    double circumference = 2 * Math.PI * radius; // Circumference of the circle

    // Calculate the number of steps needed to complete the circle
    int steps = 360;

    for (int i = 0; i < steps; i++) {
        turtle.turnRight(angleIncrement);
        turtle.forward(circumference / steps); // Move forward by the length of each segment
    }

    }

    public Color getColor(String colorChoice){
        return colorMap.getOrDefault(color.toLowerCase(), Color.PINK); // Default to black if color not found
    }

}
