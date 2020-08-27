package lesson.CoffeeShop;

public class Roast extends Beverage{

    //Roast单价为13块
    public Roast(Beverage beverage){
        description = "Roast Coffee ";
    }

    @Override
    public double cost() {
        return 13;
    }
}
