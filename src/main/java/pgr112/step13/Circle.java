package pgr112.step13;

import java.awt.*;

public class Circle extends Shape {

    private MovablePoint center;
    private double radius;
    private final double pi = Math.PI;

    public Circle(){
        super();
        this.radius = 1.0;
    }

    public Circle(double radius, Color color, boolean filled, MovablePoint center){
        super(color, filled);
        this.radius = radius;
        this.center = center;
    }

    public MovablePoint getCenter() {return center;}
    public void setCenter(MovablePoint center) {this.center = center;}
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
        return String.format("A circle with radius: %s and center coordinates %s that is a subclass of%s",
                radius, center, super.toString());
    }
    // Since we have made Shape implement the interface Movable, we have to
    // implement the abstract methods from Movable, because neither
    // shapes are Abstract.
    @Override
    public void moveUp(double distance) {
        center.moveUp(distance);
    }
    @Override
    public void moveDown(double distance) {
        center.moveDown(distance);
    }
    @Override
    public void moveRight(double distance) {
        center.moveRight(distance);
    }
    @Override
    public void moveLeft(double distance) {
        center.moveLeft(distance);
    }

    /*
    @Override
    public String toString(){
        return "Shape circle: " +
                " color: " + this.getColor() +
                " Is it filled: " + this.isFilled() +
                " Radius: " + this.radius +
                " Area: " + this.getArea() +
                " Perimeter: " + this.getPerimeter();
    }
    */
}
