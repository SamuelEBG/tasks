package pgr112.step13;

import pgr112.step13.dto.CircleDao;
import pgr112.step13.dto.RectangleDao;
import pgr112.step13.dto.SquareDao;
import pgr112.step13.shapes.Circle;
import pgr112.step13.shapes.MovablePoint;
import pgr112.step13.shapes.Rectangle;
import pgr112.step13.shapes.Shape;
import pgr112.step13.shapes.Square;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static pgr112.step13.ReadAndWriteToFile.readFromFileAndAddToArray;

public class Program {
    private final ArrayList<Shape> shapesArray;
    private final String filePath = "tasks/src/main/resources/step13/shapes.txt"; //path to the file that is to be read
    private Boolean running = true;

    public Program(){
        this.shapesArray = new ArrayList<>();
        readFromFileAndAddToArray(filePath, shapesArray);
        addShapesToDb(shapesArray);
    }

    public void addShapesToDb(ArrayList<Shape> shapes){
        CircleDao circleToDb = new CircleDao();
        SquareDao squareToDb = new SquareDao();
        RectangleDao rectangleToDb = new RectangleDao();

        for(int i = 0; i < shapes.size()-1; i++){

            if(shapes.get(i) instanceof Circle){
                try{
                    circleToDb.save((Circle)shapes.get(i));
                } catch(SQLException error){
                    error.printStackTrace();
                }
            }

            if(shapes.get(i) instanceof Square){
                try{
                    squareToDb.save((Square)shapes.get(i));
                } catch (SQLException error){
                    error.printStackTrace();
                }
            }

            if(shapes.get(i) instanceof Rectangle){
                try{
                    rectangleToDb.save((Rectangle)shapes.get(i));
                } catch(SQLException error){
                    error.printStackTrace();
                }
            }
        }
    }

    String menuChoices = """
                1 - Print all shapes\s
                2 - Area for all the shapes\s
                3 - Add a shape\s
                4 - Modify a shape\s
                5 - Print all circles\s
                6 - Print all rectangles\s
                7 - Print all squares\s
                8 - Remove a shape\s
                404 - to exit the program.
                """;

    public void printAllShapesFromDb(){
        ArrayList<Shape> result = new ArrayList<>();
        CircleDao circles = new CircleDao();
        RectangleDao rectangles = new RectangleDao();
        SquareDao squares = new SquareDao();

        try{
            result.addAll(circles.listAll());
            result.addAll(rectangles.listAll());
            result.addAll(squares.listAll());
            result.forEach(System.out :: println);
        } catch (SQLException error){
            error.printStackTrace();
        }
    }



    public void run(){
        // menu();
        System.out.println(menuChoices);
        Scanner input = new Scanner(System.in);
        String choice;
        do{
            choice = input.nextLine();
            switch (choice) {
                case "0" -> System.out.println(menuChoices);
                case "1" -> {
                    System.out.println("Here are the shapes in the Database");
                    System.out.println("-------------------------");
                    printAllShapesFromDb();
                }
                case "2" -> {
                    System.out.println("Add a shape");
                }
                case "3" -> {
                    System.out.println("add shape section");
                    addShape(input);
                }
                case "4" -> {
                    System.out.println("Add shapes to database");
                }

                case "exit" -> {
                    System.out.println("exiting program, au revoir faggot");
                    running = false;
                }
                default -> {
                    System.out.println("That's not a valid input, try again!");
                    System.out.println("or type 0 for menu");
                }
            }
        } while(running);
    }

    /*
    public void addShapes(){
        for(int i = 0; i < fileReader().size(); i++) {
            if(fileReader().get(i).equals("Square")){
                int r = Integer.parseInt(fileReader().get(i+2));
                int g = Integer.parseInt(fileReader().get(i+3));
                int b = Integer.parseInt(fileReader().get(i+4));
                shapesArray.add(new Square(
                        Double.parseDouble(fileReader().get(i+1)),
                        new Color(r, g, b),
                        Boolean.parseBoolean(fileReader().get(i+5)),
                        new MovablePoint(
                                Double.parseDouble(fileReader().get(i+6)),
                                Double.parseDouble(fileReader().get(i+7))
                        )
                ));
            }
            if(fileReader().get(i).equals("Rectangle")){
                int r = Integer.parseInt(fileReader().get(i+3));
                int g = Integer.parseInt(fileReader().get(i+4));
                int b = Integer.parseInt(fileReader().get(i+5));
                shapesArray.add(new pgr112.step13.shapes.Rectangle(
                        Double.parseDouble(fileReader().get(i+1)),
                        Double.parseDouble(fileReader().get(i+2)),
                        new Color(r, g, b),
                        Boolean.parseBoolean(fileReader().get(i+6)),
                        new MovablePoint(
                                Double.parseDouble(fileReader().get(i+7)),
                                Double.parseDouble(fileReader().get(i+8))
                        )
                ));
            }
            if(fileReader().get(i).equals("Circle")){
                int r = Integer.parseInt(fileReader().get(i+2));
                int g = Integer.parseInt(fileReader().get(i+3));
                int b = Integer.parseInt(fileReader().get(i+4));
                shapesArray.add(new Circle(Double.parseDouble(fileReader().get(i+1)),
                        new Color(r, g, b),
                        Boolean.parseBoolean(fileReader().get(i+5)),
                        new MovablePoint(
                                Double.parseDouble(fileReader().get(i+6)),
                                Double.parseDouble(fileReader().get(i+7)))));
            }
        }
    }

     */


