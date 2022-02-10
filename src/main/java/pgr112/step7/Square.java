package pgr112.step7;

import java.awt.Color;

public class Square extends Shape{
    private double width, length;

    public Square(){
        super();
        this.width = 1.0;
        this.length = 1.0;
    }

    public Square(Color color, boolean filled, double width, double length){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getLength(){
        return this.length;
    }
    public void setLength(double length){
        this.length = length;
    }

    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }

    public double getArea(){
        return width * length;
    }

    public double getPerimeter(){
        return (width + length) * 2;
    }

    @Override
    public String toString(){
        return "This is a square with id: " + this.getId() +
                " color: " + this.getColor() +
                " Is it filled: " + this.isFilled() +
                " Width: " + this.width +
                " Length: " + this.length +
                " Area: " + this.getArea() +
                " Perimeter: " + this.getPerimeter();
    }
}
