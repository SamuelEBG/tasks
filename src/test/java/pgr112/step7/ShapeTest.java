package pgr112.step7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.HashMap;

public class ShapeTest {

    @Test
    public void newTest(){
        HashMap<String, Shape> myMap = new HashMap<>();

        for(Shape shape : myMap.values()){
            double area = shape.getArea();
            double perimeter = shape.getPerimeter();

        }
    }
}
