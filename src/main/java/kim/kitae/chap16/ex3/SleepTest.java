package kim.kitae.chap16.ex3;

public class SleepTest extends Thread{

    public static void main(String[] args) {
        SleepTest test = new SleepTest();
        test.start();
    }

    public void run(){
        for (int i = 1; i < 11; i++) {
            try{
                sleep(1000); // 1초 동안 일시 정지
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.print(i + "\t");
        }
    }
}
