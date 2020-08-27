package lesson.CoffeeShop;

public class Latte extends Beverage{
    //Latte单价为4块

    public Latte(Beverage beverage){
        description = "Latte Coffee ";
    }

    @Override
    public double cost() {
        return 4;
    }
}
