package pgr112.step13;

import java.awt.*;

public class Rectangle extends Shape {
    private double width;
    private double length;

    // one of each field is an aggregation of Movablepoint, which
    // means that for every field there is a y and x position.
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public Rectangle(){
        super();
        this.width = 1.0;
        this.length = 2.0;
    }

    public Rectangle(double width, double length){
        super();
        this.width = width;
        this.length = length;
        this.setColor(Color.GREEN);
    }

    public Rectangle(double width, double length, Color color, boolean filled,
                     MovablePoint topLeft) { //Does not have bottomRight parameter since it's calculated from topLeft coordinates.

        super(color, filled);
        this.width = width;
        this.length = length;
        this.topLeft = topLeft;
        this.bottomRight = new MovablePoint(topLeft.getX()+width, topLeft.getY()-length ); //get coordinates from topLeft
        if(topLeft.getX()>bottomRight.getX()||                                                  //add width to X value, and length to Y value
                topLeft.getY()< bottomRight.getY()){                                            //to get matching bottom right coordinates.
            throw new IllegalArgumentException(
                String.format("Invalid positioning of rectangle: topLeft:%s, BottomRight:%s",
                        topLeft, bottomRight));
        }
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
    public double getTopLeftX(){return topLeft.getX();}
    public double getTopLeftY(){return topLeft.getY();}
    public double getBottomRightX(){return bottomRight.getX();}
    public double getBottomRightY(){return bottomRight.getY();}

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
