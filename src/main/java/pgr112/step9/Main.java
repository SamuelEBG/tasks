package pgr112.step9;

import java.awt.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        String world = "Hello world";
        System.out.println(world);
        Circle c1 = new Circle(Color.green, true, 2.0, new MovablePoint(2.0, 2.0));
        System.out.println(c1);
        Rectangle t1 = new Rectangle(Color.BLACK, false, 3.0, 5.0, new MovablePoint(10.0, 2.0), new MovablePoint(3.0, 12.0));
        System.out.println(t1);
        Square s1 = new Square(Color.GREEN, false, 3.0, new MovablePoint(3.0,0.0), new MovablePoint(0.0, 3.0));
        System.out.println(s1);
        c1.moveLeft(5);
        System.out.println(c1);
        c1.moveUp(8);
        System.out.println(c1);
    }
}
