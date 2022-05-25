package pgr112.coffeMaker;

public class Coffee {

    private CoffeeType coffeeType;
    private int quantity;

    public Coffee(CoffeeType coffeeType, int quantity) {
        this.coffeeType = coffeeType;
        if(quantity < 1){
            throw new IllegalArgumentException("You need to add at least 1 coffee");
        } else{
            this.quantity = quantity;
        }
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
