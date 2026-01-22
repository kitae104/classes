package kim.kitae.chap16.ex2;

public class MyRunnableTest {

    public static void main(String[] args) {
        System.out.println("main start");

        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        System.out.println("main end");
    }
}
