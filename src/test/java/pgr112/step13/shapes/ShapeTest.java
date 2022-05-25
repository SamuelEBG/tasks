package pgr112.step13.shapes;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ShapeTest {

    @Test
    void testAddAndEditCircle(){

        Circle c1 = new Circle(5, Color.RED, true, new MovablePoint(5,10));

        int newRadius = 10;
        assertEquals(5, c1.getRadius());

        c1.setRadius(10);
        assertEquals(newRadius, c1.getRadius());

        c1.setColor(new Color(255, 255, 255));
        assertEquals(Color.WHITE, c1.getColor());

        boolean notFilled = false;
        c1.setFilled(notFilled);
        assertFalse(c1.isFilled());

        double yCord = c1.getCenter().getY();
        assertEquals(10, yCord);

        c1.moveUp(5.0);
        assertEquals(15, c1.getCenter().getY());

        c1.moveLeft(5);
        assertEquals(0, c1.getCenter().getX());
    }
}