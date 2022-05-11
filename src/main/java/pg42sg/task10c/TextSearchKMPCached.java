package pg42sg.task10c;

import org.pg4200.les10.search.TextSearchKMP;

import java.util.HashMap;
import java.util.Map;

public class TextSearchKMPCached extends TextSearchKMP {

    private final Map<String, TextSearchKMP> cache = new HashMap<>();

    public TextSearchKMPCached(){
        super();
    }
    public TextSearchKMPCached(String text){
        super(text);
    }

    @Override
    public int findFirst(String text, String target){

        if(defaultTarget != null && defaultTarget.equals(target)){
            return findFirst(text);
        }

        TextSearchKMP kmp = cache.get(target);

        if(kmp == null){
            kmp = new TextSearchKMPCached(target);
            cache.put(target, kmp);
        }

        return kmp.findFirst(text);
    }
}
