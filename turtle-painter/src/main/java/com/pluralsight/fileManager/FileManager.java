package com.pluralsight.fileManager;

import com.pluralsight.shape.Circle;
import com.pluralsight.shape.Shape;
import com.pluralsight.shape.Square;
import com.pluralsight.shape.Triangle;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileManager {

    // save image csv
    public void saveImageToFile(Shape shape){
        try{
            String shapeHeadline = "shape|x|y|border|color|width|height";
            String canvasHeadline = "width|height|background";

            String pipe = "|";
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("all-shapes.csv", true));
            bufWriter.write(canvasHeadline);
            bufWriter.newLine();
            bufWriter.write(shape.getWidth() + pipe + shape.getWidth() + pipe + "white");
            bufWriter.newLine();

            // write to file if instance of circle
            if(shape instanceof Circle){
                // circle headline
                bufWriter.write(shapeHeadline + pipe + "radius");
                // down cast from Shape arraylist
                Circle circle = (Circle) shape;
                bufWriter.newLine();
                bufWriter.write("circle" + pipe + circle.getCoordinate()[0] + pipe +
                        circle.getCoordinate()[1] + pipe + circle.getBorder() + pipe +
                        circle.getColor() + pipe + circle.getWidth() + pipe +
                        circle.getHeight() + pipe + circle.getRadius());
            }

            // write to file if instance of square
            if (shape instanceof Square){
                // regular headline
                bufWriter.write(shapeHeadline);
                // down cast from Shape arraylist
                Square square = (Square) shape;
                bufWriter.newLine();
                bufWriter.write("square" + pipe + square.getCoordinate()[0] + pipe +
                        square.getCoordinate()[1] + pipe + square.getBorder() + pipe +
                        square.getColor() + pipe + square.getWidth() + pipe +
                        square.getHeight());
            }

            // write to file if instance of triangle
            if (shape instanceof Triangle){
                // regular headline
                bufWriter.write(shapeHeadline);
                // down cast from Shape arraylist
                Triangle triangle = (Triangle) shape;
                bufWriter.newLine();
                bufWriter.write("triangle" + pipe + triangle.getCoordinate()[0] + pipe +
                        triangle.getCoordinate()[1] + pipe + triangle.getBorder() + pipe +
                        triangle.getColor() + pipe + triangle.getWidth() + pipe +
                        triangle.getHeight());
            }
            bufWriter.flush();
            bufWriter.newLine();
            // close buffer
            bufWriter.close();
        } catch (Exception e){
            System.out.println("Error saving image to file");
        }

    }

    // open the image method
    public void openImageFromFile(){

    }

}
