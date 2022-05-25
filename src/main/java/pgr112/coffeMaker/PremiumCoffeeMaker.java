package pgr112.coffeMaker;

public class PremiumCoffeeMaker extends BasicCoffeeMaker{

    public PremiumCoffeeMaker(){
        this.configMap.put(CoffeeType.FILTER, new CoffeeConfiguration(30, 180));
        this.configMap.put(CoffeeType.ESPRESSO, new CoffeeConfiguration(30, 30));
        this.configMap.put(CoffeeType.AMERICANO, new CoffeeConfiguration(30, 100));
    }

    @Override
    public Coffee brewCoffee(CoffeeType coffeeType){

        switch (coffeeType){
            case AMERICANO -> {
                return brewAmericano(coffeeType);
            }

            case ESPRESSO -> {
                return brewEspresso(coffeeType);
            }

            default -> {
                return super.brewCoffee(coffeeType);
            }
        }
    }

    public Coffee brewAmericano(CoffeeType coffeeType){

        Coffee result = new Coffee(coffeeType, 1);
        return null;
    }

    public Coffee brewEspresso(CoffeeType coffeeType){


        return null;
    }

}
