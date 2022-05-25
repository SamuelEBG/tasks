package pgr112.step13;

import pgr112.step13.shapes.Circle;
import pgr112.step13.shapes.MovablePoint;
import pgr112.step13.shapes.Shape;
import pgr112.step13.shapes.Square;
import pgr112.step13.shapes.Rectangle;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndWriteToFile {

    public static void readFromFileAndAddToArray(String filePath, ArrayList<Shape> shapesArray){

        try{
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                // As long as the text file contains a line e.g. hasNext(), we go through the file.
                // Create a string of the nextLine, so that the line with the name of the shape
                // is consumed, then we check against that String to see what kind of shape it is.
                String containsShape = scan.nextLine();
                if(containsShape.equalsIgnoreCase("circle")){
                    shapesArray.add(addCircleFromScanner(scan));
                }
                if(containsShape.equalsIgnoreCase("rectangle")){
                    shapesArray.add(addRectangleFromScanner(scan));
                }
                if(containsShape.equalsIgnoreCase("square")){
                    shapesArray.add(addSquareFromScanner(scan));
                    new MovablePoint(Double.parseDouble(scan.nextLine()),
                            Double.parseDouble(scan.nextLine()));
                }
            }
            scan.close();
        } catch(FileNotFoundException error){
            error.printStackTrace();
        }
    }

    public static Square addSquareFromScanner(Scanner scan){
        return new Square(
            Double.parseDouble(scan.nextLine()),
            new Color(
                    Integer.parseInt(scan.nextLine()),
                    Integer.parseInt(scan.nextLine()),
                    Integer.parseInt(scan.nextLine())
            ),
            Boolean.parseBoolean(scan.nextLine()),
            new MovablePoint(
                    Double.parseDouble(scan.nextLine()),
                    Double.parseDouble(scan.nextLine())
            )
        );
    }

    public static Rectangle addRectangleFromScanner(Scanner scan){
        double width = Double.parseDouble(scan.nextLine());
        double length = Double.parseDouble(scan.nextLine());
        Color color = new Color(
                Integer.parseInt(scan.nextLine()),
                Integer.parseInt(scan.nextLine()),
                Integer.parseInt(scan.nextLine())
        );
        boolean filled = Boolean.parseBoolean(scan.nextLine());
        MovablePoint topLeft = new MovablePoint(
                Double.parseDouble(scan.nextLine()),
                Double.parseDouble(scan.nextLine())
        );
        // Not used, since constructor of rectangle will calculate
        // the bottomRight corner with topLeft position, width and length.
        MovablePoint bottomRight = new MovablePoint(
                Double.parseDouble(scan.nextLine()),
                Double.parseDouble(scan.nextLine())
        );

        return new Rectangle(width, length, color, filled, topLeft);
    }

    public static Circle addCircleFromScanner(Scanner scan){
        Circle circle = new Circle();
        circle.setRadius(Double.parseDouble(scan.nextLine()));
        circle.setColor(new Color(
                Integer.parseInt(scan.nextLine()),
                Integer.parseInt(scan.nextLine()),
                Integer.parseInt(scan.nextLine())
        ));
        circle.setFilled(Boolean.parseBoolean(scan.nextLine()));
        circle.setCenter(new MovablePoint(
                Double.parseDouble(scan.nextLine()),
                Double.parseDouble(scan.nextLine())
        ));

        return circle;
    }
}
