package inhatc.cse.java.chap16.ex4;

public class SyncMainTest {

    public static Bank myBank = new Bank();

    public static void main(String[] args) throws InterruptedException {
        Park park = new Park();
        park.start();

        Thread.sleep(200); // 메인 스레드가 0.2초 일시 정지

        ParkWife parkWife = new ParkWife();
        parkWife.start();
    }
}
