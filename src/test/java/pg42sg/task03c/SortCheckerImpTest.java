package pg42sg.task03c;

import org.pg4200.ex03.SortCheckerTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class SortCheckerImpTest extends SortCheckerTestTemplate {

    SortCheckerImp checker = getNewInstance();

    @Override
    protected SortCheckerImp getNewInstance() {
        return new SortCheckerImp();
    }
/*
    @Test
    public void maybeFail(){
        Integer[] original = {3,2,6,4,1};
        Integer[] sorted = {1,2,3,4,5};

        boolean ok = checker.isSortedCopy(original, sorted);
        assertFalse(ok);
    }

    @Test
    public void arrayOfStrings(){
        String[] original = {"abc", "abd", "abb", "bca", "bda", "bbb", "ccd"};
        String[] sorted = {"abb","abc", "",};
    }
 */
}