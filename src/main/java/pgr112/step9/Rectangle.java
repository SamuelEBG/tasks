package pgr112.step9;

import java.awt.*;

public class Rectangle extends Shape {
    private double width;
    private double length;

    // one of each fields is a aggregation of Movablepoint, which
    // means that for every field there is a y and x position.
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public Rectangle(){
        super();
        this.width = 1.0;
        this.length = 2.0;
    }
/*
    public Rectangle(double width, double length){
        super();
        this.width = width;
        this.length = length;
        this.setColor(Color.GREEN);
    }
*/
    public Rectangle(Color color, boolean filled, double width, double length,
                     MovablePoint topLeft, MovablePoint bottomRight) {

        super(color, filled);
        if(topLeft.getX()>bottomRight.getX()||
                topLeft.getY()< bottomRight.getY()){
            throw new IllegalArgumentException(
                String.format("Invalid positioning of rectrangle: topLeft:%s, BottomRight:%s",
                        topLeft, bottomRight));
        }
        this.width = width;
        this.length = length;
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
    }

    public double getLength(){return this.length;}
    public void setLength(double length){this.length = length;}
    public double getWidth(){return this.width;}
    public void setWidth(double width){this.width = width;}
    public double getArea(){return width * length;}
    public double getPerimeter(){return (width + length) * 2;}
    public MovablePoint getTopLeft() {return topLeft;} // when return is called here it will return 2 parameters, x and y.
    public void setTopLeft(MovablePoint topLeft) {this.topLeft = topLeft;}
    public MovablePoint getBottomRight() {return bottomRight;} // they have a toString method in Movablepoint that will return their position.
    public void setBottomRight(MovablePoint bottomRight) {this.bottomRight = bottomRight;}

    //String concatenation with String.format
    @Override
    public String toString(){
        return String.format("A rectangle with width %s and length %s, coordinates are top left %s, bottom right %s and is a subclass of%s",
                width, length, topLeft, bottomRight, super.toString());
    }
    /*
    @Override
    public String toString(){
        return "A rectangle with color" + this.getColor() +
                " Width: " + this.width +
                " Length: " + this.length +
                " top left corner: " + this.topLeft +
                " bottom right: " + this.bottomRight;
    }
     */

    @Override
    public void moveUp(double distance) {
        topLeft.moveUp(distance);
        bottomRight.moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        topLeft.moveDown(distance);
        bottomRight.moveDown(distance);
    }

    @Override
    public void moveRight(double distance) {
        topLeft.moveRight(distance);
        bottomRight.moveRight(distance);
    }

    @Override
    public void moveLeft(double distance) {
        topLeft.moveLeft(distance);
        bottomRight.moveRight(distance);
    }
}
