package pgr112.coffeMaker;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCoffeeMaker {

    protected Map<CoffeeType, CoffeeConfiguration> configMap;
    
    public AbstractCoffeeMaker(){
        this.configMap = new HashMap<CoffeeType, CoffeeConfiguration>();
    }

    public abstract Coffee brewCoffee(CoffeeType coffeeType);
}
