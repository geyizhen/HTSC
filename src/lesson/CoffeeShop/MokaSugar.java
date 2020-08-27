package lesson.CoffeeShop;

public class MokaSugar extends CondimentDecorator{
    //MokaSugar单价4元
    //数量为num

    Beverage beverage;
    int num;

    public MokaSugar(Beverage beverage, int num){
        this.beverage = beverage;
        this.num = num;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with " + num + " MokaSugar";
    }

    @Override
    public double cost() {
        return 4 * num + beverage.cost();
    }
}
