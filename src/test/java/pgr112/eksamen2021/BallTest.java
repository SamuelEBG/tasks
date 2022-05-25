package pgr112.eksamen2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    Program pr;

    @BeforeEach
    void setup(){
        pr = new Program();
    }

    @Test
    void testSizeOfBalls(){

        List<Equipment> balls = pr.equipment.stream()
                .filter(equipment -> equipment instanceof Ball)
                .toList();

        List<Equipment> rackets = pr.equipment.stream()
                .filter(equipment -> equipment instanceof TableTennisRacket)
                .toList();

        assertEquals(pr.equipment.size() - rackets.size(), balls.size());
    }

    @Test
    void testBalls(){

        Ball ball = (Ball) pr.equipment.get(3);

        assertFalse(ball.isNeedsAir());

        ball.setNeedsAir(true);

        assertTrue(ball.isNeedsAir());

        ball.setBallType(BallType.Basketball);

        assertEquals(BallType.Basketball, ball.getBallType());
    }

    @Test
    void testMakingNewEquipment(){

        Ball ball = new Ball(5,2,true, BallType.Football, true);

        ball.setId(23);

        assertEquals(23, ball.getId());

        ball.setLocker(1);

        assertNotEquals(2, ball.getId());
    }

    @Test
    void testMakingMoreEquipment(){

        TableTennisRacket tbr = new TableTennisRacket(
                2, 5, true, true);

        tbr.setNeedsNewCoating(false);
        assertNotEquals(true, tbr.isNeedsNewCoating());

        tbr.setNeedsReplacement(false);
        assertNotEquals(true, tbr.isNeedsReplacement());

    }

}