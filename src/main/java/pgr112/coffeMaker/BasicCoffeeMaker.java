package pgr112.coffeMaker;

import java.util.ArrayList;

public class BasicCoffeeMaker extends AbstractCoffeeMaker{
    protected Grinder grinder;
    protected BrewingUnit brewingUnit;

    public BasicCoffeeMaker(){
        super();
        this.configMap.put(CoffeeType.FILTER, new CoffeeConfiguration(30, 180));
        this.grinder = new Grinder();
        this.brewingUnit = new BrewingUnit();
    }

    @Override
    public Coffee brewCoffee(CoffeeType coffeeType) {
        brewFilterCoffee();
        return null;
    }

    public ArrayList<Coffee> brewCoffee(CoffeeType coffeeType, int number){
        ArrayList<Coffee> result = new ArrayList<>();

        for(int i = 0; i < number; i ++){
            result.add(brewFilterCoffee());
        }
        return result;
    }

    public Coffee brewFilterCoffee(){
        return null;
    }
}
