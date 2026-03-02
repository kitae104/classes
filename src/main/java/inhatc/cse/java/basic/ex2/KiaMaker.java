package inhatc.cse.java.basic.ex2;

public class KiaMaker implements CarMaker {

    @Override
    public Car sell(Money money) {
        System.out.println("기아자동차 : (수금) " + money.getAmount());

        Car car = new Car("K5");
        System.out.println("기아자동차 : (생산) " + car.getName());
        System.out.println("기아자동차 : (판매) " + car.getName());

        return car;
    }
}
