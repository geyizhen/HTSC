package lesson.CoffeeShop;

public abstract class CondimentDecorator extends Beverage{

    //所有装饰者都需重新实现getDescription()方法

    public abstract String getDescription();


}
