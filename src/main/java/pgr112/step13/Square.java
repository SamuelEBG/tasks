package pgr112.step13;

import java.awt.*;

public class Square extends Rectangle {

    // When users enters values in constructor, it sends the parameters to the parent class.
    public Square(double side, Color color, boolean filled, MovablePoint topLeft){
        super(side, side, color, filled, topLeft);
    }
    //It is possible to getLength and width from parent class, since the fields
    //are set to private we cannot access them, but we can access the setters and getters
    public double getSide(){
        return super.getLength();
    }

    public void setSide(double side){
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public double getArea(){return super.getLength() * super.getWidth();}
    public double getPerimeter(){
        return (super.getWidth() + super.getLength()) * 2;
    }

    @Override
    public String toString(){
        return String.format("A square with sides %s coordinates top left %s, and bottom right %s that is a subclass of rectangle with color %s and is filled: %s ",
                super.getWidth(),
                super.getTopLeft(),
                super.getBottomRight(),
                super.getColor(),
                super.isFilled());
    }

    /*
    @Override
    public String toString(){
        return "This is a square with id: " + this.getId() +
                " color: " + this.getColor() +
                " Is it filled: " + this.isFilled() +
                " Width: " + super.getWidth() +
                " Length: " + super.getLength() +
                " Area: " + this.getArea() +
                " Perimeter: " + this.getPerimeter();
    }
    */
}
