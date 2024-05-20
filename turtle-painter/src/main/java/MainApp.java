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
        System.out.println("\n**** ʕ•́ᴥ•̀ʔ DISCLAIMER ʕ•́ᴥ•̀ʔ ****\nRecommended to stay within (0,30) - (0,0) if width & height " +
                "\nare both around 300 or else shape will draw out of bounds ****\n");
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
            int radius = 0;
            System.out.print("Color: ");
            String color = scanner.nextLine().toLowerCase();
            System.out.print("x axis: ");
            int x = scanner.nextInt();
            System.out.print("y axis: ");
            int y = scanner.nextInt();
            int[] cord = {x,y};
            System.out.print("Border width(pen width): ");
            int border = scanner.nextInt();
            System.out.println("\n** HINT Try to do a width/height around 350+ To not get a small canvas **\n");
            System.out.print("Width: ");
            int width = scanner.nextInt();
            System.out.print("Height: ");
            int height = scanner.nextInt();
            if(type.equals("circle")) {
                System.out.print("Radius: ");
                radius = scanner.nextInt();
                scanner.nextLine();
                getShapeInfo(cord,color,border,width,height,radius);
            }
            scanner.nextLine();


        if(type.equals("square") || type.equals("triangle")){
            getShapeInfo(type,cord,border,width,height,color);
        }



    }

    public static void getShapeInfo(String type,int[]cord, int border, int width, int height, String color){
        System.out.println("\n~~~~ Drawing shape...Creating magic (ε(*´･ω･)っ†*ﾟ¨ﾟﾟ･*:..☆〜♡॰ॱ ~~~~\n");
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

    public static void getShapeInfo(int[] cord, String color, int border, int width, int height, int radius){
        System.out.println("\n~~~~ Drawing shape...Creating magic (ε(*´･ω･)っ†*ﾟ¨ﾟﾟ･*:..☆〜♡॰ॱ ~~~~\n");
        System.out.println("\n !!! Please wait while circle draws for program to continue !!!\n");
        // int[] coordinate, String color, int border, int width, int height, int radius
        Circle circle = new Circle(cord,color,border,width,height,radius);
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
