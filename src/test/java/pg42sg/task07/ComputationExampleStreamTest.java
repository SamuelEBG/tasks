package pg42sg.task07;

import org.pg4200.ex08.ComputationExample;
import org.pg4200.ex08.ComputationExampleTestTemplate;

class ComputationExampleStreamTest extends ComputationExampleTestTemplate {

    @Override
    protected ComputationExample getNewInstance() {
        return new ComputationExampleStream();
    }
}