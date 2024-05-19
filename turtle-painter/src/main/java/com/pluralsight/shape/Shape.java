package com.pluralsight.shape;

import com.pluralsight.util.Turtle;
import com.pluralsight.util.World;

public abstract class Shape {
    // data members
    protected Turtle turtle;
    protected int[]coordinate = new int[2];
    protected String color;
    protected int border;
    protected int width;
    protected int height;


    public Shape(Turtle turtle, int[] coordinate, String color, int border) {
        //  public Turtle(World w, double x, double y)
        this.turtle = new Turtle(new World(width,height), coordinate[0], coordinate[1]);
        this.coordinate = coordinate;
        this.color = color;
        this.border = border;
    }

    // setters and getters
    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // method to paint shape
    public abstract void paint();
}
