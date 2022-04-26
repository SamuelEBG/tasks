package pgr112.step13.shapes;

public class MovablePoint implements Movable {

    private double x, y;
    private int id;

    public MovablePoint(){
        this.x = 0;
        this.y = 0;
        this.id = 0;
    }

    public MovablePoint(double x, double y){
        this.x = x;
        this.y = y;
        this.id = (int) ((100 * x) + (150 * y));
    }

    public int getId(){return this.id;}
    public double getX() {return this.x;}
    public void setX(int x){
        this.x = x;
        this.id = (int) ((100 * x) + (150 * y));
    }

    public double getY() {return this.y;}
    public void setY(int y){
        this.y = y;
        this.id = (int) ((100 * x) + (150 * y));
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
    public String toString() { return String.format("%s,%s", x, y);}

}
