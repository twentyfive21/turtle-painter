import com.pluralsight.fileManager.FileManager;
import com.pluralsight.shape.Circle;
import com.pluralsight.shape.Shape;
import com.pluralsight.shape.Square;
import com.pluralsight.shape.Triangle;
import com.pluralsight.util.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    static Scanner scanner = new Scanner(System.in);
    static List<Shape> allShapes = new ArrayList<>();
    static FileManager fileManager = new FileManager();
    static World world;  // Shared World object

    // ************************* START OF PROGRAM **************************

    public static void main(String[] args) {
        System.out.println("\n**** ʕ•́ᴥ•̀ʔ DISCLAIMER ʕ•́ᴥ•̀ʔ ****\nRecommended to stay within (0,30) - (0,0) if width & height " +
                "\nare both around 300 or else shape will draw out of bounds ****\n");
        getMenuChoice();
    }

    // ************************* MAIN MENU CHOICE **************************

    public static void getMenuChoice() {
        while (true) {
            System.out.println("(1) Add Shape");
            System.out.println("(2) Save Image Screenshot");
            System.out.println("(3) Save Current Paintings");
            System.out.println("(4) Open Image");
            System.out.println("(0) Exit");
            System.out.print("Selection: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" : getUserShape();
                    break;
                case "2" : saveImage();
                    break;
                case "3" : savePainting();
                    break;
                case "4" : openImage();
                    return;
                case "0" : System.out.println("Thank you! Have a nice day! ");
                    return;
                default : System.out.println(" ** Invalid input! Try again! :) ** ");
                    break;
            }
        }
    }

    // ************************* GET SHAPE SELECTION **************************

    public static void getUserShape() {
        displayOptions();
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1" : getInput("square");
                break;
            case "2" : getInput("triangle");
                break;
            case "3" : getInput("circle");
                break;
            default : System.out.println(" ** Invalid input! Try again! :( ** ");
                break;
        }
    }

    // ************************* GET SHAPE INPUT **************************

    public static void getInput(String type) {
        int radius = 0;
        System.out.print("Color: ");
        String color = scanner.nextLine().toLowerCase();
        System.out.print("x axis: ");
        int x = scanner.nextInt();
        System.out.print("y axis: ");
        int y = scanner.nextInt();
        int[] cord = {x, y};
        System.out.print("Border width(pen width): ");
        int border = scanner.nextInt();
        System.out.println("\n** HINT Try to do a width/height around 350+ To not get a small canvas **\n");
        System.out.print("Width: ");
        int width = scanner.nextInt();
        System.out.print("Height: ");
        int height = scanner.nextInt();
        scanner.nextLine();
        world = new World(width, height);
        // get radius if circle else create other shapes
        if (type.equals("circle")) {
            System.out.print("Radius: ");
            radius = scanner.nextInt();
            scanner.nextLine();
            getShapeInfo(world, cord, color, border, width, height, radius);
        } else if (type.equals("square") || type.equals("triangle")) {
            getShapeInfo(world, type, cord, border, width, height, color);
        }
    }

    // ********************* CREATE SHAPE OBJECT IF SQUARE OR TRIANGLE **************************

    public static void getShapeInfo(World world, String type, int[] cord, int border, int width, int height, String color) {
        System.out.println("\n~~~~ Drawing shape...Creating magic (ε(*´･ω･)っ†*ﾟ¨ﾟﾟ･*:..☆〜♡॰ॱ ~~~~\n");
        if (type.equals("square")) {
            Square square = new Square(world, cord, color, border, width, height);
            allShapes.add(square);
            square.setColor();
            square.paint();
        } else if (type.equals("triangle")) {
            Triangle triangle = new Triangle(world, cord, color, border, width, height);
            allShapes.add(triangle);
            triangle.setColor();
            triangle.paint();
        }
    }

    // ********************* CREATE SHAPE OBJECT IF CIRCLE **************************

    public static void getShapeInfo(World world, int[] cord, String color, int border, int width, int height, int radius) {
        System.out.println("\n~~~~ Drawing shape...Creating magic (ε(*´･ω･)っ†*ﾟ¨ﾟﾟ･*:..☆〜♡॰ॱ ~~~~\n");
        System.out.println("\n !!! Please wait while circle draws for program to continue !!!\n");
        Circle circle = new Circle(world, cord, color, border, width, height, radius);
        allShapes.add(circle);
        circle.setColor();
        circle.paint();
    }

    // ********************* DISPLAY SHAPE SELECTIONS **************************

    public static void displayOptions() {
        System.out.println();
        System.out.println("\nPlease select a shape!");
        System.out.println("(1) Square");
        System.out.println("(2) Triangle");
        System.out.println("(3) Circle ** draws slow for precision **\n");
        System.out.print("Selection: ");
    }

    // ********************* SAVE PAINTING TO CSV SO IT CAN BE REOPEN MORE **************************

    public static void savePainting() {
        if (allShapes.size() == 0) {
            System.out.println("\n**** No current shapes in inventory ****\n");
        } else {
            System.out.println("\n~~~~ Saving Images... ~~~~\n");
            for (Shape shapeToSave : allShapes) {
                fileManager.saveImageToFile(shapeToSave);
            }
        }
    }

    // ********************* SAVE PAINTING SCREENSHOT *************************

    public static void saveImage() {
        if (allShapes.size() == 0) {
            System.out.println("\n**** No current shapes added to save screenshot ****\n");
        } else {
            System.out.println("\n~~~~ Saving shape screenshot.... ~~~~\n");
            for (Shape shapeToSave : allShapes) {
                shapeToSave.saveWorld();
            }
        }
    }

    // ********************* OPEN ALL IMAGES AND DRAW THEM *************************

    public static void openImage() {
        System.out.println("\n~~~~ Opening Images... ~~~~");
        fileManager.openImageFromFile();
        System.out.println();
        getMenuChoice();
    }
}
