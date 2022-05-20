package pg42sg.task11b;

import org.pg4200.ex11.GradeCompressor;
import org.pg4200.ex11.GradeCompressorTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class GradeCompressorImpTest extends GradeCompressorTestTemplate {

    @Override
    protected GradeCompressor getNewInstance() {
        return new GradeCompressorImp();
    }


}