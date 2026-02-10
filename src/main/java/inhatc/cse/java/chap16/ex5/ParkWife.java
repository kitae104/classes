package inhatc.cse.java.chap16.ex5;

public class ParkWife extends Thread {
    @Override
    public void run() {
        synchronized (SyncMainTest.myBank) {
            System.out.println("출금 작업을 시작합니다.");
            SyncMainTest.myBank.minusMoney(1000);
            System.out.println("minusMoney(1000) 작업이 진행되어 잔액이 " + SyncMainTest.myBank.getMoney() + "입니다.");
        }
    }
}
