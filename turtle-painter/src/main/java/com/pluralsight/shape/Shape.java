package com.pluralsight.shape;
import java.util.HashMap;
import java.util.Map;

import com.pluralsight.util.Turtle;
import com.pluralsight.util.World;

import java.awt.*;

public abstract class Shape {
    // data members
    Map<String, Color> colorMap = new HashMap<>();
    protected Turtle turtle;
    protected int[]coordinate = new int[2];
    protected String color;
    protected int border;
    protected int width;
    protected int height;

    public Shape(int[] coordinate, String color, int border, int width, int height) {
        //  public Turtle(World w, double x, double y)
        this.turtle = new Turtle(new World(width,height), coordinate[0], coordinate[1]);
        this.coordinate = coordinate;
        this.color = color;
        this.border = border;
        this.width = width;
        this.height = height;
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

    // set hash map color selections
    public void setColor(){
        colorMap.put("white", Color.WHITE);
        colorMap.put("red", Color.RED);
        colorMap.put("orange", Color.ORANGE);
        colorMap.put("yellow", Color.YELLOW);
        colorMap.put("green", Color.GREEN);
        colorMap.put("blue", Color.BLUE);
        colorMap.put("magenta", Color.MAGENTA);
        colorMap.put("pink", Color.PINK);
        colorMap.put("black", Color.BLACK);
        colorMap.put("cyan", Color.CYAN);
        colorMap.put("light gray", Color.LIGHT_GRAY);
        colorMap.put("dark gray", Color.DARK_GRAY);
        colorMap.put("gray", Color.GRAY);
        colorMap.put("grey", Color.GRAY);
    }
}
