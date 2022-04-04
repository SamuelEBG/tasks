package pgr112.step7;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args){

        String world = "Hello world";
        System.out.println(world);
        HashMap<String, Shape> shapeMap = new HashMap<>();
        Circle c1 = new Circle(Color.BLUE, true, 2.0);
        var c2 = new Circle(Color.GREEN, true, 2.0);
        var c3 = new Circle();
        Square s1 = new Square();
        var s2 = new Square(Color.BLACK, false, 5.0, 5.0);
        var s3 = new Square(Color.RED, true, 10.0, 24.0);
        Rectangle r1 = new Rectangle();
        var r2 = new Rectangle(5.0, 12.0);
        var r3 = new Rectangle(Color.YELLOW, true, 24.0, 25.2);
        shapeMap.put("1", c1);
        shapeMap.put("2", c2);
        shapeMap.put("3", c3);
        shapeMap.put("4", s1);
        shapeMap.put("5", s2);
        shapeMap.put("6", s3);
        shapeMap.put("7", r1);
        shapeMap.put("8", r2);
        shapeMap.put("9", r3);


        shapeMap.forEach((key, value) -> {
            System.out.println(value);
        });


        Shape circle = new Circle(Color.red, true,15);
        circle.getArea();
        // System.out.println(shapeMap.get("3"));

        /*
        shapeMap.forEach((key, value) -> {
           if(value.getArea() > 4){
               System.out.println(value);
           }
        });
        */

        /*
        shapeMap.forEach((key, value) -> {
            if(value.getPerimeter() > 13){
                System.out.println(value);
            }
        });
        */
    }
}