    public void addShape(Scanner input){
        System.out.println("What kind of shape do you want to add?");
        String choice = input.nextLine().toLowerCase(Locale.ROOT);
        switch (choice){
            case "circle" ->{
                System.out.println("Give the circle a radius");
                double radius = Double.parseDouble(input.nextLine());
                Color color = inputColor("circle");
                System.out.println("Is the shape filled?");
                boolean filled = filledOrNot();
                MovablePoint dot = dot();
                shapesArray.add(new Circle(
                        radius,
                        color,
                        filled,
                        dot
                ));
                System.out.println("Here is your new Shape " + shapesArray.get(shapesArray.size()-1));
            }
            case "square" -> {
                System.out.println("Give the square sides that are equally long");
                double side = Double.parseDouble(input.nextLine());
                Color color = inputColor("square");
                System.out.println("Is the shape filled?");
                boolean filled = filledOrNot();
                System.out.println("give the square coordinates ");
                MovablePoint topLeft = leftCoordinates();
                shapesArray.add(new Square(
                        side,
                        color,
                        filled,
                        topLeft));
                System.out.println("Here is your new Shape " + shapesArray.get(shapesArray.size()-1));
            }
            case "rectangle" -> {
                double width = widthChoice("rectangle");
                System.out.println("give the rectangle a length");
                double length = Double.parseDouble(input.nextLine());
                Color color = inputColor("rectangle");
                System.out.println("Is the shape filled?");
                boolean filled = filledOrNot();
                System.out.println("give the rectangle coordinates");
                MovablePoint topLeft = leftCoordinates();
                shapesArray.add(new pgr112.step13.shapes.Rectangle(
                        width,
                        length,
                        color,
                        filled,
                        topLeft));
                System.out.println("Here is your new Shape " + shapesArray.get(shapesArray.size()-1));
            }
            default -> {
                System.out.println("thats not a shape, try circle, rectangle or square");
            }
        }
    }

    public MovablePoint dot(){
        Scanner dot = new Scanner(System.in);
        System.out.println("Enter the centers X coordinate");
        double x = Double.parseDouble(dot.nextLine());
        System.out.println("Enter the centers Y coordinate");
        double y = Double.parseDouble(dot.nextLine());
        return new MovablePoint(x, y);
    }

    public double widthChoice(String shape){
        Scanner choice = new Scanner(System.in);
        double width = 0;
        if(shape.equalsIgnoreCase("square")){
            System.out.println("give the sides of the square a length");
            width = Double.parseDouble(choice.nextLine());
        }else if(shape.equalsIgnoreCase("rectangle")){
            System.out.println("give the " + shape + " a width");
            width = Double.parseDouble(choice.nextLine());
        }
        return width;
    }

    public MovablePoint leftCoordinates(){
        Scanner cords = new Scanner(System.in);
        System.out.println("Enter top left X value");
        double x = Double.parseDouble(cords.nextLine());
        System.out.println("Enter top left Y value");
        double y = Double.parseDouble(cords.nextLine());
        return new MovablePoint(x, y);
    }

    public boolean filledOrNot(){
        Scanner yesOrNo = new Scanner(System.in);
        String choice;
        while(true){
            choice = yesOrNo.nextLine();
            if(choice.equalsIgnoreCase("yes")){
                return true;
            }
            if(choice.equalsIgnoreCase("no")){
                return false;
            }
            System.out.println("try again");
        }
    }

    public Color inputColor(String shape){
        Scanner color = new Scanner(System.in);
        System.out.println("Give the " + shape + " a color by entering R, G, B integers between 0-255, start with the R value");
        int r = Integer.parseInt(color.nextLine());
        if(r < 0 || r > 255){
            System.out.println("Apparently you´re too dumb to follow instructions, value is set to a random number.");
            r = (int) (Math.random() * 255);
        }
        System.out.println("Enter a G value");
        int g = Integer.parseInt(color.nextLine());
        if(g < 0 || g > 255){
            System.out.println("Apparently you´re too dumb to follow instructions, value is set to a random number.");
            g = (int) (Math.random() * 255);
        }
        System.out.println("Enter a B value");
        int b = Integer.parseInt(color.nextLine());
        if(b < 0 || b > 255){
            System.out.println("Apparently you´re too dumb to follow instructions, value is set to a random number.");
            b = (int) (Math.random() * 255);
        }
        System.out.printf("Color set to %s, %s, %s%n", r, g, b);
        return new Color(r, g, b);
    }

    /*
    public void menu(){
        System.out.println("1 - Draw all the shapes");
        System.out.println("2 - Get information on the total area of all the Squares");
        System.out.println("3 - Add Shape");
        System.out.println("4 - Move a shape");
        System.out.println("5 - Export info about all shapes. (Including newly added ones)");
        System.out.println("6 - Exit");
    }

     */
}
