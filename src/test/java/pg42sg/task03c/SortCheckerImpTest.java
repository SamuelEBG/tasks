package pg42sg.task03c;

import org.junit.jupiter.api.Test;
import org.pg4200.ex03.SortChecker;
import org.pg4200.ex03.SortCheckerTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class SortCheckerImpTest extends SortCheckerTestTemplate {

    @Test
    void isSortedCopy() {
    }

    @Override
    protected SortChecker getNewInstance() {
        return new SortCheckerImp();
    }
}