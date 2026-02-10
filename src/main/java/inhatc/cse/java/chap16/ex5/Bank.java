package inhatc.cse.java.chap16.ex5;

public class Bank {

    private int money = 10000;

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public synchronized void saveMoney(int save) {

        int m = this.getMoney();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setMoney(m + save);
    }

    public synchronized void minusMoney(int minus) {

        int m = this.getMoney();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoney(m - minus);
    }
}
