package com.pluralsight.fileManager;

import com.pluralsight.shape.Circle;
import com.pluralsight.shape.Shape;
import com.pluralsight.shape.Square;
import com.pluralsight.shape.Triangle;
import com.pluralsight.util.World;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;

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
            System.out.println("\nError saving image to file");
        }

    }

    // open the image method
    public void openImageFromFile(){
    try{
        World world = null;
        BufferedReader bufReader = new BufferedReader(new FileReader("all-shapes.csv"));

        String input = "";

        while((input = bufReader.readLine()) != null){
            // shape|x|y|border|color|width|height|radius

            String[] item = input.split(Pattern.quote("|"));

            if(item[0].equals("square") ||item[0].equals("triangle") || item[0].equals("circle")){
                String type = item[0];
                int x = Integer.parseInt(item[1]);
                int y = Integer.parseInt(item[2]);
                int[] cord = {x,y};
                int border = Integer.parseInt(item[3]);
                String color = item[4];
                int width = Integer.parseInt(item[5]);
                int height = Integer.parseInt(item[6]);
                world = new World(width, height);

                // write to file if instance of circle
                if(type.equals("circle")){
                    int radius = Integer.parseInt(item[7]);
                    Circle circle = new Circle(world,cord,color,border,width,height,radius);
                    circle.setColor();
                    circle.paint();
                }

                // write to file if instance of square
                if (type.equals("square")){
                    Square square = new Square(world,cord,color,border,width,height);
                    square.setColor();
                    square.paint();
                }

                // write to file if instance of triangle
                if (type.equals("triangle")){
                    Triangle triangle = new Triangle(world,cord,color,border,width,height);
                    triangle.setColor();
                    triangle.paint();
                }
            }

        }
        // close reader
        bufReader.close();
    }catch(Exception e){
        System.out.println("\n**** Error reading from csv!!! ****");
    }

    }

}
