package pgr112.step9;

import java.awt.*;

public class Square extends Rectangle {

    // When users enters values in constructor, it sends the parameters to the parent class.
    public Square(Color color, boolean filled, double side, MovablePoint topLeft, MovablePoint bottomRight){
        super(color, filled, side, side, topLeft, bottomRight);
    }
    //Its possible to getLength and width from parentclass, since the fields
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
        return String.format("A Square with width %s, length %s %s ",
                super.getWidth(), super.getLength(), super.toString());
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
