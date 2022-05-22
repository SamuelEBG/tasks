package pgr112.step9new;

public class MovablePoint implements Movable{

    private double x;
    private double y;

    @Override
    public void moveUp(double distance) {
        y += distance;
    }

    @Override
    public void moveDown(double distance) {
        y -= distance;
    }

    @Override
    public void moveLeft(double distance) {
        x -= distance;
    }

    @Override
    public void moveRight(double distance) {
        x += distance;
    }
}
