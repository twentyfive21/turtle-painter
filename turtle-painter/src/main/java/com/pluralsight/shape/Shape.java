package com.pluralsight.shape;

import com.pluralsight.util.Turtle;
import com.pluralsight.util.World;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// class cannot create and object but
public abstract class Shape {
    protected World world;
    protected Turtle turtle;
    protected int[] coordinate = new int[2];
    protected String color;
    protected int border;
    protected int width;
    protected int height;
    protected Map<String, Color> colorMap = new HashMap<>();

    public Shape(World world, int[] coordinate, String color, int border, int width, int height) {
        this.world = world;
        this.turtle = new Turtle(world, coordinate[0], coordinate[1]);
        this.coordinate = coordinate;
        this.color = color;
        this.border = border;
        this.width = width;
        this.height = height;
        setColorMap();
    }

    private void setColorMap() {
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

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

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

    public abstract void paint();

    public void saveWorld() {
        world.saveAs("/Users/tina/pluralsight/java-development/turtle-painter/turtle-painter/canvas/" + LocalDateTime.now() + ".png");
    }

    public void setColor() {
        turtle.setColor(colorMap.getOrDefault(color.toLowerCase(), Color.PINK));
    }
}
