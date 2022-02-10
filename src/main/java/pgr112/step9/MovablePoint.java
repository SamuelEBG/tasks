package pgr112.step9;

public class MovablePoint implements Movable{

    private double x, y;

    public MovablePoint(double y, double x){
        this.y = y;
        this.x = x;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    @Override
    public void moveUp(double distance){
       this.y += distance;
    }
    @Override
    public void moveDown(double distance){
       this.y -= distance;
    }
    @Override
    public void moveRight(double distance){
       this.x += distance;
    }
    @Override
    public void moveLeft(double distance){
       this.x -= distance;
    }
    @Override
    public String toString() { return String.format("(%s,%s)", x, y);}

}
