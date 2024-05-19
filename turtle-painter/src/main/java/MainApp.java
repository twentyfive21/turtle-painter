import com.pluralsight.shape.Shape;
import com.pluralsight.shape.Square;
import com.pluralsight.util.Turtle;
import com.pluralsight.util.World;

import java.awt.*;

public class MainApp
{
    public static void main(String[] args)
    { // This starter code to get you familiar with how

        // The world is your canvas
        World world = new World(200, 200);
        Turtle turtle = new Turtle(world,-100, -100);

        int w = 200;
        int h = 200;

        // calculate the hypotenuse (diagonal)
        // a2 + b2 = c2
        double widthSquared = Math.pow(w, 2);
        double heightSquared = Math.pow(h, 2);
        double hypotenuse = Math.sqrt(widthSquared + heightSquared);

        // turtle.forward(hypotenuse);
        // turtle.goTo(100, 100);

        // ************************* Start of program **************************
        // Turtle turtle, int[] coordinate, String color, int border, int width, int height
        // inputs to ask for
        int x = 0;
        int y = 0;
        int[] cord = {x,y};
        int width = 400;
        int border = 400;
        int height = 400;
        String color = "pink";

        // create object
        Square square = new Square(cord, color, border, width,height);
        // set all colors for square
        square.setColor();
        square.paint();
    }
}
