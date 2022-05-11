package pg42sg.task10c;

import org.junit.jupiter.api.Test;
import org.pg4200.les10.search.TextSearch;
import org.pg4200.les10.search.TextSearchTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class TextSearchKMPCachedTest extends TextSearchTestTemplate {

    @Override
    protected TextSearch getNewInstance(){
        return new TextSearchKMPCached();
    }

    @Override
    protected TextSearch getNewInstance(String target) {
        return new TextSearchKMPCached(target);
    }

}