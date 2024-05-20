package com.pluralsight.shape;

import java.awt.*;

public class Triangle extends Shape{

    public Triangle(int[] coordinate, String color, int border, int width, int height) {
        super(coordinate, color, border, width, height);
    }

    @Override
    public void paint(){
        // preset length
        int length = 100;

        // pen up and move to starting point
        turtle.setPenWidth(border);
        Color userColor = getColor(color);
        turtle.setColor(userColor);
        // draw base of triangle
        turtle.forward(length);
        // turn and draw right side of triangle
        turtle.turnLeft(120);
        turtle.forward(length);
        // turn and draw left side
        turtle.turnLeft(120);
        turtle.forward(length);

    }

    // get color object
    public Color getColor(String colorChoice){
        return colorMap.getOrDefault(color.toLowerCase(), Color.PINK); // Default to black if color not found
    }
}
