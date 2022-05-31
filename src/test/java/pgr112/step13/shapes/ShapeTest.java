package pgr112.step13.shapes;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testAddAndEditRectangle(){

        Rectangle r1 = new Rectangle(
                5, 10, Color.GREEN, false, new MovablePoint(3.0, 5.0));

        r1.setId(5);
        assertEquals(5, r1.getId());

        r1.setFilled(true);
        assertTrue(r1.isFilled());

        r1.setColor(new Color(255,255,0));
        assertEquals(Color.YELLOW, r1.getColor());

        System.out.println(r1.getBottomRight());
    }

    @Test
    void testAddAndEditSquare(){

        Square s1 = new Square(5, Color.BLUE, true, new MovablePoint(10, 20));

        s1.setId(10);
        assertEquals(10, s1.getId());

        s1.setFilled(false);
        assertFalse(s1.isFilled());

        s1.setColor(Color.GREEN);
        assertEquals(new Color(0,255,0), s1.getColor());

    }
}