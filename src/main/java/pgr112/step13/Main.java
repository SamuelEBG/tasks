package pgr112.step13;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //var p1 = new Program();
        //p1.run();
        JDBCOps operations = new JDBCOps();
/*
        var c1 = new Circle(5, Color.RED, true, new MovablePoint(2.0, 2.0));
        var s1 = new Square(5, new Color(25, 25, 25), true, new MovablePoint(7.0, 2.0));
        var r1 = new Rectangle(5, 2, Color.GREEN, false, new MovablePoint(2.0, 5.0));
        operations.insertShape(c1);
        operations.insertShape(s1);
        operations.insertShape(r1);
*/
        System.out.println(operations.getAllShapes());
    }
}
