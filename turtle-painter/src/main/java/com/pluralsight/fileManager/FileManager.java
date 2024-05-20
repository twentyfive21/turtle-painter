package com.pluralsight.fileManager;

import com.pluralsight.shape.Circle;
import com.pluralsight.shape.Shape;

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
            bufWriter.write("width DATA" + pipe + "height DATA" + pipe + "white");
            // shape|x|y|border|color|width|height or radius if circle
            if(shape instanceof Circle){
                // Circle circle = (Circle) shape;
                bufWriter.write(shapeHeadline + pipe + "radius");
                //bufWriter.write();
            } else {
                bufWriter.write(shapeHeadline);
                // bufWriter.write();
            }


        } catch (Exception e){
            System.out.println("Error saving image to file");
        }

    }

    // open the image method
    public void openImageFromFile(){

    }

}
