package lesson.CoffeeShop;

public class OriginalSugar extends CondimentDecorator{

    //OriginalSugar单价2元
    //数量为num

    Beverage beverage;
    int num;

    public OriginalSugar(Beverage beverage, int num){
        this.beverage = beverage;
        this.num = num;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with "+ num + " OriginalSugar";
    }

    @Override
    public double cost() {
        return 2*num + beverage.cost();
    }
}
