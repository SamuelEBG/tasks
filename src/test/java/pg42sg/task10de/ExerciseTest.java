package pg42sg.task10de;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {

    //Get a instance of the Exercise class, so that we can call the methods
    // inside it to use in the test.
    protected Exercise getNewInstance(){
        return new Exercise();
    }

    @Test
    void testExamExerciseQuestion(){

        String regex = getNewInstance().ExerciseQuestion();

        assertTrue("Exercise 5:\nFile: Ex05.txt".matches(regex));
        assertTrue("Exercise 3:\nFile: Ex03.java".matches(regex));
        assertTrue("Exercise 13:\nFile: Ex13.java".matches(regex));

        assertFalse("Exercise no5:\nFile: Ex05.txt".matches(regex));
        assertFalse("Exercise 5: File: Ex05.txt".matches(regex));
        assertFalse("Exercise 5:\nFile: Ex05.pdf".matches(regex));
        assertFalse("Exercise 5:\nFile: Ex05".matches(regex));
        assertFalse("Exercise 5:\nFile: Ex_something05.txt".matches(regex));
        assertFalse("Blorpblo 5:\nHunh: Ex05.java".matches(regex));
    }

    @Test
    void testBogdanQuestion(){

        String regex = getNewInstance().ExerciseBogdanQuestion();

        assertFalse("".matches(regex));
        assertFalse("@Sven: Why do we need the exercises?".matches(regex));
        assertFalse("@Bogdan: Exercises will be useful in understanding the topic better.".matches(regex));
        assertFalse("@Bogdan - advises that you do all the exercises".matches(regex));
        assertFalse("@Sven: Have you asked @Bogdan about this?".matches(regex));

        assertTrue("@Bogdan: Has everyone completed all 12 pg4200 exercises?".matches(regex));
        assertTrue("@Bogdan: Are there any additional questions about algdat?".matches(regex));
        assertTrue("@Bogdan: Where can I find the solutions for this algorithms exercise?".matches(regex));
        assertTrue("@Bogdan: Did you understand the algorithm well enough to write the code?".matches(regex));
    }
}