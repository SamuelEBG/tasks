package pgr112.step13.shapes;

import java.awt.*;

public abstract class Shape implements Movable {

    private int id;
    private Color color;  // variable that is protected within class, but
    private boolean filled; // can still be accessed outside of class.

    public Shape(){ // default constructor, sets default values if none are specified
        this.color = Color.RED; // such as color red
        this.filled = true; // and filled true (because has color)
    }

    public Shape(Color color, boolean filled){ //constructor that lets user set values
        this.color = color;                 // such as color
        this.filled = filled;             // and whether filled or not
    }

    public abstract double getArea();  // abstract method that must have whatever happens in the method
    public abstract double getPerimeter(); // set within the class from where it is called

    // getters and setters
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    public Color getColor() {return color;}
    public void setColor(Color color) {this.color = color;}
    public boolean isFilled() {return filled;}
    public void setFilled(boolean filled) {this.filled = filled;}

    public String toString(){
        if(this.isFilled()){
            return " filled shape with the color " + this.getColor();
        }
        return " empty shape with the color " + this.getColor();
    }
}
