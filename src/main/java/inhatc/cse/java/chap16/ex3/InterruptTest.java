package inhatc.cse.java.chap16.ex3;

public class InterruptTest extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(10);
                System.out.print(i + "\t");
            }
        } catch (InterruptedException e) {
            System.out.println("인터럽트 발생");
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptTest interruptTest = new InterruptTest();
        interruptTest.start();
        Thread.sleep(50);
        interruptTest.interrupt();

    }
}
