package inhatc.cse.java.basic.ex1;

public class KiaMaker {
    public Car sell(Money money) {
        System.out.println("기아자동차 : (수금) " + money.getAmount());

        Car car = new Car("K5");
        System.out.println("기아자동차 : (생산) " + car.getName());
        System.out.println("기아자동차 : (판매) " + car.getName());

        return car;
    }
}
