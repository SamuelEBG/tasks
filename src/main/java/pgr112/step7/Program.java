package pgr112.step7;

import java.awt.*;
import java.util.HashMap;

public class Program {

    public HashMap<String, Shape> myMap;

    public Program(){
        myMap = new HashMap<>();
        addShapes();
    }

    public void addShapes(){
        Circle c1 = new Circle(Color.BLUE, true, 2.0);
        var c2 = new Circle(Color.GREEN, true, 2.0);
        var c3 = new Circle();
        Square s1 = new Square();
        var s2 = new Square(Color.BLACK, false, 5.0, 5.0);
        var s3 = new Square(Color.RED, true, 10.0, 24.0);
        Rectangle r1 = new Rectangle();
        var r2 = new Rectangle(5.0, 12.0);
        var r3 = new Rectangle(Color.YELLOW, true, 24.0, 25.2);
        myMap.put("1", c1);
        myMap.put("2", c2);
        myMap.put("3", c3);
        myMap.put("4", s1);
        myMap.put("5", s2);
        myMap.put("6", s3);
        myMap.put("7", r1);
        myMap.put("8", r2);
        myMap.put("9", r3);
    }
}
