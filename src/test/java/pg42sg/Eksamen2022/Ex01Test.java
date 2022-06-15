package pg42sg.Eksamen2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {

    protected Ex01 getNewInstance(){
        return new Ex01();
    }

    @Test
    void testEx01(){

        String regex = getNewInstance().regexPartA();

        assertTrue("/pg4200algorithms/lessons/src/test/java/org/pg4200/les10/regex/MatcherTest.java".matches(regex));
        assertTrue("/lessons/src/test/java/org/pg4200/les09/UndirectedGraphTest.java".matches(regex));
        assertTrue("/solutions/src/test/java/org/pg4200/sol10/RegexExampleImpTest.java".matches(regex));
        assertTrue("/solutions/src/test/java/org/pg4200/sol10/RegexExampleImpTest.cpp".matches(regex));
        assertTrue("/solutions/src/test/java/org/pg4200/sol10/RegexExampleImpTest.kt".matches(regex));

        assertFalse("/pg4200algorithms/lessons/src/main/java/org/pg4200/les10/regex/MatcherTest.java".matches(regex));
        assertFalse("/lessons/src/test/java/org/pg4200/les09/UndirectedGraph.java".matches(regex));
        assertFalse("/solutions/src/test/java/org/pg4200/sol10/RegexExampleImpTest.html".matches(regex));
    }

    @Test
    void testEx02(){

        String regex = getNewInstance().regexPartB();

        assertTrue("@Bogdan: Is everyone ready for the pg4200 exam?".matches(regex));
        assertTrue("@Bogdan: Are the exercises for the PGR112 exam ready?".matches(regex));
        assertTrue("@Sven: When exactly is the next programming exam?".matches(regex));
        assertTrue("@Harald: Where can I find more exercises for the programmering eksamen?".matches(regex));

        assertFalse("@Harald Where can I find more exercises for the programmering eksamen?".matches(regex));
        assertFalse("@Hardrada: Where can I find more ships to invade England?".matches(regex));
        assertFalse("@Napoleon: I don't even know what programmering means, let alone be ready for the exam!".matches(regex));
        assertFalse("@Armfeld: Do we have to conquer Bergen for the HIS4230 exam?".matches(regex));
    }

}