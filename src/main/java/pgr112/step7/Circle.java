package pgr112.step7;

import java.awt.Color;

public class Circle extends Shape {

    private double radius;
    private final double pi = Math.PI;

    public Circle(){
        super();
        this.radius = 1.0;
    }

    public Circle(Color color, boolean filled, double radius){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getPerimeter(){
        return 2 * pi * radius;
    }
    public double getArea(){
        return pi * Math.pow(radius, 2);
    }

    @Override
    public String toString(){
        return "This is a circle with id: " + this.getId() +
                " color: " + this.getColor() +
                " Is it filled: " + this.isFilled() +
                " Radius: " + this.radius +
                " Area: " + this.getArea() +
                " Perimeter: " + this.getPerimeter();
    }
}
