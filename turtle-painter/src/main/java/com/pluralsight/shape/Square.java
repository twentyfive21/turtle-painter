package com.pluralsight.shape;

import com.pluralsight.util.World;

import java.awt.*;
import java.util.Arrays;

public class Square extends Shape {
    public Square(World world, int[] coordinate, String color, int border, int width, int height) {
        super(world, coordinate, color, border, width, height);
    }

    @Override
    public void paint() {
        int length = 100;
        turtle.setPenWidth(border);
        Color userColor = getColor(color);
        turtle.setColor(userColor);
        turtle.penUp();
        turtle.goTo(coordinate[0], coordinate[1]);
        turtle.penDown();
        turtle.forward(length);
        turtle.turnRight(90);
        turtle.forward(length);
        turtle.turnRight(90);
        turtle.forward(length);
        turtle.turnRight(90);
        turtle.forward(length);
    }

    public Color getColor(String colorChoice) {
        return colorMap.getOrDefault(color.toLowerCase(), Color.PINK);
    }

    @Override
    public String toString() {
        return "Square{" +
                "coordinate=" + Arrays.toString(coordinate) +
                ", color='" + color + '\'' +
                ", border=" + border +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
