package inhatc.cse.java.chap16.ex2;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        int i;
        for(i=0; i<=200; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i );
        }
    }
}
