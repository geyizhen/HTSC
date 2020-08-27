package lesson.CoffeeShop;

public class VanillaSugar extends CondimentDecorator{

    //OriginalSugar单价2.5元
    //数量为num

    Beverage beverage;
    int num;

    public VanillaSugar(Beverage beverage, int num){
        this.beverage = beverage;
        this.num = num;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with "+ num + " VanillaSugar";
    }

    @Override
    public double cost() {
        return 2.5 * num + beverage.cost();
    }
}
