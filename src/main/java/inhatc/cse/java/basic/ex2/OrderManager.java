package inhatc.cse.java.basic.ex2;

public class OrderManager {

    private CarMaker maker;

    public void setMaker(CarMaker maker) {
        this.maker = maker;
    }

    public void order() {
        // 돈 준비
        Money money = new Money(1000);
        System.out.println("판매상 : ((비용)) " + money.getAmount());
        System.out.println("판매상 : ((지불)) " + money.getAmount());

        // 차 구매
        Car car = maker.sell(money);
        System.out.println("판매상 : ((인수)) " + car.getName() );
    }
}
