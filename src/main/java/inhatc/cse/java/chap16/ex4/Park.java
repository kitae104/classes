package inhatc.cse.java.chap16.ex4;

public class Park extends Thread {

    @Override
    public void run() {
        System.out.println("예금 작업을 시작합니다.");
        SyncMainTest.myBank.saveMoney(3000);
        System.out.println("saveMoney(3000) 작업이 진행되어 잔액이 " + SyncMainTest.myBank.getMoney() + "입니다.");
    }

}
