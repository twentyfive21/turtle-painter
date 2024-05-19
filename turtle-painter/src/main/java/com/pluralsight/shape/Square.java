package com.pluralsight.shape;

import java.awt.*;

public class Square extends Shape{
    // constructor
    public Square(int[] coordinate, String color, int border, int width, int height) {
        super(coordinate, color, border, width, height);
    }

    // method to paint shape
    public void paint(){
            int length = 100;
            // set the turtles border width
            turtle.setPenWidth(border);
            // set the turtles color
            // turn to color object string
            Color userColor = getColor(color);
            turtle.setColor(userColor);
            // pen up to not draw
            turtle.penUp();
            // set coordinates
            turtle.goTo(coordinate[0], coordinate[1]);
            // pen down to draw
            turtle.penDown();
            // start drawing top of square
            turtle.forward(length);
            // right side of square
            turtle.turnRight(90);
            turtle.forward(length);
            // bottom of square
            turtle.turnRight(90);
            turtle.forward(length);
            // left side of square
            turtle.turnRight(90);
            turtle.forward(length);
    };

    public Color getColor(String colorChoice){
        return colorMap.getOrDefault(color.toLowerCase(), Color.PINK); // Default to black if color not found
    }
}
