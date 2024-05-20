import com.pluralsight.shape.Circle;
import com.pluralsight.shape.Square;
import com.pluralsight.shape.Triangle;

import java.util.Scanner;

public class MainApp
{
    // make scanner accessible to all methods
    static Scanner scanner = new Scanner(System.in);

    // ************************* Start of program **************************
    public static void main(String[] args)
    {
        System.out.println("\n** DISCLAIMER** recommended to say within (0,0) if width & height " +
                "\n are both around 300 or else shape will draw out of bounds\n";
        getUserShape();

    }

    public static void getUserShape(){

        while (true){
            displayOptions();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" : getInput("square");
                    break;
                case "2" : getInput("triangle");
                    break;
                case "3" : getInput("circle");
                    break;
                case "0" : System.out.println("Thank you! Have a nice day! ");
                    return;
                default : System.out.println(" ** Invalid input! Try again! :) ** ");
                    break;
            }
        }

    }

    public static void getInput(String type){

            System.out.print("x axis: ");
            int x = scanner.nextInt();
            System.out.print("y axis: ");
            int y = scanner.nextInt();
            int[] cord = {x,y};
            System.out.print("Border width(pen width): ");
            int border = scanner.nextInt();
            System.out.println("Try to do a width/height around 300+ To not get a small canvas");
            System.out.print("Width: ");
            int width = scanner.nextInt();
            System.out.print("Height: ");
            int height = scanner.nextInt();
            scanner.nextLine();
            // 400 at least
            System.out.print("Color: ");
            String color = scanner.nextLine().toLowerCase();

        if(type.equals("square") || type.equals("triangle")){
            getShapeInfo(type,cord,border,width,height,color);
        }

        if(type.equals("circle")){
            System.out.print("Radius: ");
            int radius = scanner.nextInt();
            scanner.nextLine();
            getShapeInfo(cord,border,width,height,color,radius);
        }

    }

    public static void getShapeInfo(String type,int[]cord, int border, int width, int height, String color){
        if(type.equals("square")){
            // int[] coordinate, String color, int border, int width, int height
            Square square = new Square(cord,color,border,width,height);
            square.setColor();
            square.paint();
        } else {
            // int[] coordinate, String color, int border, int width, int height
            Triangle triangle = new Triangle(cord,color,border,width,height);
            triangle.setColor();
            triangle.paint();
        }
    }

    public static void getShapeInfo(int[]cord, int border, int width, int height, String color, int radius){
        // int[] coordinate, String color, int border, int width, int height, int radius
        Circle circle = new Circle(cord, color, border,width,height,radius);
        circle.setColor();
        circle.paint();
    }

    public static void displayOptions(){
        System.out.println("Please select a shape!");
        System.out.println("(1) Square");
        System.out.println("(2) Triangle");
        System.out.println("(3) Circle ** draws slow for precision **");
        System.out.println("(0) Exit");
        System.out.print("Selection: ");
    }
}
