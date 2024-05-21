package com.pluralsight.shape;

import com.pluralsight.util.World;

import java.awt.*;
import java.util.Arrays;

public class Triangle extends Shape {
    public Triangle(World world, int[] coordinate, String color, int border, int width, int height) {
        super(world, coordinate, color, border, width, height);
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

        // saveWorld(); // Remove or comment out this line
    }

    // get color object
    public Color getColor(String colorChoice){
        return colorMap.getOrDefault(color.toLowerCase(), Color.PINK); // Default to black if color not found
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "coordinate=" + Arrays.toString(coordinate) +
                ", color='" + color + '\'' +
                ", border=" + border +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
