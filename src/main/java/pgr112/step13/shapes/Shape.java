package pgr112.step13.shapes;

import java.awt.*;

public abstract class Shape implements Movable {
    private final int id;
    private Color color;  // variable that is protected within class, but
    private boolean filled; // can still be accessed outside of class.

    public static int getCount() {return count;}

    private static int count = 1;

    public Shape(){ // default constructor, sets default values if none are specified
        this.id = count;
        this.color = Color.red; // such as color red
        this.filled = false; // and filled true (because has color)
        count++;
    }

    public Shape( Color color, boolean filled){ //constructor that lets user set values
        this.color = color;                 // such as color
        this.filled = filled;             // and whether filled or not
        this.id = count;
        count++;
    }

    public abstract double getArea();  // abstract method that must have whatever happens in the method
    public abstract double getPerimeter(); // set within the class from where it is called

    // getters and setters
    public int getId(){return this.id;}
    public Color getColor() {return color;}
    public void setColor(Color color) {this.color = color;}
    public boolean isFilled() {return filled;}
    public void setFilled(boolean filled) {this.filled = filled;}

    public String toString(){
        String result = "";
        if(this.isFilled()){
            result = " shape that is filled and has the color " + this.getColor();
        }else if(!this.isFilled()){
            result = " shape that is not filled and has the color " + this.getColor();
        }
        return result;
    }

    /*
    public String toString(){
        return "Shape. " + this.id + " Color: " + this.color + ", filled " + this.filled + "\n";
    }
     */
}
